// IDESampleActiveX.cpp : Implementation of IDESampleActiveX

#include "stdafx.h"
#include "IDEPlugInAsActiveX.h"
#include "IDESampleActiveX.h"


/////////////////////////////////////////////////////////////////////////////
// IDESampleActiveX

HRESULT IDESampleActiveX::raw_OnCommand(long nID, IDispatch* pXMLSpy)
{
	return S_OK;
}


HRESULT IDESampleActiveX::raw_OnUpdateCommand(long nID, IDispatch* pXMLSpy, SPYUpdateAction* pAction)
{
	return S_OK;
}


HRESULT IDESampleActiveX::raw_OnEvent(long nEventID, SAFEARRAY** arrayParameters, IDispatch* pXMLSpy, VARIANT* pReturnValue)
{
	if(!m_ipSpyDispatch)
		m_ipSpyDispatch = pXMLSpy;

	if(m_ipSpyDispatch.p)
	{
		CComQIPtr<XMLSpyLib::IApplication>	ipSpyApp(m_ipSpyDispatch);

		CComPtr<XMLSpyLib::IDocument9>	ipDoc;
		
		if(ipSpyApp.p && SUCCEEDED(ipSpyApp->get_ActiveDocument(&ipDoc)) && ipDoc.p)
		{
			XMLSpyLib::SPYViewModes	nViewMode;

			if(SUCCEEDED(ipDoc->get_CurrentViewMode(&nViewMode)))
			{
				if(	(nViewMode == XMLSpyLib::spyViewGrid) ||
					(nViewMode == XMLSpyLib::spyViewAuthentic))
				{
					// If the current document is displayed in GridView or AuthenticView we
					// count the number of different elements and attributes.

					CComPtr<XMLSpyLib::IXMLData1>	ipRoot = ipDoc->RootElement;
					UINT	nXMLDataCount = CountXMLData(ipRoot);

					// An event ID of 2 is fired in GridView whenever an editing operations has finished.

					if(	(nEventID == 2) ||
						(m_nXMLDataCount != nXMLDataCount))
					{
						FillLists(ipDoc);

						m_nXMLDataCount = nXMLDataCount;
					}
				}
				else
				{
					// Otherwise we clear the contents of the ListBoxes

					m_List.DeleteAllItems();
					m_AttrList.DeleteAllItems();

					m_nXMLDataCount = 0;
				}
			}
		}
	}

	return S_OK;
}


HRESULT IDESampleActiveX::raw_GetUIModifications(BSTR* pModificationsXML)
{
	// We don't add any modifications.
	
	CComBSTR	bstrMods = _T("<ConfigurationData><Modifications/></ConfigurationData>");
	return bstrMods.CopyTo(pModificationsXML);
}


HRESULT IDESampleActiveX::raw_GetDescription(BSTR* pDescription)
{
	// The string before the semicolon is also displayed as the title of the generated
	// docking control bar for the IDE PlugIn.
	
	CComBSTR	bstrDescr =
#ifdef BUILDAUTHENTIC
	_T("Authentic PlugIn with ActiveX")
#else
	_T("XMLSpy PlugIn with ActiveX")
#endif
	_T(";Sample PlugIn also having an ActiveX control");
	return bstrDescr.CopyTo(pDescription);
}


LRESULT IDESampleActiveX::OnCreate(UINT uMsg, WPARAM wParam, LPARAM lParam, BOOL& bHandled)
{
	AFX_MANAGE_STATE(::AfxGetStaticModuleState());

	CWnd	wnd; wnd.Attach(m_hWnd);

	CRect	rectClient;
	GetClientRect(&rectClient);

	if(m_List.Create(WS_VISIBLE | WS_BORDER | LVS_REPORT | LVS_SINGLESEL, rectClient, &wnd, 15000))
	{
		m_List.SetExtendedStyle(LVS_EX_FULLROWSELECT);

		m_List.InsertColumn(0, _T("Element"), LVCFMT_LEFT, 150);
		m_List.InsertColumn(1, _T("Count"), LVCFMT_RIGHT, 50);
	}

	if(m_AttrList.Create(WS_VISIBLE | WS_BORDER | LVS_REPORT | LVS_SINGLESEL, rectClient, &wnd, 15001))
	{
		m_AttrList.SetExtendedStyle(LVS_EX_FULLROWSELECT);

		m_AttrList.InsertColumn(0, _T("Attribute"), LVCFMT_LEFT, 150);
		m_AttrList.InsertColumn(1, _T("Count"), LVCFMT_RIGHT, 50);
	}

	wnd.Detach();

	return 0;
}


void IDESampleActiveX::FillLists(XMLSpyLib::IDocument3* ipDoc)
{
	std::vector<TNamesMap>					vecNamesMap;
	std::vector<XMLSpyLib::SPYXMLDataKind>	vecXMLKind;

	CComPtr<XMLSpyLib::IXMLData1>	ipRoot = ipDoc->RootElement;

	if(ipRoot)
	{
		vecXMLKind.push_back(XMLSpyLib::spyXMLDataElement);
		vecXMLKind.push_back(XMLSpyLib::spyXMLDataAttr);

		vecNamesMap.push_back(TNamesMap());
		vecNamesMap.push_back(TNamesMap());

		FillNamesMap(vecNamesMap, ipRoot, vecXMLKind);

		FillListCtrlFromMap(&m_List, vecNamesMap[0]);
		FillListCtrlFromMap(&m_AttrList, vecNamesMap[1]);
	}
}


void IDESampleActiveX::FillNamesMap(std::vector<TNamesMap>& vecNamesMap, XMLSpyLib::IXMLData1* ipXMLData, std::vector<XMLSpyLib::SPYXMLDataKind>& vecKind)
{
	CComPtr<XMLSpyLib::IXMLData>	ipNode = ipXMLData;

	if(ipNode.p)
	{
		if(ipNode->GetHasChildren() == VARIANT_TRUE)
		{
			CComPtr<XMLSpyLib::IXMLData1>	ipChild;

			if(SUCCEEDED(ipNode->raw_GetFirstChild((XMLSpyLib::SPYXMLDataKind)-1, &ipChild)))
			{
				while(true)
				{
					FillNamesMap(vecNamesMap, ipChild.p, vecKind);
					ipChild.Release();

					if(FAILED(ipNode->raw_GetNextChild(&ipChild)))
						break;
				}
			}
		}

		bool	bFound = false;
		size_t	idx = 0;

		for(;idx < vecKind.size();idx++)
		{
			if(ipNode->GetKind() == vecKind[idx])
			{
				bFound = true;
				break;
			}
		}

		if(bFound)
		{
			CString		strName((char *)ipNode->GetName());

			TNamesMap::iterator	iter = vecNamesMap[idx].find(strName);

			if(iter != vecNamesMap[idx].end())
				(*iter).second++;
			else
				vecNamesMap[idx].insert(TNamesMap::value_type(strName, 1));
		}
	}
}


void IDESampleActiveX::FillListCtrlFromMap(CListCtrl* pList, TNamesMap& namesMap)
{
	pList->DeleteAllItems();
	
	if(!namesMap.empty())
	{
		int					nRow = 0;
		TNamesMap::iterator	iter = namesMap.begin();

		while(iter != namesMap.end())
		{
			pList->InsertItem(nRow, (*iter).first);

			CString	strCount; strCount.Format(_T("%d"), (*iter).second);
			pList->SetItemText(nRow, 1, strCount);

			nRow++;
			iter++;
		}
	}
}


UINT IDESampleActiveX::CountXMLData(XMLSpyLib::IXMLData1* ipXMLData)
{
	CComPtr<XMLSpyLib::IXMLData1>	ipNode = ipXMLData;

	if(ipNode.p)
	{
		if(ipNode->GetHasChildren() == VARIANT_TRUE)
		{
			CComPtr<XMLSpyLib::IXMLData1>	ipChild;

			if(SUCCEEDED(ipNode->raw_GetFirstChild((XMLSpyLib::SPYXMLDataKind)-1, &ipChild)))
			{
				UINT	nCount = 1;

				while(true)
				{
					nCount += CountXMLData(ipChild);
					nCount++;

					ipChild.Release();

					if(FAILED(ipNode->raw_GetNextChild(&ipChild)))
						break;
				}

				return nCount;
			}
		}
	}

	return 0;
}

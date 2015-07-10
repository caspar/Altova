// IDESampleActiveX.h : Declaration of the IDESampleActiveX

#ifndef __IDESAMPLEACTIVEX_H_
#define __IDESAMPLEACTIVEX_H_

#include "resource.h"       // main symbols
#include <atlctl.h>

#import "IXMLSpyPlugIn.tlb" no_namespace
#ifdef BUILDAUTHENTIC
#import "Authentic.tlb"
#else
#import "XMLSpy.tlb"
#endif

#include <map>
#include <vector>

typedef std::map<CString, int>	TNamesMap;


/////////////////////////////////////////////////////////////////////////////
// IDESampleActiveX
class ATL_NO_VTABLE IDESampleActiveX : 
	public CComObjectRootEx<CComSingleThreadModel>,
	public IDispatchImpl<IIDESampleActiveX, &IID_IIDESampleActiveX, &LIBID_IDEPLUGINASACTIVEXLib>,
	public CComControl<IDESampleActiveX>,
	public IPersistStreamInitImpl<IDESampleActiveX>,
	public IOleControlImpl<IDESampleActiveX>,
	public IOleObjectImpl<IDESampleActiveX>,
	public IOleInPlaceActiveObjectImpl<IDESampleActiveX>,
	public IViewObjectExImpl<IDESampleActiveX>,
	public IOleInPlaceObjectWindowlessImpl<IDESampleActiveX>,
	public ISupportErrorInfo,
	public IPersistStorageImpl<IDESampleActiveX>,
	public ISpecifyPropertyPagesImpl<IDESampleActiveX>,
	public IQuickActivateImpl<IDESampleActiveX>,
	public IDataObjectImpl<IDESampleActiveX>,
	public IProvideClassInfo2Impl<&CLSID_IDESampleActiveX, NULL, &LIBID_IDEPLUGINASACTIVEXLib>,
	public CComCoClass<IDESampleActiveX, &CLSID_IDESampleActiveX>,
	public IXMLSpyPlugIn
{
public:
	IDESampleActiveX()
	{
		m_bWindowOnly = TRUE;
		m_nXMLDataCount = 0;
	}

DECLARE_REGISTRY_RESOURCEID(IDR_IDESAMPLEACTIVEX)
DECLARE_NOT_AGGREGATABLE(IDESampleActiveX)

DECLARE_PROTECT_FINAL_CONSTRUCT()

BEGIN_COM_MAP(IDESampleActiveX)
	COM_INTERFACE_ENTRY(IIDESampleActiveX)
	COM_INTERFACE_ENTRY(IDispatch)
	COM_INTERFACE_ENTRY(IViewObjectEx)
	COM_INTERFACE_ENTRY(IViewObject2)
	COM_INTERFACE_ENTRY(IViewObject)
	COM_INTERFACE_ENTRY(IOleInPlaceObjectWindowless)
	COM_INTERFACE_ENTRY(IOleInPlaceObject)
	COM_INTERFACE_ENTRY2(IOleWindow, IOleInPlaceObjectWindowless)
	COM_INTERFACE_ENTRY(IOleInPlaceActiveObject)
	COM_INTERFACE_ENTRY(IOleControl)
	COM_INTERFACE_ENTRY(IOleObject)
	COM_INTERFACE_ENTRY(IPersistStreamInit)
	COM_INTERFACE_ENTRY2(IPersist, IPersistStreamInit)
	COM_INTERFACE_ENTRY(ISupportErrorInfo)
	COM_INTERFACE_ENTRY(ISpecifyPropertyPages)
	COM_INTERFACE_ENTRY(IQuickActivate)
	COM_INTERFACE_ENTRY(IPersistStorage)
	COM_INTERFACE_ENTRY(IDataObject)
	COM_INTERFACE_ENTRY(IProvideClassInfo)
	COM_INTERFACE_ENTRY(IProvideClassInfo2)
	COM_INTERFACE_ENTRY(IXMLSpyPlugIn)
END_COM_MAP()

BEGIN_PROP_MAP(IDESampleActiveX)
	PROP_DATA_ENTRY("_cx", m_sizeExtent.cx, VT_UI4)
	PROP_DATA_ENTRY("_cy", m_sizeExtent.cy, VT_UI4)
	// Example entries
	// PROP_ENTRY("Property Description", dispid, clsid)
	// PROP_PAGE(CLSID_StockColorPage)
END_PROP_MAP()

BEGIN_MSG_MAP(IDESampleActiveX)
	MESSAGE_HANDLER(WM_CREATE, OnCreate)
	CHAIN_MSG_MAP(CComControl<IDESampleActiveX>)
	DEFAULT_REFLECTION_HANDLER()
END_MSG_MAP()
// Handler prototypes:
//  LRESULT MessageHandler(UINT uMsg, WPARAM wParam, LPARAM lParam, BOOL& bHandled);
//  LRESULT CommandHandler(WORD wNotifyCode, WORD wID, HWND hWndCtl, BOOL& bHandled);
//  LRESULT NotifyHandler(int idCtrl, LPNMHDR pnmh, BOOL& bHandled);


	LRESULT						OnCreate(
									UINT						uMsg,
									WPARAM						wParam,
									LPARAM						lParam,
									BOOL&						bHandled
								);

// ISupportsErrorInfo
	STDMETHOD(InterfaceSupportsErrorInfo)(REFIID riid)
	{
		static const IID* arr[] = 
		{
			&IID_IIDESampleActiveX,
		};
		for (int i=0; i<sizeof(arr)/sizeof(arr[0]); i++)
		{
			if (InlineIsEqualGUID(*arr[i], riid))
				return S_OK;
		}
		return S_FALSE;
	}

// IViewObjectEx
	DECLARE_VIEW_STATUS(VIEWSTATUS_SOLIDBKGND | VIEWSTATUS_OPAQUE)

// IIDESampleActiveX
public:

	HRESULT OnDraw(ATL_DRAWINFO& di)
	{
		RECT& rc = *(RECT*)di.prcBounds;

		// Resizing is also handled here

		if(::IsWindow(m_List.GetSafeHwnd()) && ::IsWindow(m_AttrList.GetSafeHwnd()))
		{
			// One pixel space between our ListBoxes and the control border

			rc.left++;
			rc.right--;

			CRect	rect = rc;

			// We reserve 2/3 of the control's height for the element ListBox

			rect.top++;
			rect.bottom = ((rc.bottom / 3) * 2) - 1;

			m_List.MoveWindow(&rect);

			// The rest is for the attribute ListBox

			rect.top = rect.bottom + 2;
			rect.bottom = rc.bottom - 2;

			m_AttrList.MoveWindow(&rect);
		}

		return S_OK;
	}


// IXMLSpyPlugIn implementation:
	virtual HRESULT __stdcall	raw_OnCommand(
									long						nID,
									IDispatch*					pXMLSpy
								);

	virtual HRESULT __stdcall	raw_OnUpdateCommand(
									long						nID,
									IDispatch*					pXMLSpy,
									SPYUpdateAction*			pAction
								);

	virtual HRESULT __stdcall	raw_OnEvent(
									long						nEventID,
									SAFEARRAY**					arrayParameters,
									IDispatch*					pXMLSpy,
									VARIANT*					pReturnValue
								);

	virtual HRESULT __stdcall	raw_GetUIModifications(
									BSTR*						pModificationsXML
								);

	virtual HRESULT __stdcall	raw_GetDescription(
									BSTR*						pDescription
								);

// some helper functions:
	void						FillLists(
									XMLSpyLib::IDocument3*		ipDoc
								);

	void						FillNamesMap(
									std::vector<TNamesMap>&					vecNamesMap,
									XMLSpyLib::IXMLData1*					ipXMLData,
									std::vector<XMLSpyLib::SPYXMLDataKind>&	vecKind
								);

	void						FillListCtrlFromMap(
									CListCtrl*					pList,
									TNamesMap&					namesMap
								);
	
	UINT						CountXMLData(
									XMLSpyLib::IXMLData1*		ipXMLData
								);


protected:
	CComPtr<IDispatch>			m_ipSpyDispatch;

	UINT						m_nXMLDataCount;

	CListCtrl					m_List;							// ListBox for XML elements
	CListCtrl					m_AttrList;						// ListBox for XML attributes
};

#endif //__IDESAMPLEACTIVEX_H_

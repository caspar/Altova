using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using XMLSpyLib;

namespace XMLSpyIDEPlugin
{
    public class PlugInClass : XMLSpyPlugInLib.IXMLSpyPlugIn
    {
        #region helpers

        protected string GetPlugInPath()
        {
            string sDLLPath = System.Reflection.Assembly.GetExecutingAssembly().Location;
            return System.IO.Path.GetDirectoryName(sDLLPath);
        }

        public class WindowWrapper : System.Windows.Forms.IWin32Window
        {
            public WindowWrapper(IntPtr handle)
            {
                _hwnd = handle;
            }

            public IntPtr Handle
            {
                get { return _hwnd; }
            }

            private IntPtr _hwnd;
        }

        #endregion

        #region IXMLSpyPlugIn Members

        public string GetDescription()
        {
            return "XMLSpy C# Sample PlugIn; This plugin demonstrates a simple implementation of an IDE plug-in for XMLSpy in C#. It allows to locate the active document in the current Project if present.";
        }

        public string GetUIModifications()
        {
            string sPath = GetPlugInPath();

            // possible IOException not catched
            System.IO.StreamReader myFile = new System.IO.StreamReader(sPath + "\\config.xml");
            string sRet = myFile.ReadToEnd();
            myFile.Close();

            // this replaces the token "**path**" from the XML file with
            // the actual installation path of the plug-in to get the image file
            return sRet.Replace("**path**", sPath);
        }

        public void OnCommand(int nID, object pXMLSpy)
        {
            IApplication2 iApp = (IApplication2)pXMLSpy;
            if (iApp == null)
                return;

            IDocument iDoc = iApp.ActiveDocument;
            if (iDoc == null)
                return;

            bool    bFound = false;
            bool    bDone = false;

            // "Find in project" command
            if (nID == 3 || nID == 6)
            {
                SelectPathInProject(iApp.CurrentProject.RootItems, iApp.ActiveDocument.FullName, true, ref bFound);
                bDone = true;
            }

            // check for "fill green"
            if (nID == 4 || nID == 7)
            {
                iApp.CurrentProject.ClearSelection();

                SelectPathInProject(iApp.CurrentProject.RootItems, iApp.ActiveDocument.FullName, false, ref bFound);
                bDone = true;
            }

            if(nID == 8)
                m_bAutoSelectDoc = !m_bAutoSelectDoc;

            if(bDone && !bFound)
            {
                System.Windows.Forms.MessageBox.Show(new WindowWrapper((IntPtr)iApp.WindowHandle), "The active document is not part of the open project!", "XMLSpy IDE C# Sample PlugIn");
            }

            // release unused objects
            GC.Collect();
        }


        public object OnEvent(int nEventID, ref object[] arrayParameters, object pXMLSpy)
        {
            throw new NotImplementedException();
        }


        public XMLSpyPlugInLib.SPYUpdateAction OnUpdateCommand(int nID, object pXMLSpy)
        {
            XMLSpyPlugInLib.SPYUpdateAction action = XMLSpyPlugInLib.SPYUpdateAction.spyDisable;

            IApplication iApp = (IApplication)pXMLSpy;
            if (iApp == null)
                return action;

            IDocument iDoc = iApp.ActiveDocument;
            if (iDoc == null)
                return action;

            if (iApp.CurrentProject == null)
                return action;

            if(nID == 8)
            {
                if(m_bAutoSelectDoc)
                    action = XMLSpyPlugInLib.SPYUpdateAction.spyEnable|XMLSpyPlugInLib.SPYUpdateAction.spyCheck;
                else
                    action = XMLSpyPlugInLib.SPYUpdateAction.spyEnable|XMLSpyPlugInLib.SPYUpdateAction.spyUncheck;
            }
            else
                action = XMLSpyPlugInLib.SPYUpdateAction.spyEnable;

            string strActiveDoc = GetActiveDocFullPath(iApp);
            string strLastCurrentDoc = m_strCurrentDoc;

            bool bNewActiveDoc = false;
            bool bLastActiveDocEmpty = (m_strCurrentDoc == null) || (m_strCurrentDoc.Length == 0);

            if(!bLastActiveDocEmpty)
            {
                if(!m_strCurrentDoc.Equals(strActiveDoc, StringComparison.OrdinalIgnoreCase))
                {
                    bNewActiveDoc = true;

                    m_strCurrentDoc = strActiveDoc;
                }
            }
            else
            {
                bNewActiveDoc = strActiveDoc.Length > 0;

                if(bNewActiveDoc)
                    m_strCurrentDoc = strActiveDoc;
            }

            if(m_bAutoSelectDoc && bNewActiveDoc)
            {
                bool    bFound = false;
                SelectPathInProject(iApp.CurrentProject.RootItems, iApp.ActiveDocument.FullName, true, ref bFound);
            }

            // release unused objects
            GC.Collect();

            return action;
        }

        #endregion

        long CountItems(IXMLData iParent)
        {
            long nRes = 0;
            for (int nChild = 0; nChild < iParent.CountChildren(); nChild++)
            {
                nRes += 1;
                nRes += CountItems(iParent.GetChild(nChild));
            }
            return nRes;
        }


        void SelectPathInProject(ISpyProjectItems ipProjectItems, string strPath, bool bStopOnFirst, ref bool bFound)
        {
            for(int nIdx = 1; nIdx <= ipProjectItems.Count; nIdx++)
            {
                ISpyProjectItem2 ipItem = ipProjectItems[nIdx];

                if (ipItem != null)
                {
                    string strName = ipItem.Name;
                    SPYProjectItemTypes eItemType = ipItem.ItemType;

                    if (eItemType == SPYProjectItemTypes.spyFolderItem /*2*/)
                    {
                        SelectPathInProject(ipItem.ChildItems, strPath, bStopOnFirst, ref bFound);

                        if(bFound && bStopOnFirst)
                            return;
                    }
                    else if (eItemType == SPYProjectItemTypes.spyUnknownItem /*0*/)
                    {
                    }
                    else if (eItemType == SPYProjectItemTypes.spyFileItem /*1*/)
                    {
                        if (strPath == ipItem.Path)
                        {
                            ipItem.Select(true, bStopOnFirst);
                            bFound = true;

                            if(bStopOnFirst)
                                return;
                        }
                    }
                }
            }
        }


        string GetActiveDocFullPath(IApplication iApp)
        {
	        if(iApp != null)
	        {
                IDocument3 iDoc = iApp.ActiveDocument;

                if(iDoc != null)
                    return iDoc.FullName;
            }

	        return "";
        }

        private string      m_strCurrentDoc;
        private bool        m_bAutoSelectDoc;
    }
}

using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Runtime.InteropServices.ComTypes;
using UModelLib;
using UModelPlugInLib;

/* 
 * DefaultPrefix sample
 * listen for newly added UML data and 
 * set the prefix of properties ('m_') and EnumerationLiterals ('k_')
 * if the corresponding option is turned on
 */

namespace DefaultPrefix
{
    /* UModelDefaultPrefix is the main class of this plugin and implements UModelPlugInLib.IUModelPlugIn
     * it is also responsible for attaching/detaching UModelApplicationEvents to/from UModels IApplication interface
     * and implements the handling of turning on/off the whole "SetPrefix" functionality
     */
    public class UModelDefaultPrefix : UModelPlugInLib.IUModelPlugIn
    {
        // variable which defines whether "SetPrefix" functionality is turned on or off
        bool m_bSetPrefix = true;

        // reference to UModelApplicationEvents; is only used when "SetPrefix" functionality is turned on (to reduce overhead in the other case)
        UModelApplicationEvents m_AppEvents = null;

        #region helpers

        protected string GetPlugInPath()
        {
            string sDLLPath = System.Reflection.Assembly.GetExecutingAssembly().Location;
            return System.IO.Path.GetDirectoryName(sDLLPath);
        }

        #endregion

        // create UModelApplicationEvents and attach it to IApplication
        protected void AttachAppEvents( IApplication iUModelApp )
        {
            if (m_AppEvents == null && iUModelApp != null)
            {
                m_AppEvents = new UModelApplicationEvents();
                m_AppEvents.Attach(iUModelApp);
            }
        }

        // detach UModelApplicationEvents;
        protected void DetachAppEvents()
        {
            if (m_AppEvents != null)
            {
                m_AppEvents.Detach();
                m_AppEvents = null;
            }
        }

        #region IUModelPlugIn Members

        public string GetDescription()
        {
            return "DefaultPrefix sample Plug-in for UModel;This Plug-in demonstrates how to attach to several callback interfaces and how to add a prefix to newly inserted elements.";
        }

        public string GetUIModifications()
        {
            try
            {
                string sPath = GetPlugInPath();

                System.IO.StreamReader myFile = new System.IO.StreamReader(sPath + "\\config.xml");
                string sRet = myFile.ReadToEnd();
                myFile.Close();

                // this replaces the token "**path**" from the XML file with
                // the actual installation path of the plug-in to get the image file
                return sRet.Replace("**path**", sPath);
            }
            catch (System.Exception ex)
            {
                System.Windows.Forms.MessageBox.Show("Error in GetUIModifications:" + ex.Message);
                throw ex;
            }
        }

        public void OnInitialize(object pUModel)
        {
            // before processing DDE or batch commands
        }

        public void OnRunning(object pUModel)
        {
            // DDE or batch commands are processed; application is fully initialized
            // and we can attach UModelApplicationEvents
            AttachAppEvents( (IApplication)pUModel );
        }

        public void OnShutdown(object pUModel)
        {
            // detach UModelApplicationEvents; stop receiving events
            DetachAppEvents();

            // application will shutdown; release all unused objects
            GC.Collect();
        }

        public UModelUpdateAction OnUpdateCommand(int nID, object pUModel)
        {
            UModelUpdateAction action = UModelUpdateAction.UModelUpdateAction_Disable;

            // check if automatically setting the prefix is turned on:
            if (nID == 3 || nID == 4)
            {
                action = UModelUpdateAction.UModelUpdateAction_Enable;

                if (m_bSetPrefix)
                    action |= UModelUpdateAction.UModelUpdateAction_Check;
            }

            // release unused objects
            //GC.Collect(); not necessary since we do not access objects here

            return action;
        }

        public void OnCommand(int nID, object pUModel)
        {
            // toggle automatically setting the prefix:
            if (nID == 3 || nID == 4)
                m_bSetPrefix = !m_bSetPrefix;

            // attach UModelApplicationEvents when "SetPrefix" functionality is turned on; detach otherwise
            if (m_bSetPrefix)
                AttachAppEvents((IApplication)pUModel);
            else
                DetachAppEvents();

            // release unused objects
            GC.Collect();
        }

        #endregion
    }


    /* UModelApplicationEvents is an eventhandler to receive _IApplicationEvents 
     * that we know when UModel documents are opened or closed 
     * and that we can Attach/Detach UModelDataEvents
     * We are interested in all _IApplicationEvents and use a connectionpoint to connect to all these events
     */
    public class UModelApplicationEvents : UModelLib._IApplicationEvents
    {
        // connection point to _IApplicationEvents
        System.Runtime.InteropServices.ComTypes.IConnectionPoint m_cpApplicationEvents = null;
        // connection cookie
        int m_nApplicationtEventsCookie = 0;
        // we always hold a reference to UModelDataEvents
        UModelDataEvents m_UMLDataEvents = new UModelDataEvents();

        public void Attach(IApplication iApp)
        {
            if (m_cpApplicationEvents == null && iApp != null)
            {
                // find connection point of _IApplicationEvents
                IConnectionPointContainer icpc = (IConnectionPointContainer)iApp;
                Guid IID = typeof(UModelLib._IApplicationEvents).GUID;
                icpc.FindConnectionPoint(ref IID, out m_cpApplicationEvents);

                // advise UModelApplicationEvents as sink for _IApplicationEvents
                m_cpApplicationEvents.Advise(this, out m_nApplicationtEventsCookie);

                // also attach UModelDataEvents to the current document and start receiving events there
                m_UMLDataEvents.Attach(iApp.ActiveDocument);
            }
        }
        public void Detach()
        {
            if (m_cpApplicationEvents != null)
            {
                // also detach UModelDataEvents and stop receiving events there
                m_UMLDataEvents.Detach();

                // terminate established connection to _IApplicationEvents
                m_cpApplicationEvents.Unadvise(m_nApplicationtEventsCookie);
                m_cpApplicationEvents = null;
            }
        }

        #region _IApplicationEvents Members
        public void OnNewDocument(Document ipDocument)
        {
            Debug.WriteLine("UModelApplicationEvents.OnNewDocument " + ipDocument.Name);
            // a new document has been created in UModel => (re-)connect UModelDataEvents
            m_UMLDataEvents.Attach(ipDocument);
        }

        public void OnDocumentOpened(Document ipDocument)
        {
            Debug.WriteLine("UModelApplicationEvents.OnDocumentOpened " + ipDocument.Name);
            // a document has been opened in UModel => (re-)connect UModelDataEvents
            m_UMLDataEvents.Attach(ipDocument);
        }

        public void OnDocumentClosed(Document ipDocument)
        {
            Debug.WriteLine("UModelApplicationEvents.OnDocumentClosed " + ipDocument.Name);
            // document has been closed in UModel => disconnect UModelDataEvents
            m_UMLDataEvents.Detach();
        }

        public void OnShutdown()
        {
            Debug.WriteLine("UModelApplicationEvents.OnShutdown");
        }

        #endregion
    }


    /* UModelDataEvents is an eventhandler to receive _IUMLDataEvents 
     * from the root-package and all its children.
     * We are only interested in 'OnAfterAddChild' events, so we use a delegate to connect to this event.
     */
    public class UModelDataEvents : UModelLib._IUMLDataEvents
    {
        // hold a reference to the current UML Root package; this is safe as long as we listen to when it is deleted
        protected UMLData m_RootPackage = null;

        // attach this eventhandler to the root-package of the (current) document
        public void Attach(IDocument iDoc)
        {
            if (m_RootPackage == null && iDoc != null && iDoc.RootPackage != null)
            {
                // hold a reference to the current UML Root package
                m_RootPackage = (UMLData)iDoc.RootPackage;

                // ensure we get 'OnAfterAddChild' events for *any* added child of the rootpackage 
                // (added to the root-package or one of its children)
                m_RootPackage.EventFilter = (int)ENUMUMLDataEventFilter.eUMLDataEvent_AddChildOrGrandChild;
                // ensure we get informed when m_RootPackage (and only itself; we do not care about its chidlren) is deleted
                m_RootPackage.EventFilter |= (int)ENUMUMLDataEventFilter.eUMLDataEvent_EraseData;

                // we are only interested in 'OnAfterAddChild' and 'OnBeforeErase' events so use and connect the delegates
                m_RootPackage.OnAfterAddChild += new _IUMLDataEvents_OnAfterAddChildEventHandler(OnAfterAddChild);
                m_RootPackage.OnBeforeErase += new _IUMLDataEvents_OnBeforeEraseEventHandler(OnBeforeErase);
            }
        }

        // detach eventhandler from the current UML Root package
        public void Detach()
        {
            if (m_RootPackage != null)
            {
                m_RootPackage.OnAfterAddChild -= OnAfterAddChild;
                m_RootPackage.OnBeforeErase -= OnBeforeErase;
                m_RootPackage = null;

                // release unused objects
                GC.Collect();
            }
        }

        #region _IUMLDataEvents Members

        public void OnAfterAddChild(IUMLData ipUMLParent, IUMLData ipUMLChild)
        {
            if (ipUMLParent == null || ipUMLChild == null)
                return;

            Debug.WriteLine("UModelDataEvents.OnAfterAddChild " + GetName(ipUMLChild) + " to " + GetName(ipUMLParent));

           // verify if newly added child is of interesting kind:
            bool bIsEnumerationLiteral = (ipUMLChild is IUMLEnumerationLiteral);
            bool bIsProperty = (ipUMLChild is IUMLProperty);

            if (bIsProperty || bIsEnumerationLiteral)
            {
                try
                {
                    // check if child was added by undo/redo
                    // (we are not allowed to modify anything during Undo/Redo !!)
                    IDocument iDoc = (IDocument)ipUMLChild.Parent;
                    if (!iDoc.IsInUndoRedo)
                    {
                        // we only make one single modification here 
                        // no need to use iDoc.BeginModification / iDoc.EndModification in this case

                        // get the wanted prefix for the element kind
                        string sPrefix = null;

                        if (bIsProperty)
                            sPrefix = "m_";
                        if (bIsEnumerationLiteral)
                            sPrefix = "k_";

                        IUMLNamedElement iNamedChild = (IUMLNamedElement)ipUMLChild;

                        // set prefix only if not already set:
                        if (sPrefix != null && !iNamedChild.Name.StartsWith(sPrefix))
                        {
                            // use SetName (instead of Name) that UModel automatically generates a valid, unique name starting with 'sPrefix + iNamedChild.Name'
                            iNamedChild.SetName(sPrefix + iNamedChild.Name);
                        }
                    }
                }
                catch (System.Exception e)
                {
                    Debug.WriteLine("EXCEPTION: " + e.Message);
                }
            }

            // release unused objects
            GC.Collect();
        }

        public void OnBeforeErase(IUMLData ipUMLData)
        {
            if (ipUMLData != null && m_RootPackage != null && ipUMLData.IsSameUMLData((IUMLData)m_RootPackage)) // should always be
            {
                // Detach ourself, since the UML data of m_RootPackage has been deleted in UModel and we may not access it anymore
                Detach();
            }
        }

        public void OnChanged(IUMLData ipUMLData, string strHint)
        {
            // unused
        }

        public void OnMoveData(IUMLData ipUMLParent, IUMLData ipUMLChild, bool bAttach)
        {
            // unused
        }

        #endregion

        protected string GetName(IUMLData iUMLData)
        {
            if (iUMLData is IUMLNamedElement)
                return ((IUMLNamedElement)iUMLData).Name;

            return "";
        }
    }
}
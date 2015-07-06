using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;
using System.Drawing;
using System.Runtime.InteropServices.ComTypes;
using System.Windows.Forms;
using UModelLib;
using UModelPlugInLib;

/* 
 * StatisticsActiveX sample
 * listen for data modifications and count the elements of the different element kinds
 * show the result in a listview of an ActiveX control
 */
namespace StatisticsActiveX
{
    /* StatisticsActiveX is the main class of this plugin and implements UModelPlugInLib.IUModelPlugIn
     * it is also responsible for attaching/detaching _IApplicationEvents and _ITransactionEvents
     */
    public partial class StatisticsActiveX : UserControl,
                                             IUModelPlugIn,
                                            _IApplicationEvents,
                                            _ITransactionEvents
    {
        // a sorted dictionary to count the different element kinds
        private Statistics m_Statistics;
        // reference to the transaction notifier of a UModel document
        private TransactionNotifier m_TransactionNotifier;
        // connection point to _IApplicationEvents
        private IConnectionPoint m_cpApplicationEvents = null;
        // connection cookie
        int m_nApplicationtEventsCookie = 0;

        public StatisticsActiveX()
        {
            InitializeComponent();
        }

        #region IUModelPlugIn Members

        public string GetDescription()
        {
            return "PlugIn with ActiveX;This Plug-in demonstrates how to show an ActiveX control inside UModel.";
        }

        public string GetUIModifications()
        {
            // We don't add any menu or toolbar modifications.
            return "<ConfigurationData><Modifications/></ConfigurationData>";
        }

        public void OnInitialize(object pUModel)
        {
            // before processing DDE or batch commands
        }

        public void OnRunning(object pUModel)
        {
            // DDE or batch commands are processed; application is fully initialized
            // and we can attach to get _IApplicationEvents

            IApplication iApp = (IApplication)pUModel;

            if (m_cpApplicationEvents == null && iApp != null)
            {
                // find connection point of _IApplicationEvents
                IConnectionPointContainer icpc = (IConnectionPointContainer)iApp;
                Guid IID = typeof(UModelLib._IApplicationEvents).GUID;
                icpc.FindConnectionPoint(ref IID, out m_cpApplicationEvents);

                // advise UModelApplicationEvents as sink for _IApplicationEvents
                m_cpApplicationEvents.Advise(this, out m_nApplicationtEventsCookie);
            }

            AttachTransactionEvents(iApp.ActiveDocument);
        }

        public void OnShutdown(object pUModel)
        {
            // detach application events; stop receiving events
            DetachTransactionEvents();

            if (m_cpApplicationEvents != null)
            {
                // terminate established connection to _IApplicationEvents
                m_cpApplicationEvents.Unadvise(m_nApplicationtEventsCookie);
                m_cpApplicationEvents = null;
            }

            // application will shutdown; release all unused objects
            GC.Collect();
        }

        public void OnCommand(int nID, object pUModel)
        {
            // unused; we did not add any menu- or toolbar-commands
        }

        public UModelUpdateAction OnUpdateCommand(int nID, object pUModel)
        {
            // unused; we did not add any menu- or toolbar-commands
            return UModelUpdateAction.UModelUpdateAction_Disable;
        }

        #endregion

        private void AttachTransactionEvents(IDocument iDoc)
        {
            if (iDoc != null)
            {
                m_TransactionNotifier = iDoc.TransactionNotifier;
                if (m_TransactionNotifier != null)
                {
                    // we are only interested in 'OnEndDataModification' events so use and connect the delegate
                    m_TransactionNotifier.OnEndDataModification += new _ITransactionEvents_OnEndDataModificationEventHandler(OnEndDataModification);
                }
            }

            UpdateStatistics(iDoc);
        }

        // detach eventhandler from the transaction notifier
        private void DetachTransactionEvents()
        {
            if (m_TransactionNotifier != null)
            {
                m_TransactionNotifier.OnEndDataModification -= OnEndDataModification;
                m_TransactionNotifier = null;
            }
            UpdateStatistics(null);
        }

        void UpdateStatistics(IDocument iDoc)
        {
            // count current elements
            Statistics statistics = new Statistics();

            if (iDoc != null && iDoc.RootPackage != null)
                CountElements(iDoc.RootPackage, ref statistics);

            // anything changed to last update ?
            if (!statistics.IsEqual(m_Statistics))
            {
                m_Statistics = statistics;
                PopulateListView(m_Statistics);
            }

            // release unused objects
            GC.Collect();
        }

        private void CountElements(IUMLElement iElem, ref Statistics statistics)
        {
            // we only count editable elements
            if (iElem == null || iElem.IsEditable == false)
                return;

            string sKindName = iElem.KindName;

            if (!statistics.ContainsKey(sKindName))
                statistics[sKindName] = 1;
            else
                statistics[sKindName]++;

            foreach (IUMLElement iChild in iElem.OwnedElements)
                CountElements(iChild, ref statistics);
        }

        private void PopulateListView(Statistics statistics)
        {
            listView1.BeginUpdate();

            listView1.Items.Clear();
            foreach (KeyValuePair<string, int> kvp in statistics)
            {
                ListViewItem item = new ListViewItem(kvp.Key);
                item.SubItems.Add(Convert.ToString(kvp.Value));

                listView1.Items.Add(item);
            }

            listView1.EndUpdate();
        }

        #region _ITransactionEvents Members

        public void OnBeginDataModification(Document ipDocument)
        {
            // begin of transaction
        }

        public void OnEndDataModification(Document ipDocument)
        {
            // end of transaction - update statistics
            if (ipDocument != null && ipDocument.TransactionNotifier == m_TransactionNotifier)
                UpdateStatistics(ipDocument);
        }

        #endregion

        #region _IApplicationEvents Members

        public void OnNewDocument(Document ipDocument)
        {
            // a new document has been created in UModel => (re-)connect transaction events
            AttachTransactionEvents(ipDocument);
        }

        public void OnDocumentOpened(Document ipDocument)
        {
            // a document has been opened in UModel => (re-)connect transaction events
            AttachTransactionEvents(ipDocument);
        }

        public void OnDocumentClosed(Document ipDocument)
        {
            // document has been closed in UModel => disconnect transaction events
            if (ipDocument != null && ipDocument.TransactionNotifier == m_TransactionNotifier)
                DetachTransactionEvents();
        }

        public void OnShutdown()
        {
        }

        #endregion


        #region Statistics dictionary

        private class Statistics : SortedDictionary<string, int>
        {
            public bool IsEqual(Statistics other)
            {
                if (other == null)
                    return false;

                if (Count != other.Count)
                    return false;

                Enumerator e1 = GetEnumerator();
                Enumerator e2 = other.GetEnumerator();
                while (e1.MoveNext() && e2.MoveNext())
                {
                    if ((e1.Current.Key != e2.Current.Key) ||
                        (e1.Current.Value != e2.Current.Value))
                        return false;
                }

                return true;
            }
        }

        #endregion
    }
}

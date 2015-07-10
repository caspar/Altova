using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace WindowsFormsApplication2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        // An instance of XMLSpy accessed via its automation interface.
        XMLSpyLib.Application XMLSpy;

        // Location of examples installed with XMLSpy
        String strExamplesFolder;

        private void Form1_Load(object sender, EventArgs e)
        {
            // locate examples installed with XMLSpy.
            // REMARK: You might need to adapt this if you have a different major version of the product.
            strExamplesFolder = Environment.GetEnvironmentVariable("USERPROFILE") + "\\My Documents\\Altova\\XMLSpy2014\\Examples\\";
        }

        // handler for the "Start XMLSpy" button
        private void StartXMLSpy_Click(object sender, EventArgs e)
        {
            if (XMLSpy == null)
            {
                Cursor.Current = Cursors.WaitCursor;

                // if we have no XMLSpy instance, we create one and make it visible.
                XMLSpy = new XMLSpyLib.Application();
                XMLSpy.Visible = true;

                Cursor.Current = Cursors.Default;
            }
            else
            {
                // if we have already an XMLSpy instance running, we make sure it's visible
                if (!XMLSpy.Visible)
                    XMLSpy.Visible = true;
            }
        }

        // handler for the "Open OrgChart.pxf" button
        private void openOrgChart_Click(object sender, EventArgs e)
        {
            // Make sure that we have a running XMLSpy instance, and that it's visible
            StartXMLSpy_Click(null, null);

            // Open one of the sample files installed with the product.
            XMLSpy.Documents.OpenFile(strExamplesFolder + "OrgChart.pxf", false);
        }

        // handler for the "Open ExpReport.xml" button
        private void openExpReport_Click(object sender, EventArgs e)
        {
            // Make sure that we have a running XMLSpy instance, and that it's visible
            StartXMLSpy_Click(null, null);

            // Open one of the sample files installed with the product.
            XMLSpy.Documents.OpenFile(strExamplesFolder + "ExpReport.xml", false);
        }

        // handler for the "Toggle view mode" button
        private void toggleView_Click(object sender, EventArgs e)
        {
            // Make sure that we have a running XMLSpy instance, and that it's visible
            StartXMLSpy_Click(null, null);

            // iterate through all open documents and toggle current view between text and authentic view.
            foreach (XMLSpyLib.Document doc in XMLSpy.Documents)
                if (doc.CurrentViewMode == XMLSpyLib.SPYViewModes.spyViewText)
                    doc.SwitchViewMode(XMLSpyLib.SPYViewModes.spyViewAuthentic);
                else
                    doc.SwitchViewMode(XMLSpyLib.SPYViewModes.spyViewText);
        }

        // handler for the "Shutdown XMLSpy" button
        // shut-down application instance by explicitly releasing the COM object.
        private void shutdownXMLSpy_Click(object sender, EventArgs e)
        {
            if (XMLSpy != null)
            {
                // allow shut-down of XMLSpy by releasing UI
                XMLSpy.Visible = false;

                // explicitly release COM object
                try
                {
                    while (System.Runtime.InteropServices.Marshal.ReleaseComObject(XMLSpy) > 0) ;
                }
                finally
                {
                    // avoid later access to this object.
                    XMLSpy = null;
                }
            }
        }

        // handler for button "Validate"
        private void validate_Click(object sender, EventArgs e)
        {
            // COM errors get returned to C# as exceptions. We use a try/catch block to handle them.
            try
            {
                // method 'IsValid' is one of the few functions that uses output parameters.
                // use 'object' type for these parameters.
                object strErrorText = "";
                object nErrorNumber = 0;
                object errorData = null;

                if (!XMLSpy.ActiveDocument.IsValid(ref strErrorText, ref nErrorNumber, ref errorData))
                {
                    // The COM call succeeded but the document is not valid.
                    // A detailed description of the problem gets returned in strErrorText, nErrorNumber and errorData.
                     listBoxMessages.Items.Add("Document " + XMLSpy.ActiveDocument.Name + " is not valid.");
                     listBoxMessages.Items.Add("\tErrorText  : " + strErrorText);
                     listBoxMessages.Items.Add("\tErrorNumber: " + nErrorNumber);
                     listBoxMessages.Items.Add("\tElement    : " + (errorData != null ? ((XMLSpyLib.XMLData)errorData).TextValue : "null"));
                }
                else
                {
                    // The COM call succeeded and the document is valid.
                    listBoxMessages.Items.Add("Document " + XMLSpy.ActiveDocument.Name + " is valid.");
                }
            }
            catch (Exception ex)
            {
                // The COM call was not successful.
                // Probably no application instance has been started or no document is open.
                listBoxMessages.Items.Add("Error validating active document: " + ex.Message);
            }
        }

        delegate void addListBoxItem_delegate(string sText);
        // called from the UI thread
        private void addListBoxItem(string sText)
        {
            listBoxMessages.Items.Add(sText);
        }
        // wrapper method to allow to call UI controls methods from a worker thread
        void syncWithUIthread(Control ctrl, addListBoxItem_delegate methodToInvoke, String sText)
        {
            // Control.Invoke: Executes on the UI thread, but calling thread waits for completion before continuing.
            // Control.BeginInvoke: Executes on the UI thread, and calling thread doesn't wait for completion.
            if (ctrl.InvokeRequired)
                ctrl.BeginInvoke(methodToInvoke, new Object[] { sText });
        }

        // event handler for OnDocumentOpened event
        private void handleOnDocumentOpened(XMLSpyLib.Document i_ipDocument)
        {
            String sText = "";

            if (i_ipDocument.Name.Length > 0)
                sText = "Document " + i_ipDocument.Name + " was opened!";
            else
                sText = "An empty document was created.";

            // we need to synchronize the calling thread with the UI thread because
            // the COM events are triggered from a working thread
            addListBoxItem_delegate methodToInvoke = new addListBoxItem_delegate(addListBoxItem);
            // call syncWithUIthread with the following arguments:
            // 1 - listBoxMessages - list box control to display messages from COM events
            // 2 - methodToInvoke  - a C# delegate which points to the method which will be called from the UI thread
            // 3 - sText           - the text to be displayed in the list box
            syncWithUIthread(listBoxMessages, methodToInvoke, sText);
        }

        private void checkBoxEventOnOff_CheckedChanged(object sender, EventArgs e)
        {
            if (XMLSpy != null)
            {
                if (checkBoxEventOnOff.Checked)
                    XMLSpy.OnDocumentOpened += new XMLSpyLib._IApplicationEvents_OnDocumentOpenedEventHandler(handleOnDocumentOpened);
                else
                    XMLSpy.OnDocumentOpened -= new XMLSpyLib._IApplicationEvents_OnDocumentOpenedEventHandler(handleOnDocumentOpened);
            }
        }
    }
}

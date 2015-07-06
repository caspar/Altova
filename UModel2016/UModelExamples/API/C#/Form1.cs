using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;

namespace WindowsFormsApplication2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        // An instance of UModel accessed via its automation interface.
        UModelLib.Application UModel;
        UModelLib.Document UModelDocument;
        String docName = "Bank_MultiLanguage.ump";
        // Location of examples installed with UModel
        String strExamplesFolder;

        private void Form1_Load(object sender, EventArgs e)
        {
            // locate examples installed with UModel.
            // REMARK: You might need to adapt this if you have a different major version of the product.
            strExamplesFolder = Environment.GetEnvironmentVariable("USERPROFILE") + "\\My Documents\\Altova\\UModel2014\\UModelExamples\\";
        }

        // handler for the "Start UModel" button
        private void StartUModel_Click(object sender, EventArgs e)
        {
            if (UModel == null)
            {
                Cursor.Current = Cursors.WaitCursor;

                // if we have no UModel instance, we create one a nd make it visible.
                UModel = new UModelLib.Application();
                UModel.Visible = true;

                Cursor.Current = Cursors.Default;
            }
            else
            {
                // if we have already an UModel instance running we toggle its visibility flag.
                UModel.Visible = !UModel.Visible;
            }
        }

        // handler for the "Open CompletePO.mfd" button
        private void openBank_MultiLanguage_Click(object sender, EventArgs e)
        {
            if (UModel == null)
                StartUModel_Click(null, null);

            // Open one of the sample files installed with the product.
            UModelDocument = UModel.OpenDocument(strExamplesFolder + docName);
        }

        // handler for the "Create new mapping" button
        private void openAllDiagrams_Click(object sender, EventArgs e)
        {
            if (UModel == null)
                StartUModel_Click(null, null);

            if (UModelDocument != null)
            {
                UModelDocument.OpenAllDiagrams();
                UModelLib.DiagramWindows diagramWindows = UModelDocument.DiagramWindows;
                System.Collections.IEnumerator diagramWindowsEnum = diagramWindows.GetEnumerator();

               if ( diagramWindows.Count == 0 )
                   listBoxMessages.Items.Add("No opened diagrams.");
               else
                   listBoxMessages.Items.Add("Opened diagrams:");
                
                int count = 0;

                while ( diagramWindowsEnum.MoveNext() )
                {
                    String sName = "";
                    Object obj = diagramWindowsEnum.Current;

                    if (obj is UModelLib.DiagramWindow)
                    {
                        sName = ((UModelLib.DiagramWindow)obj).Name;
                        listBoxMessages.Items.Add("\t" + ++count + " " + sName);
                    }
                }
            }
        }

        // handler for the "Shutdown UModel" button
        // shut-down application instance by explicitly releasing the COM object.
        private void shutdownUModel_Click(object sender, EventArgs e)
        {
            if (UModel != null)
            {
                // allow shut-down of UModel by releasing UI
                UModel.Visible = false;

                // explicitly release COM object
                try
                {
                    while (System.Runtime.InteropServices.Marshal.ReleaseComObject(UModel) > 0) ;
                }
                finally
                {
                    // avoid later access to this object.
                    UModel = null;
                }
            }
        }

        // handler for button "Generate C++ Code"
        private void generateDocumentation_Click(object sender, EventArgs e)
        {
            if (UModel == null)
                listBoxMessages.Items.Add("start UModel first.");
            // COM errors get returned to C# as exceptions. We use a try/catch block to handle them.
            try
            {
                // generate documentation
			    UModelLib.Dialogs dlgs = UModel.Dialogs;
                UModelLib.ENUMDocumentationOutputFormat docFormat = UModelLib.ENUMDocumentationOutputFormat.eDocumentationOutputFormat_HTML;
			    UModelLib.GenerateDocumentationDlg docDlg = dlgs.GenerateDocumentationDlg;
                docDlg.OutputFormat = docFormat;
                String strDocOutputFolder = strExamplesFolder + "GeneratedDocFromC#Example\\";
                if (!Directory.Exists(strDocOutputFolder))
                {
                    Directory.CreateDirectory(strDocOutputFolder);
                    listBoxMessages.Items.Add("Created folder \"" + strDocOutputFolder + "\"");
                }
                String strResultFile = strDocOutputFolder + docName.Replace(".ump", ".html"); ;
                listBoxMessages.Items.Add("Generating documentation...");
                UModelDocument.GenerateDocumentation(docDlg, strResultFile);
                listBoxMessages.Items.Add("Generated document: " + strResultFile);
            }
            catch (Exception ex)
            {
                // The COM call was not successful.
                // Probably no application instance has been started or no document is open.
                MessageBox.Show("COM error: " + ex.Message);
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
        private void handleOnDocumentOpened(UModelLib.Document i_ipDocument)
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
            if (UModel != null)
            {
                if (checkBoxEventOnOff.Checked)
                    UModel.OnDocumentOpened += new UModelLib._IApplicationEvents_OnDocumentOpenedEventHandler(handleOnDocumentOpened);
                else
                    UModel.OnDocumentOpened -= new UModelLib._IApplicationEvents_OnDocumentOpenedEventHandler(handleOnDocumentOpened);
            }
        }
    }
}

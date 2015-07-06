// access general JAVA-COM bridge classes
import java.io.File;
import java.util.Iterator;

import com.altova.automation.libs.*;

// access XMLSpy Java-COM bridge
import com.altova.automation.UModel.*;
import com.altova.automation.UModel.Enums.ENUMDocumentationOutputFormat;

/**
 * A simple example that starts UModel COM server and performs a few operations on it.
 * Feel free to extend.
 */
public class RunUModel 
{
	public static void main(String[] args) 
	{
		// an instance of the application.
		Application umodel = null;

		// instead of COM error handling use Java exception mechanism.
		try 
		{
			// Start UModel as COM server.
			umodel = new Application();
			// COM servers start up invisible so we make it visible
			umodel.setVisible(true);
			
			String docName = "Bank_MultiLanguage.ump";
			
			// The following lines attach to the application events using a default implementation 
			// for the events and override one of its methods.
			// If you want to override all application events it is better to derive your listener class
			// from ApplicationEvents and implement all methods of this interface.
			umodel.addListener(new ApplicationEventsDefaultHandler()
			{
				@Override
				public void onDocumentOpened(Document i_ipDoc) throws AutomationException
				{
					String name = i_ipDoc.getName();
					
					System.out.println("Document " + name + " was opened.");
				}
			});

			// Locate samples installed with the product.
			String strExamplesFolder = System.getenv("USERPROFILE") + "\\My Documents\\Altova\\UModel2014\\UModelExamples\\";
			Document doc = umodel.openDocument(strExamplesFolder + docName);
			
			// The following lines attach to the document events using a default implementation 
			// for the events and override one of its methods.
			// If you want to override all document events it is better to derive your listener class
			// from DocumentEvents and implement all methods of this interface.
			doc.addListener(new DocumentEventsDefaultHandler()
			{
				@Override
				public void onDiagramWindowOpened(DiagramWindow ipDiagram) throws AutomationException
				{
					String name = ipDiagram.getName();
					
					System.out.println("Diagram " + name + " was opened.");
				}
			});
			// open all diagrams
			doc.openAllDiagrams();
						
			DiagramWindows diagramWindows = doc.getDiagramWindows();
		
			Iterator<DiagramWindow> itr = diagramWindows.iterator();
			
			if (diagramWindows.getCount() == 0)
				 System.out.print("No opened diagrams.\n");
			else
				System.out.print("Opened diagrams:\n");
			
			int count = 0;
			while (itr.hasNext())
			{
				// iterate through the opened diagram windows
				String sName = "";
			    Object element = itr.next();
			    if (element instanceof DiagramWindow)
			    {
			    	sName = ((DiagramWindow)element).getName();
			    	System.out.print("\t" + ++count + " " + sName + "\n");
			    }
			}
			
			// generate documentation
			Dialogs dlgs = umodel.getDialogs();
			ENUMDocumentationOutputFormat docFormat = ENUMDocumentationOutputFormat.eDocumentationOutputFormat_HTML;
			GenerateDocumentationDlg docDlg = dlgs.getGenerateDocumentationDlg();
			docDlg.setOutputFormat(docFormat);
			String strDocOutputFolder = strExamplesFolder + "GeneratedDocFromJavaExample\\";
			if ((new File(strDocOutputFolder)).mkdirs())
				System.out.println("Created folder \"" + strDocOutputFolder + "\"");
			String strResultFile = strDocOutputFolder + docName.replace(".ump", ".html");
			System.out.print("Generating documentation...\n");
			doc.generateDocumentation(docDlg, strResultFile);
			System.out.print("Generated document: " + strResultFile + "\n");
				
			System.out.println("Watch UModel!");
		} 
		catch (AutomationException e) 
		{
			// e.printStackTrace();
		}
		finally
		{
			// Make sure that UModel can shut down properly.
			if (umodel != null)
				umodel.dispose();

			// Since the COM server was made visible and still is visible, it will keep running
			// and needs to be closed manually.
			System.out.println("Now close UModel!");
		}
	}
}
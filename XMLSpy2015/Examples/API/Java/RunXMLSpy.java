// access general JAVA-COM bridge classes
import com.altova.automation.libs.*;

// access XMLSpy Java-COM bridge
import com.altova.automation.XMLSpy.*;
import com.altova.automation.XMLSpy.Enums.SPYViewModes;

/**
 * A simple example that starts XMLSpy COM server and performs a few operations on it.
 * Feel free to extend.
 */
public class RunXMLSpy 
{
	public static void main(String[] args) 
	{
		// an instance of the application.
		Application xmlSpy = null;

		// instead of COM error handling use Java exception mechanism.
		try 
		{
			// Start XMLSpy as COM server.
			xmlSpy = new Application();
			// COM servers start up invisible so we make it visible
			xmlSpy.setVisible(true);

			// Locate samples installed with the product.
			String strExamplesFolder = System.getenv("USERPROFILE") + "\\My Documents\\Altova\\XMLSpy2014\\Examples\\";
			
			// We open two files form the product samples.
			xmlSpy.getDocuments().openFile(strExamplesFolder + "OrgChart.pxf", false);
			xmlSpy.getDocuments().openFile(strExamplesFolder + "ExpReport.xml", false);
			
			// We iterate through all open documents and set the view mode to 'text'.
			for (Document doc:xmlSpy.getDocuments())
				if ( doc.getCurrentViewMode() != SPYViewModes.spyViewText)
					doc.switchViewMode(SPYViewModes.spyViewText);

			// An alternative iteration mode is to do it index-based. COM indices are typically zero-based.
			Documents documents = xmlSpy.getDocuments();
			for (int i = 1; i <= documents.getCount(); i++)
			{
				Document doc = documents.getItem(i);
				
				// Validation is one of the few methods that have output parameters.
				// The class JVariant is the correct type for parameters in these cases. 
				// To get values back mark them with the by-reference flag.
				JVariant validationErrorText = new JVariant.JStringVariant(""); 		validationErrorText.setByRefFlag();
				JVariant validationErrorCount = new JVariant.JIntVariant(0);			validationErrorCount.setByRefFlag();
				JVariant validationErrorXMLData = new JVariant.JIDispatchVariant(0); 	validationErrorXMLData.setByRefFlag();
				if (!doc.isValid(validationErrorText, validationErrorCount, validationErrorXMLData))
					System.out.println("Document " + doc.getName() + " is not wellformed - " + validationErrorText.getStringValue());
				else
					System.out.println("Document " + doc.getName() + " is wellformed.");
			}
			
			// The following lines attach to the document events using a default implementation 
			// for the events and override one of its methods.
			// If you want to override all document events it is better to derive your listener class
			// from DocumentEvents and implement all methods of this interface.
			Document doc = xmlSpy.getActiveDocument();
			doc.addListener(new DocumentEventsDefaultHandler()
			{
				@Override
				public boolean onBeforeCloseDocument(Document i_ipDoc) throws AutomationException
				{
					System.out.println("Document " + i_ipDoc.getName() + " requested closing.");
					
					// allow closing of document
					return true;
				}
			});
			doc.close(true);
			doc = null;
			
			System.out.println("Watch XMLSpy!");
		} 
		catch (AutomationException e) 
		{
			// e.printStackTrace();
		}
		finally
		{
			// Make sure that XMLSpy can shut down properly.
			if (xmlSpy != null)
				xmlSpy.dispose();

			// Since the COM server was made visible and still is visible, it will keep running
			// and needs to be closed manually.
			System.out.println("Now close XMLSpy!");
		}
	}
}
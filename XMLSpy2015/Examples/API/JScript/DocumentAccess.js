// Initialize application's COM object. This will start a new instance of the application and
// return its main COM object. Depending on COM settings, a the main COM object of an already
// running application might be returned.
try {	objSpy = WScript.GetObject("", "XMLSpy.Application");	}
catch(err) {}

if( typeof( objSpy ) == "undefined" )
{
	try	{	objSpy = WScript.GetObject("", "XMLSpy_x64.Application")	}
	catch(err)
	{
		WScript.Echo( "Can't access or create XMLSpy.Application" );
		WScript.Quit();
	}
}

// if newly started, the application will start without its UI visible. Set it to visible.
objSpy.Visible = true;

// **************************** code snippet for "Simple Document Access" ****************************************

// Locate examples via USERPROFILE shell variable. The path needs to be adapted to major release versions.
objWshShell = WScript.CreateObject("WScript.Shell");
strExampleFolder = objWshShell.ExpandEnvironmentStrings("%USERPROFILE%") + "\\My Documents\\Altova\\XMLSpy2014\\Examples\\";

// Tell XMLSpy to open two documents. No dialogs
objDoc1 = objSpy.Documents.OpenFile(strExampleFolder + "OrgChart.pxf", false);
objSpy.Documents.OpenFile(strExampleFolder + "ExpReport.xml", false);

// The document currently active can be easily located.
objDoc2 = objSpy.ActiveDocument;

// Let us make sure that the document is shown in grid view.
objDoc2.SwitchViewMode(0);	// SPYViewModes.spyViewGrid = 0

// Now switch back to the document opened first
objDoc1.SetActiveDocument();

// **************************** code snippet for "Simple Document Access" ****************************************

// **************************** code snippet for "Iteration" ****************************************

// go through all open documents using a JScript Enumerator
bRequiresSaving = false;
for (var iterDocs = new Enumerator(objSpy.Documents); !iterDocs.atEnd(); iterDocs.moveNext())
{
	if (iterDocs.item().IsModified)
		bRequiresSaving = true;
		
	var strErrorText = new Array(1);
	var nErrorNumber = new Array(1);
	var errorData = new Array(1);
	
	if (!iterDocs.item().IsValid(strErrorText, nErrorNumber, errorData))
	{
       var text = strErrorText;
	   // access that XMLData object only if filled in
       if (errorData[0] != null)
			text += "(" + errorData[0].Name + "/" + errorData[0].TextValue + ")";
			
		WScript.Echo("Document \"" + iterDocs.item().Name +"\" validation error[" + nErrorNumber + "]: " + text);
	}
	else
	{
		// The COM call succeeded and the document is valid.
		WScript.Echo("Document \"" + iterDocs.item().Name + "\" is valid.");
	}
}

// go through all open documents using index-based access to the document collection
for (i = objSpy.Documents.Count; i > 0; i--)
	objSpy.Documents.Item(i).Close(false);


// **************************** code snippet for "Iteration" ****************************************

//objSpy.Visible = false;		// will shutdown application if it has no more COM connections
objSpy.Visible = true;	// will keep application running with UI visible



// Initialize application's COM object. This will start a new instance of the application and
// return its main COM object. Depending on COM settings, a the main COM object of an already
// running application might be returned.
try {	objUModel = WScript.GetObject("", "UModel.Application");	}
catch(err) {}

if( typeof( objUModel ) == "undefined" )
{
	try	{	objUModel = WScript.GetObject("", "UModel_x64.Application")	}
	catch(err)
	{
		WScript.Echo( "Can't access or create UModel.Application" );
		WScript.Quit();
	}
}

// if newly started, the application will start without its UI visible. Set it to visible.
objUModel.Visible = true;

// **************************** code snippet for "Simple Document Access" ****************************************

// Locate examples via USERPROFILE shell variable. The path needs to be adapted to major release versions.
objWshShell = WScript.CreateObject("WScript.Shell");
strExampleFolder = objWshShell.ExpandEnvironmentStrings("%USERPROFILE%") + "\\My Documents\\Altova\\UModel2014\\UModelExamples\\";

objDoc = objUModel.OpenDocument(strExampleFolder + "Bank_MultiLanguage.ump");
// open all diagrams
objDoc.OpenAllDiagrams();

// **************************** code snippet for "Simple Document Access" ****************************************

// **************************** code snippet for "Iteration" ****************************************

objName = "";
count = 0;
// go through all open diagrams using a JScript Enumerator
for (var iterDiagrams = new Enumerator(objDoc.DiagramWindows); !iterDiagrams.atEnd(); iterDiagrams.moveNext())
{
	objName += "\t" + ++count + " " + iterDiagrams.item().Name + "\n";
}

WScript.Echo("Opened diagrams: \n" + objName);

// go through all open diagrams using index-based access to the document collection
for (i = objDoc.DiagramWindows.Count; i > 0; i--)
	objDoc.DiagramWindows.Item(i).Close();


// **************************** code snippet for "Iteration" ****************************************

//objUModel.Visible = false;		// will shutdown application if it has no more COM connections
objUModel.Visible = true;	// will keep application running with UI visible



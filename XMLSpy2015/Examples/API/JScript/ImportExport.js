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

// **************************** code snippet for "Import from database" ****************************************

// Locate examples via USERPROFILE shell variable. The path needs to be adapted to major release versions.
objWshShell = WScript.CreateObject("WScript.Shell");
strExampleFolder = objWshShell.ExpandEnvironmentStrings("%USERPROFILE%") + "\\My Documents\\Altova\\XMLSpy2014\\Examples\\";

try
{
	// specify the source of data import
	objImpSettings = objSpy.GetDatabaseSettings();
	objImpSettings.File = strExampleFolder + "Tutorial\\Company.mdb";
	objImpSettings.SQLSelect = "SELECT * FROM Address";

	// column filter
	objElementList = objSpy.GetDatabaseImportElementList(objImpSettings);

	// import into a new XML file
	objImpDocFromDB = objSpy.ImportFromDatabase(objImpSettings,objElementList);
}
catch(err)
{
	WScript.Echo("Error importing from database.\n\n" +
                     "Error: " + (err.number & 0xffff) + "\n" +
                     "Description: " + err.description);
}
 
// **************************** code snippet for "Import from database" ****************************************

// **************************** code snippet for "Export to database" ****************************************

//try
//{
	// set the behaviour of the export with ExportSettings
	objExpSettings = objSpy.GetExportSettings()

	//set the destination with DatabaseConnection
	objDB = objSpy.GetDatabaseSettings();
	objDB.CreateMissingTables = true;
	objDB.CreateNew = true;
	objDB.File = "C:\\Temp\\Export.mdb";

try
{
	objImpDocFromDB.ExportToDatabase(objImpDocFromDB.RootElement, objExpSettings, objDB);
}
catch(err)
{
	WScript.Echo("Error exporting to database.\n\n" + 
                     "Error: " + (err.number & 0xffff) + "\n" + 
                     "Description: " + err.description);
}

 
// **************************** code snippet for "Export to database" ****************************************

// **************************** code snippet for "Import from text" ****************************************

try
{
	// specify the source of data import
	objImpSettings = objSpy.GetTextImportExportSettings();
	objImpSettings.ImportFile = strExampleFolder + "Tutorial\\Shapes.txt";
	objImpSettings.HeaderRow = false;

	// column filter
	objElementList = objSpy.GetTextImportElementList(objImpSettings);

	// import into a new XML file
	objImpDocFromText = objSpy.ImportFromText(objImpSettings,objElementList);
}
catch(err)
{
	WScript.Echo("Error importing from text file.\n\n" + 
                     "Error: " + (err.number & 0xffff) + "\n" + 
                     "Description: " + err.description);
}

// **************************** code snippet for "Import from text" ****************************************

// **************************** code snippet for "Export to text" ****************************************

//try
//{
       objExpSettings = objSpy.GetExportSettings();
       objExpSettings.ElementList = objImpDocFromText.GetExportElementList(objImpDocFromText.RootElement, objExpSettings);
 
       objTextExp = objSpy.GetTextImportExportSettings();
       objTextExp.HeaderRow = true;
       objTextExp.DestinationFolder = "C:\\Temp";
try
{

       objImpDocFromText.ExportToText(objImpDocFromText.RootElement, objExpSettings, objTextExp);
}
catch(err)
{
	WScript.Echo("Error exporting to text.\n\n" + 
                     "Error: " + (err.number & 0xffff) + "\n" + 
                     "Description: " + err.description);
}

// **************************** code snippet for "Export to text" ****************************************

//objSpy.Visible = false;		// will shutdown application if it has no more COM connections
objSpy.Visible = true;	// will keep application running with UI visible



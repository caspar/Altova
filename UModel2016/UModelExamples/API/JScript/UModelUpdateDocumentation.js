// ###########################################
// access runing UModel.Application or 
// launch new one and access it 
// ############################################


// ############################################
// UpdateDocumentation sample 
// *) When running the first time (= when no UMP file exists), reverse engineer all C# UModelAPI samples
//    and create HTML and RTF documentation, make XMI export and save UMP file
// *) when UMP file already exists, open it and synchronize model from code
//    create HTML and RTF documentation and XMI export only if something has been changed (listen to all different UML data events)
// ############################################

var bRunVisible = true;
var bShowDialogs = bRunVisible && false;

// //////////// global variables /////////////////
var objUModel	= null;
var objWshShell = null;
var objFSO		= null;

var bChangedAnything = false;
var nAddedClasses	= 0;
var nAddedInterfaces= 0;
var nAddedProperties= 0;
var nAddedOperations= 0;

// /////////////////////// Helpers //////////////////////////////

function Exit(strErrorText)
{
	WScript.Echo(strErrorText);

	if (objUModel != null)
		objUModel.Quit();

	WScript.Quit(-1);
}

function CreateGlobalObjects ()
{
	// the Shell and FileSystemObject of the windows scripting host often always useful
	try 
	{
		objWshShell = WScript.CreateObject("WScript.Shell");
		objFSO = WScript.CreateObject("Scripting.FileSystemObject");
	}
	catch(err) 
	{
		Exit("Can't create WScript.Shell object"); 
	}

	// create the UModel connection
	// if there is a running instance of UModel (that never had a connection) - use it
	// otherwise, we automatically create a new instance
	try {	objUModel = WScript.GetObject("", "UModel.Application");	}
	catch(err) {}

	if( typeof( objUModel ) == "undefined" )
	{
		try	{	objUModel = WScript.GetObject("", "UModel_x64.Application")	}
		catch(err)
		{
			objUModel = null;
			Exit( "Can't access or create UModel.Application" );
		}
	}
}

// /////////////////////// get different filepathes / ensure folders are created  //////////////////////////////
function GetScriptPath()
{
	var path = objUModel.PersonalDataDirectory + "\\UModelExamples\\API\\JScript\\UpdateDocumentation";

	if ( !objFSO.FolderExists( path ) )
		objFSO.CreateFolder( path );

    return path;
}

function GetFilePath( subdir, filename )
{
	var path = objFSO.BuildPath( GetScriptPath(), subdir );

	if ( !objFSO.FolderExists( path ) )
		objFSO.CreateFolder( path );

	return path + "\\" + filename;
}

function GetUMPFilePath ()	{ return GetFilePath( "UMP",		"UModelAPI.ump" ); }
function GetXMIFilePath ()	{ return GetFilePath( "Output_XMI", "UModelAPI.xmi" ); }
function GetHTMLFilePath()	{ return GetFilePath( "Output_HTML","UModelAPI.html"); }
function GetRTFFilePath ()	{ return GetFilePath( "Output_RTF", "UModelAPI.rtf" ); }

// /////////////////////// UML data event handlers //////////////////////////////
function objRootPackage_OnChanged( objData, strHint )
{
   bChangedAnything = true; 
}

// recursively count newly added classes, interfaces, properties and operations
function CountAddedElements( objNewChild )
{
	if ( objNewChild != null )
	{
		if ( objNewChild.KindName == "Class"	 ) ++nAddedClasses;
		if ( objNewChild.KindName == "Interface" ) ++nAddedInterfaces;
		if ( objNewChild.KindName == "Property"  ) ++nAddedProperties;
		if ( objNewChild.KindName == "Operation" ) ++nAddedOperations;

		var ownedElements = objNewChild.OwnedElements;
		var itr = new Enumerator( ownedElements );
		for ( ; !itr.atEnd(); itr.moveNext() )
			CountAddedElements( itr.item() );
	}
}

function objRootPackage_OnAfterAddChild( objParent, objNewChild )
{
    bChangedAnything = true; 
	
	// recursively count newly added classes, interfaces, properties and operations
	CountAddedElements( objNewChild );
}

function objRootPackage_OnBeforeErase( objData )
{
    bChangedAnything = true; 
}

function objRootPackage_OnMoveData( objParent, objChild, bAttach )
{
    bChangedAnything = true; 
}

// /////////////////////// MAIN //////////////////////////////

CreateGlobalObjects();

if ( bRunVisible )
	objUModel.Visible = true;

var objDocument = null;

try
{
	// open document if it exists; create new one otherwise
	var bDocumentExisted = false;

	if ( objFSO.FileExists( GetUMPFilePath() ) )
	{
		objDocument = objUModel.OpenDocument( GetUMPFilePath() );
		bDocumentExisted = true;
	}
	else
	{
		objDocument = objUModel.NewDocument();
		objDocument.SaveAs( GetUMPFilePath() );
	}

	if ( objDocument == null )
		Exit( "Cannot create or open UModel projectfile" );

	// connect to receive _IUMLDataEvents from the root-package and all its children:
	var objRootPackage = objDocument.RootPackage;
    WScript.ConnectObject (objRootPackage, "objRootPackage_" );

	// ensure we get *all* events from root-package and *all* children:
	objRootPackage.EventFilter = 2 + // eUMLDataEvent_EraseDataOrChild		= 2,
								 8 + // eUMLDataEvent_AddChildOrGrandChild	= 8,
								32 + // eUMLDataEvent_ChangeDataOrChild		= 32,
								128; // eUMLDataEvent_MoveChildOrGrandChild	= 128
	if ( bDocumentExisted )
	{
		// UModel projectfile already exists => update model from code

		// get dialog for code <=> model synchonizations and set the wanted options:
		var objSynchronizationSettingsDlg = objUModel.Dialogs.SynchronizationSettingsDlg;
		objSynchronizationSettingsDlg.ShowDialog = bShowDialogs;
		
		objSynchronizationSettingsDlg.ModelFromCode_Synchronization = 0; // eSynchronization_Merge = 0
 
		// update model from code
		if ( !objDocument.SynchronizeModelFromCode( objSynchronizationSettingsDlg ) )
			Exit("Update model from code failed");
	}
	else
	{
		// UModel projectfile did not exist => newly import code into model

		var objImportSourceDirectoryDlg = objUModel.Dialogs.ImportSourceDirectoryDlg;
		objImportSourceDirectoryDlg.ShowDialog = bShowDialogs;
		
		// set source code directory to import
		objImportSourceDirectoryDlg.Directory = objUModel.PersonalDataDirectory + "\\UModelExamples\\IDEPlugIn";
		objImportSourceDirectoryDlg.ProcessSubdirectories = true;
		// set source code language to import (C# 3.0)
		objImportSourceDirectoryDlg.Language		= 5; // eCodeLang_CSharp_3_0		= 5
		objImportSourceDirectoryDlg.Synchronization = 0; // eSynchronization_Merge = 0
		// import in a new package
		objImportSourceDirectoryDlg.ImportInNewPackage = true;

		objImportSourceDirectoryDlg.DiagramGeneration = true;

		// content diagram generation settings
		objImportSourceDirectoryDlg.Content_GenerateSingleDiagram				= true;
		objImportSourceDirectoryDlg.Content_GenerateDiagramPerPackage			= true;
		objImportSourceDirectoryDlg.Content_ShowNestedClassifiersSeparately		= false;
		objImportSourceDirectoryDlg.Content_ShowAnonymousBoundElements			= false;
		objImportSourceDirectoryDlg.Content_HyperlinkPackagesToDiagrams			= true;
		objImportSourceDirectoryDlg.Content_ShowAttributesCompartment			= true;
		objImportSourceDirectoryDlg.Content_ShowOperationsCompartment			= true;
		objImportSourceDirectoryDlg.Content_ShowNestedClassifiersCompartment	= false;
		objImportSourceDirectoryDlg.Content_ShowEnumerationLiteralsCompartment	= true;
		objImportSourceDirectoryDlg.Content_ShowTaggedValues					= true;
		objImportSourceDirectoryDlg.Content_Autolayout							= 1; // eDiagramLayout_Hierarchic = 1
		// open diagrams that autolayout is done:
		objImportSourceDirectoryDlg.Content_OpenDiagrams						= true;

		// package dependency diagram generation settings (disabled)
		objImportSourceDirectoryDlg.PackageDependency_GenerateDiagram = false;

		// import source directory
		if ( !objDocument.ImportSourceDirectory( objImportSourceDirectoryDlg) )
		{
			// also delete newly created (empty) UMP file that source code directory import is retried the next time
			objFSO.DeleteFile( GetUMPFilePath() );
			Exit( "Error on importing source directory" );
		}
	}

	// disconnect from getting root-package events
	WScript.DisconnectObject( objRootPackage );
}
catch( err )
{
	// also delete newly created (empty) UMP file that source code directory import is retried the next time
	objFSO.DeleteFile( GetUMPFilePath() );
	Exit( "Error on importing source directory" );
}

//if something has changed, update the outputs:
if ( bChangedAnything )
{
	try
	{
		// make XMI export for UML2.1.2
		var objIExportXMIFileDlg = objUModel.Dialogs.ExportXMIFileDlg;
		objIExportXMIFileDlg.ShowDialog = bShowDialogs;
		objIExportXMIFileDlg.XMIFile				= GetXMIFilePath();
		objIExportXMIFileDlg.PrettyPrintXMIOutput	= true;
		objIExportXMIFileDlg.ExportUUIDs			= true;
		objIExportXMIFileDlg.ExportExtensions		= true;
		objIExportXMIFileDlg.ExportDiagrams			= true;
		objIExportXMIFileDlg.XMIType				= 1; // eXMI21ForUML212 = 1

		// export to XMI file:
		if ( !objDocument.ExportToXMIFile( objIExportXMIFileDlg ) )
		{
			// error on XMI generation
		}
	}
	catch( err )
	{
		// error on XMI generation
	}

	try
	{
		var objIDocumentationGenerationDlg = objUModel.Dialogs.GenerateDocumentationDlg;
		objIDocumentationGenerationDlg.ShowDialog = bShowDialogs;

		objIDocumentationGenerationDlg.GenerateLinksToLocalFiles = 1; // eDocumentationFilePath_RelativeToResultFile	= 1
		objIDocumentationGenerationDlg.SplitOutputToMultipleFiles = true;
		objIDocumentationGenerationDlg.ShowResultFileAfterGeneration = true;

		objIDocumentationGenerationDlg.Details_SelectAll();
		// show up to 10 base class/interface hierarchies
		objIDocumentationGenerationDlg.Details_HierarchyDiagramNestingDepthUp = 10;
		// only show directly derived classes/interfaces
		objIDocumentationGenerationDlg.Details_HierarchyDiagramNestingDepthDown = 1;
		// keep hierarchy diagram as small as possible => expand each element only once
		objIDocumentationGenerationDlg.Details_HierarchyDiagramExpandItemsOnlyOnce = true;

		objIDocumentationGenerationDlg.Include_SelectAllDiagrams();
		objIDocumentationGenerationDlg.Include_SelectNoElements();
		objIDocumentationGenerationDlg.Include_Index = true;
		objIDocumentationGenerationDlg.Include_IncludedSubprojects = false;
		objIDocumentationGenerationDlg.Include_NamedElementsOnly = true;
		objIDocumentationGenerationDlg.Include_UnknownExternals = false;

		var objIncludeElements = objIDocumentationGenerationDlg.Include_Elements;
		var itrIncludeElements = new Enumerator( objIncludeElements );
		for ( ; !itrIncludeElements.atEnd(); itrIncludeElements.moveNext() )
		{
			var objElemSel = itrIncludeElements.item();

			if ( objElemSel.KindName == "Class"			||
				 objElemSel.KindName == "Interface"		||
				 objElemSel.KindName == "Enumeration"	||
				 objElemSel.KindName == "Operation"		||
				 objElemSel.KindName == "Package"		)
			{
				objElemSel.Selection = true;
			}
		}

		// generate HTML documentation (with PNG pictures)
		objIDocumentationGenerationDlg.OutputFormat = 0; // eDocumentationOutputFormat_HTML	= 0
		objIDocumentationGenerationDlg.DiagramImageFormat = 0; // eOutputImageFormat_PNG = 0
		objIDocumentationGenerationDlg.EmbedDiagrams = false;
		if ( !objDocument.GenerateDocumentation( objIDocumentationGenerationDlg, GetHTMLFilePath() ) )
		{
			// error on HTML documentation generation
		}

		// generate RTF documentation (with embeded EMF pictures)
		objIDocumentationGenerationDlg.ShowDialog = false; // don't show dialog again		
		objIDocumentationGenerationDlg.OutputFormat = 2; // eDocumentationOutputFormat_RTF	= 2
		objIDocumentationGenerationDlg.DiagramImageFormat = 1; // eOutputImageFormat_EMF = 1
		objIDocumentationGenerationDlg.EmbedDiagrams = true;
		if ( !objDocument.GenerateDocumentation( objIDocumentationGenerationDlg, GetRTFFilePath() ) )
		{
			// error on RTF documentation generation
		}
	}
	catch( err )
	{
		// error on documentation generation
	}

	// show the number of newly added classes, interfaces, properties and operations
	if ( bRunVisible )
	{
		WScript.Echo( "Added classes: "		 + nAddedClasses	+
					  "\nAdded interfaces: " + nAddedInterfaces + 
					  "\nAdded properties: " + nAddedProperties + 
					  "\nAdded operations: " + nAddedOperations );
	}
}
else
{
	if ( bRunVisible )
		WScript.Echo( "Nothing has changed" );
}

// always save document (although it's not really necessary when nothing has been changed)
objDocument.Save();

if ( bRunVisible )
	objUModel.Visible = false;	// will shutdown application if it was started by this script

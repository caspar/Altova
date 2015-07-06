// ###########################################
// access runing UModel.Application or 
// launch new one and access it 
// ############################################


// ############################################
// CreateCode sample 
// shows forward engineering from scratch
// it creates some coding elements in a new UModel project and generates code (saving the project afterwards)
// ############################################



// //////////// global variables /////////////////
var objUModel = null;
var objWshShell = null;
var objFSO = null;

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

function GetSourceCodeDirectory()
{
	// get directory for source code
	var path =  objUModel.PersonalDataDirectory + "\\UModelExamples\\API\\JScript\\CreateCode";
	var codeDirectory = objFSO.BuildPath( path, "SampleCode" );
	return codeDirectory;
}

function GetUMPFilePath()
{
	// get file path to save UModel projectfile
	return objUModel.PersonalDataDirectory + "\\UModelExamples\\API\\JScript\\CreateCode\\CreateCode.ump";
}

function IncludeCSharpProfile( objDocument )
{
	try
	{
		// get dialog for including subprojects:
		var objIncludeSubProjectDialog = objUModel.Dialogs.IncludeSubprojectDlg;

		objIncludeSubProjectDialog.ProjectFile = objUModel.InstallationDirectory + "\\UModelInclude\\c# Profile.ump";

		return objDocument.IncludeSubproject( objIncludeSubProjectDialog );
	}
	catch(err) 
	{ 
		Exit("Can't include CSharp profile");
	}
}

// /////////////////////// MAIN //////////////////////////////

CreateGlobalObjects();

objUModel.Visible = true;

// open an new, empty document
var objDocument = objUModel.NewDocument();
// get the root-package
var objRootPackage = objDocument.RootPackage;

if ( objDocument    != null && 
     objRootPackage != null &&
	 IncludeCSharpProfile( objDocument ) )
{
	// create coding elements
    try
    {
        // make all modifications within one UndoStep; start modification here
		if ( !objDocument.BeginModification() )
			Exit("No modifications allowed");

		// create a namespace root package
		var objCSharpRootNamespace = objRootPackage.InsertPackagedElementAt( -1, "Package" );
		objCSharpRootNamespace.SetName( "CSharp" );

		// find C# Profile...
		var objCSharpProfile = objRootPackage.FindPredefinedOwnedElement( 159, false );// ePredefined_CSharp_Profile = 159,
		// ...and apply it to the package, which is now a CSharp namespace root
		objCSharpRootNamespace.InsertProfileApplicationAt( -1, objCSharpProfile );


		// create a C# namespace package...
		var objCSharpNamespace = objCSharpRootNamespace.InsertPackagedElementAt( -1, "Package" );
		objCSharpNamespace.SetName( "Namespace1" );
		// ... and apply the predefined C# namespace stereotype
		objCSharpNamespace.ApplyPredefinedStereotype( 223 ); // ePredefined_CSharp_namespaceStereotypeOfPackage = 223,

		// create new class within the C# namespace
		var objClass     = objCSharpNamespace.InsertPackagedElementAt( -1, "Class" );
		var objClass2    = objCSharpNamespace.InsertPackagedElementAt( -1, "Class" );
		var objBaseClass = objCSharpNamespace.InsertPackagedElementAt( -1, "Class" );
		objClass    .SetName( "MyClass"     );
		objClass2   .SetName( "MyClass2"    );
		objBaseClass.SetName( "MyBaseClass" );

		// set attribute-section "STAThread"		
		var objAttributesStereotypeApplication = objClass.ApplyPredefinedStereotype( 191 );// 	ePredefined_CSharp_attributesStereotypeOfClass = 191
		var objSTAThread = objCSharpProfile.FindPredefinedOwnedElement( 185, true ); // ePredefined_CSharp_AttributePresetsEnumeration_STAThreadEnumerationLiteral = 185
		objAttributesStereotypeApplication.SetPredefinedTaggedValueAt(-1, 192, objSTAThread.Name); // ePredefined_CSharp_attributesStereotypeOfClass_sectionsProperty = 192

		// insert new attribute
		var objProperty = objClass.InsertOwnedAttributeAt( -1 );
		objProperty.SetName( "m_Att" );
		objProperty.Visibility = 2;		// eVisibility_Private = 2
		objProperty.Type = objClass2;

		// insert new operation
		var objOperation = objClass.InsertOwnedOperationAt( -1 );
		objOperation.SetName( "GetAtt" );
		objOperation.Type = objClass2;

		// derive MyClass from MyBaseClass
		objClass.InsertGeneralizationAt( -1, objBaseClass );


		// find the component view package
		var objComponentView = objRootPackage.FindPredefinedOwnedElement( 1, false );// ePredefined_ComponentViewPackage = 1

		// create a new component for C# 3.0 and set the source code directory, where we want to generate the source code
		var objComponent = objComponentView.InsertPackagedElementAt( -1, "Component" );
		objComponent.CodeLangVersion= 5; // 	eCodeLang_CSharp_3_0	= 5,
		objComponent.CodeProjectFileOrDirectory = GetSourceCodeDirectory();
		objComponent.IsCodeProjectFile = false;

		// this component should realize our classes:
		objComponent.InsertRealizationAt( -1, objClass     );
		objComponent.InsertRealizationAt( -1, objClass2    );
		objComponent.InsertRealizationAt( -1, objBaseClass );

        // do not forget to end modification and finish UndoStep
		objDocument.EndModification();
    }
	catch( err )
	{
        // rollback made changes
		objDocument.AbortModification();
		Exit("Error when creating UML model elements");
	}

	// update code from model
	try
	{
		// explicitely run a syntax check
		if ( objDocument.CheckProjectSyntax() )
		{
			// get dialog for code <=> model synchonizations and set the wanted options:
			var objSynchronizationSettingsDlg = objUModel.Dialogs.SynchronizationSettingsDlg;

			objSynchronizationSettingsDlg.CodeFromModel_Synchronization = 0; // eSynchronization_Merge = 0
			objSynchronizationSettingsDlg.CodeFromModel_UserDefinedSPLTemplatesOverrideDefault = true;

			// update code from model
			if ( !objDocument.SynchronizeCodeFromModel( objSynchronizationSettingsDlg ) )
				Exit("Update code from model failed");
		}
		else
			Exit("Syntax check failed");
	}
	catch( err )
	{
		Exit("Error when updating code from model");
	}

	// save project
	objDocument.SaveAs( GetUMPFilePath() );

	WScript.Echo("Finished successfully");
}

// if something went wrong (and we did not save the project),
// we also do not want get asked for saving => set ModifiedFlag to false
if ( objDocument != null )
	objDocument.ModifiedFlag = false;

objUModel.Visible = false;	// will shutdown application if it was started by this script



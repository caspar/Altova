
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

WScript.Echo(objUModel.Edition + " has successfully started. ");

objUModel.Visible = false; // will shutdown application if it has no more COM connections
//objUModel.Visible = true;	// will keep application running with UI visible



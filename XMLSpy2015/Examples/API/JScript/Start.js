
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

WScript.Echo(objSpy.Edition + " has successfully started. ");

objSpy.Visible = false;		// will shutdown application if it has no more COM connections
//objSpy.Visible = true;	// will keep application running with UI visible



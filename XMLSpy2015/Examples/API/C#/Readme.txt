This directory contains a C# example for the XMLSpy API. You can compile and run from within Visual Studio 2008 or Visual Studio 2010.

For details see the section "Application API" of the XMLSpy user documentation.

--------------------------------------------------------------------------
File list
---------------------------------------------------------------------------
Readme.txt				- this file

AutomateXMLSpy.csproj		- Visual Studio 2008 and 2010 project file
AutomateXMLSpy_VS2008.sln	- Visual Studio 2008 solution file
AutomateXMLSpy_VS2010.sln	- Visual Studio 2010 solution file

Properties
Form1.cs
Form1.Designer.cs
Form1.resx
Program.cs				- C# example source code

---------------------------------------------------------------------------
What the example does
--------------------------------------------------------------------------
The example shows a simple user interface with buttons that invoke a few basic operation with XMLSpy.

Start XMLSpy - starts the XMLSpy that is registered as an automation server
		    or activates the program if XMLSpy is already running.
Open OrgChart.pxf - locates one of the example documents installed with
			    XMLSpy and opens it. If this document is already open
			    it becomes the active document.
OnDocumentOpened Event On/Off - shows how to listen to XMLSpy events.
                                when turned on, a message box will pop up
						after a dcoument has been opened.
Open ExpReport.xml - Opens another example document.
Toggle View mode - Changes the view of all open documents between text view
                   and Authentic view.
Validate - performs validation operation on active document and shows
		result in a message box.
Shutdown XMLSpy - Stops XMLSpy.

You can modify the example in any way you like.

---------------------------------------------------------------------------
Compile and run the example with Visual Studio 2008
---------------------------------------------------------------------------
Double-click the file AutomateXMLSpy_VS2008.sln or open it from within a Visual Studio 2008 with 'File | Open | Project/Solution...'.

Use 'Debug | Start Debugging' or 'Debug | Start Without Debugging' to compile and run the example.

---------------------------------------------------------------------------
Compile and run the example with Visual Studio 2010
---------------------------------------------------------------------------
Double-click the file AutomateXMLSpy_VS2010.sln or open it from within a Visual Studio 2010 with 'File | Open | Project/Solution...'.

Use 'Debug | Start Debugging' or 'Debug | Start Without Debugging' to compile and run the example.

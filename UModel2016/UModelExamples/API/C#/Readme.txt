This directory contains a C# example for the UModel API. You can compile and run from within Visual Studio 2008 or Visual Studio 2010.

For details see the section "Application API" of the UModel user documentation.

-------------------------------------------------------------------------
File list
-------------------------------------------------------------------------
Readme.txt				- this file

AutomateUModel.csproj		- Visual Studio 2008 and 2010 project file
AutomateUModel_VS2008.sln	- Visual Studio 2008 solution file
AutomateUModel_VS2010.sln	- Visual Studio 2010 solution file

Properties
Form1.cs
Form1.Designer.cs
Form1.resx
Program.cs					- C# example source code

-------------------------------------------------------------------------
What the example does
-------------------------------------------------------------------------
The example shows a simple user interface with buttons that invoke a few basic operation on UModel.

Start UModel - starts a UModel instance or activates the program if it
		    is already running.
Open Bank_MultiLanguage - locates one of the example documents installed
				    with UModel and opens it. If this document is
				    already open it becomes the active document.
Generate documentation - generates documentation for the UML model.
OnDocumentOpened Event On/Off - shows how to listen to UModel events.
                                When turned on, information received from
					     document opened events will be shown in
					     a message box.
Shutdown UModel - Stops UModel.

You can modify the example in any way you like.

-------------------------------------------------------------------------
Compile and run the example with Visual Studio 2008
-------------------------------------------------------------------------
Double-click the file AutomateUModel_VS2008.sln or open it from within a Visual Studio 2008 with 'File | Open | Project/Solution...'.

Use 'Debug | Start Debugging' or 'Debug | Start Without Debugging' to compile and run the example.

-------------------------------------------------------------------------
Compile and run the example with Visual Studio 2010
-------------------------------------------------------------------------
Double-click the file AutomateUModel_VS2010.sln or open it from within a Visual Studio 2010 with 'File | Open | Project/Solution...'.

Use 'Debug | Start Debugging' or 'Debug | Start Without Debugging' to compile and run the example.

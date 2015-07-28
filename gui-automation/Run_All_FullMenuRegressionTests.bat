@echo off



CLS
REM
REM
REM  This script helps the user to run any module within the gUi-automation project and sets the needed variables if required
REM  
REM


ECHO.
ECHO This script will run a Test suite included in the GUI-automation project.
ECHO.

PAUSE


ECHO.
ECHO.

set ANT_OPTS=-Xms512m -Xmx512m
set JUnitDryRun=false
set ifcompare=false
set /P ifcompare= Do you want the output screenshots to be compared to the expected ones after every test?  Please, specify 'Y' for Yes and 'N' for No.

if "%ifcompare%"=="N" set JUnitDryRun=true
if "%ifcompare%"=="n" set JUnitDryRun=true


ECHO.
ECHO.

set X64=false
set if64bit=false
set /P if64bit= Do you want to execute the tests on a 64bit version? . Please, specify 'Y' for 64bit and 'N' for 32bit.

if "%if64bit%"=="Y" set X64=true
if "%if64bit%"=="y" set X64=true


ECHO.
ECHO.

set VS2010=false
set ifVS2010=false
set /P ifVS2010= Are you running the suite for the MS Visual Studio plug-in in VS2010? . Please, specify 'Y' for VS2010 and 'N' otherwise.

if "%ifVS2010%"=="Y" set VS2010=true
if "%ifVS2010%"=="y" set VS2010=true



ECHO.
ECHO.
ECHO Please, specify the Altova application that you want to test as follows. Make sure you care about upper and lower case in this case : 
ECHO For XMLSpy, type 'spy'
ECHO For MapForce, type 'mapforce'
ECHO For StyleVision, type 'stylevision'
ECHO For Authentic Desktop, type 'authentic' 
ECHO For UModel, type 'testcases'
ECHO For SchemaAgent, type 'schemaagent'
ECHO For SemanticWorks, type 'semanticworks'
ECHO For DatabaseSpy, type 'databasespy' 
ECHO.
  
set module=
set /P module= 

ECHO.
ECHO.
ECHO Are you testing the Visual Studio Plug-in, the Eclipse Plug-in or the standalone application? Make sure you care about upper and lower case in this case   
ECHO For MS Visual Studio, type 'VSnet'
ECHO For Eclipse, type 'Eclipse'
ECHO For standalone, press enter
ECHO.

set ifplugin=
set /P ifplugin= 

ant test -Dclassname=%module%\FullMenuRegression%ifplugin%Test








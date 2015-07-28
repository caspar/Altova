@ECHO OFF

if '%1 == ' goto no-params

if not exist %1 goto no-xml-file
if not exist %2 goto no-xml-file

set rootdir=..\..\..\

if not exist C:\SAXON-license\saxon-license.lic goto no-saxon-lic


set oldPath=%path%
set oldCLASSPATH=%CLASSPATH%

set CLASSPATH=.
set CLASSPATH=%CLASSPATH%;%rootdir%\lib\saxon\saxon9ee.jar
set CLASSPATH=%CLASSPATH%;%rootdir%\lib\saxon\saxon9ee-qc.jar
set CLASSPATH=%CLASSPATH%;%rootdir%\lib\saxon\saxon9-sql.jar
set CLASSPATH=%CLASSPATH%;.;C:\SAXON-license\


echo.
echo ---------------------------------------------------------
echo Running the SAXON validator against the following:
echo    - XML Instance: %1
echo    - XML Schema: %2
echo ---------------------------------------------------------

java -classpath %CLASSPATH% com.saxonica.Validate -xsdversion:1.1 %1 -xsd:%2


set path=%oldPath%
set CLASSPATH=%oldCLASSPATH%

goto eof

:no-saxon-lic
    cls
    echo Oops! Do perform XML Schema validation you must have the SAXON license in your classpath.
    echo.
    goto eof

:no-params
    cls
    echo Oops! You need to run the batch file with 1 argument.
    echo Here's how to use it ...
    echo.
    echo Usage: "validate <xml filename> <xsd filename>"
    echo.
    goto eof

:no-xml-file
   cls
   echo Oops! %1 does not exist
   echo Most likely reason: mistyped filename
   echo Exiting ...
   echo.
   goto eof

:no-calabash-jar
   cls
   echo Oops! Missing this calabash file: %rootdir%%which_calabash%\lib\calabash.jar
   echo Most likely reason: calabash not installed in the correct directory
   echo Exiting ...
   goto eof

:no-saxon-jar
   cls
   echo Oops! Missing this saxon file: %rootdir%%which_saxon%\saxon9.jar
   echo Most likely reason: saxon not installed in the correct directory
   echo Exiting ...
   goto eof

:no-saxon-s9api-jar
   cls
   echo Oops! Missing this saxon file: %rootdir%%which_saxon%\saxon9-s9api.jar
   echo Most likely reason: saxon not installed in the correct directory
   echo Exiting ...
   goto eof

:eof


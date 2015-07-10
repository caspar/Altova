@echo off
if %1.==. goto error

@echo on

REM compile sample java
%1\javac.exe -cp XMLSpyAPI.jar;AltovaAutomation.jar RunXMLSpy.java

REM run sample java
%1\java.exe -cp XMLSpyAPI.jar;AltovaAutomation.jar;. RunXMLSpy

@echo off
goto end

:error
echo Usage: buildAndRun "<path_to_java_bin_folder>"

:end

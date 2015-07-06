@echo off
if %1.==. goto error

@echo on

REM compile sample java
%1\javac.exe -cp UModelAPI.jar;AltovaAutomation.jar RunUModel.java

REM run sample java
%1\java.exe -cp UModelAPI.jar;AltovaAutomation.jar;. RunUModel

@echo off
goto end

:error
echo Usage: buildAndRun "<path_to_java_bin_folder>"

:end

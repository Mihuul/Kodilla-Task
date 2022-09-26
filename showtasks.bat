call runcrud
if "%ERRORLEVEL%" == "0" goto launch
echo.
echo GRADLEW BUILD has errors – breaking work
goto fail

:launch
start chrome http://localhost:8080/crud/v1/tasks
echo.
echo launching a webpage goto end

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.
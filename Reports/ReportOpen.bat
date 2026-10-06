@echo off
setlocal

set REPORT_DIR=C:\Users\Aman.Jadon\eclipse-workspace\AutomationTesting\Reports

for /f "delims=" %%i in ('dir /b /a-d /o-d "%REPORT_DIR%\AutomationReport_*.html"') do (
    start chrome "%REPORT_DIR%\%%i"
    exit /b
)

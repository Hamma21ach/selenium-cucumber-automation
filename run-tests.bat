@echo off
echo ===============================================
echo TP2 - Test d'Automatisation Web avec Selenium
echo ===============================================
echo.

echo Compilation du projet...
call mvn clean compile
if %errorlevel% neq 0 (
    echo Erreur lors de la compilation. Verifiez que Maven est installe.
    pause
    exit /b 1
)

echo.
echo Execution des tests...
call mvn test
if %errorlevel% neq 0 (
    echo Erreur lors de l'execution des tests.
    pause
    exit /b 1
)

echo.
echo ===============================================
echo Tests termines avec succes!
echo ===============================================
pause




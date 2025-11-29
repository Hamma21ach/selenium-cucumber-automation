@echo off
echo ===============================================
echo TP2 - Compilation et Execution Manuelle
echo ===============================================

echo Creation des dossiers de sortie...
if not exist "target\classes" mkdir "target\classes"
if not exist "target\test-classes" mkdir "target\test-classes"

echo.
echo Compilation des classes principales...
javac -cp "src\main\java" -d "target\classes" src\main\java\pages\LoginPage.java

echo.
echo Compilation des classes de test...
javac -cp "target\classes;src\test\java" -d "target\test-classes" src\test\java\base\TestBase.java src\test\java\stepdefinitions\LoginStep.java

echo.
echo ATTENTION: Pour executer les tests, vous devez:
echo 1. Installer Maven OU
echo 2. Ajouter manuellement les dependances JUnit et Selenium au classpath
echo.
echo Le projet est compile mais necessite les libraries externes pour fonctionner.
echo.
pause





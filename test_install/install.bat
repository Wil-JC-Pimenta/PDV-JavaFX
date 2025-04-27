@echo off
echo Instalando POS Gateway...

:: Verifica se o Java está instalado
java -version 2>nul
if errorlevel 1 (
    echo Java nao encontrado! Por favor, instale o Java 17 ou superior.
    pause
    exit /b 1
)

:: Verifica se o JavaFX está instalado
if not exist "C:\javafx-sdk-17.0.15\lib" (
    echo JavaFX nao encontrado! Por favor, instale o JavaFX SDK 17.0.15 em C:\javafx-sdk-17.0.15
    pause
    exit /b 1
)

:: Define variáveis de ambiente
set "POSGATEWAY_HOME=%~dp0"
set "PATH_TO_FX=C:\javafx-sdk-17.0.15\lib"

:: Verifica se as variáveis foram definidas
if not defined POSGATEWAY_HOME (
    echo Erro ao definir POSGATEWAY_HOME
    pause
    exit /b 1
)

if not defined PATH_TO_FX (
    echo Erro ao definir PATH_TO_FX
    pause
    exit /b 1
)

echo.
echo Instalacao concluida!
echo.
echo Para executar o aplicativo, use o arquivo run.bat na pasta bin
pause 
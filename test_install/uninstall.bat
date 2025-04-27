@echo off
echo POS Gateway - Desinstalador
echo ===========================
echo.

:: Verifica privilégios de administrador
net session >nul 2>&1
if %errorLevel% neq 0 (
    echo Erro: Execute este script como administrador!
    pause
    exit /b 1
)

:: Pergunta se deseja manter os dados
set /p KEEP_DATA="Deseja manter os dados de transacoes? (S/N): "
if /i "%KEEP_DATA%" neq "S" (
    echo Removendo dados...
    rd /s /q "%POSGATEWAY_HOME%\backup" 2>nul
    rd /s /q "%POSGATEWAY_HOME%\logs" 2>nul
)

:: Remove variáveis de ambiente
echo Removendo variaveis de ambiente...
reg delete "HKCU\Environment" /v POSGATEWAY_HOME /f >nul 2>&1
reg delete "HKCU\Environment" /v PATH_TO_FX /f >nul 2>&1

:: Remove atalhos
echo Removendo atalhos...
del /f /q "%USERPROFILE%\Desktop\POS Gateway.lnk" 2>nul
rd /s /q "%APPDATA%\Microsoft\Windows\Start Menu\Programs\POS Gateway" 2>nul

:: Remove arquivos da instalação
echo Removendo arquivos...
rd /s /q "%POSGATEWAY_HOME%\bin" 2>nul
rd /s /q "%POSGATEWAY_HOME%\lib" 2>nul
rd /s /q "%POSGATEWAY_HOME%\config" 2>nul

echo.
echo Desinstalacao concluida!
echo Para finalizar, reinicie o computador.
echo.
pause 
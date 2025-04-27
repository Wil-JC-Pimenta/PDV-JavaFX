@echo off
set "JAVAFX_PATH=C:\javafx\openjfx-22.0.1_windows-x64_bin-sdk\javafx-sdk-22.0.1\lib"
set "CLASSPATH=target\classes;%JAVAFX_PATH%\*"

java --module-path "%JAVAFX_PATH%" --add-modules javafx.controls,javafx.fxml -cp "%CLASSPATH%" com.posgateway.PosGatewayApp

pause 
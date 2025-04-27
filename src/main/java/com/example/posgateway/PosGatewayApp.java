package com.example.posgateway;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PosGatewayApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaymentForm.fxml"));
        System.out.println("Carregando FXML: " + getClass().getResource("/fxml/PaymentForm.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("POS Gateway - Sistema de Pagamento");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

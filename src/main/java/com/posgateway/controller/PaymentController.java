package com.posgateway.controller;

import com.posgateway.service.PaymentService;
import com.posgateway.service.TransactionResult;
import com.example.posgateway.service.TerminalConnectorImpl;
import com.posgateway.service.TerminalConnector;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PaymentController {
    @FXML private TextField amountField;
    @FXML private TextField orderIdField;
    @FXML private TextArea logArea;
    
    private final PaymentService paymentService;
    
    public PaymentController() {
        TerminalConnector terminal = new TerminalConnectorImpl();
        this.paymentService = new PaymentService(terminal);
    }
    
    @FXML
    private void processPayment() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String orderId = orderIdField.getText();
            
            if (orderId.isEmpty()) {
                logArea.appendText("Erro: ID do pedido não pode estar vazio\n");
                return;
            }
            
            TransactionResult result = paymentService.authorize(amount, orderId);
            
            logArea.appendText("Resultado: " + (result.isApproved() ? "Aprovado" : "Negado") + "\n");
            logArea.appendText("Mensagem: " + result.getMessage() + "\n\n");
            
        } catch (NumberFormatException e) {
            logArea.appendText("Erro: Valor inválido. Use números com ponto decimal (ex: 100.50)\n");
        }
    }
}

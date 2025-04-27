package com.example.posgateway.service;

import com.posgateway.service.TerminalConnector;
import com.posgateway.service.TransactionResult;

public class TerminalConnectorImpl implements TerminalConnector {
    @Override
    public TransactionResult sendAuthorization(double amount, String transactionId) {
        // Simulate sending authorization to terminal
        System.out.println("Enviando autorização: R$ " + amount + " (ID: " + transactionId + ")");
        return new TransactionResult(true, transactionId, "Transação aprovada");
    }

    @Override
    public Object authorize(double amount) {
        // Implement if needed, or return null
        return null;
    }
}

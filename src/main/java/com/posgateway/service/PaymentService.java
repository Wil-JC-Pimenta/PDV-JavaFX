package com.posgateway.service;

public class PaymentService {
    private final TerminalConnector terminal;

    public PaymentService(TerminalConnector terminal) {
        this.terminal = terminal;
    }

    public TransactionResult authorize(double amount, String orderId) {
        System.out.println("Enviando autorização: R$ " + amount + " (ID: " + orderId + ")");
        return terminal.sendAuthorization(amount, orderId);
    }
} 
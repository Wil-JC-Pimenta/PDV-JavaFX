package com.posgateway.service;

public interface TerminalConnector {
    TransactionResult sendAuthorization(double amount, String transactionId);

    Object authorize(double amount);
} 
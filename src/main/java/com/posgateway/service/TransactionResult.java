package com.posgateway.service;

public class TransactionResult {
    private final boolean approved;
    private final String transactionId;
    private final String message;

    public TransactionResult(boolean approved, String transactionId, String message) {
        this.approved = approved;
        this.transactionId = transactionId;
        this.message = message;
    }

    public boolean isApproved() {
        return approved;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getMessage() {
        return message;
    }
} 
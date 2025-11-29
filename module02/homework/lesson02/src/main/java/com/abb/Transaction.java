package com.abb;

import java.time.LocalDateTime;

public class Transaction {
   
    private final String transactionId;
    private final double amount;
    private final String paymentType;
    private final PaymentStatus status;
    private final LocalDateTime timestamp;
    
    public Transaction(
            String transactionId,
            double amount,
            String paymentType,
            PaymentStatus status
    ) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.paymentType = paymentType;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }
    
    @Override
    public String toString() {
        String id = "ID: " + transactionId;
        String amount = String.format("Amount: %.2f", this.amount);
        String type = "Type: " + paymentType;
        String status = "Status: " + this.status;
        String time = "Time: " + timestamp;
        
        return "Transaction:\n" + id + "\n" + amount + "\n" + type + "\n" + status + "\n" + time;
    }
}
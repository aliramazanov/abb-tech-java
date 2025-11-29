package com.abb;

import java.util.UUID;

public class Main {
    
    static void main () {
        
        PaymentMethod card = new CardPayment("1234567890123456", "Ali Ramazan");
        processTransaction(card, 150.50);
        
        System.out.println();
        
        PaymentMethod cash = new CashPayment(200.0);
        processTransaction(cash, 175.25);
        
        System.out.println();
        
        PaymentMethod insufficientCash = new CashPayment(50.0);
        processTransaction(insufficientCash, 100.0);
        
        System.out.println();
        
        PaymentMethod invalidCard = new CardPayment("123", "Ramazan Alizada");
        processTransaction(invalidCard, 200.0);
    }
    
    private static void processTransaction (
            PaymentMethod paymentMethod,
            double amount
    ) {
        
        String transactionId = UUID
                .randomUUID()
                .toString()
                .substring(0, 12);
        
        PaymentStatus status = paymentMethod.processPayment(amount);
        
        Transaction transaction = new Transaction(
                transactionId,
                amount,
                paymentMethod.getPaymentType(),
                status
        );
        
        System.out.println(transaction);
    }
}
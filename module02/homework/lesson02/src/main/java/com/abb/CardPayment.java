package com.abb;

@SuppressWarnings("ClassCanBeRecord")
public class CardPayment implements PaymentMethod {
    
    private final String cardNumber;
    private final String cardHolder;
    
    public CardPayment (
            String cardNumber,
            String cardHolder
    ) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }
    
    @Override
    public PaymentStatus processPayment(double amount) {
        
        if (cardNumber == null || cardNumber.length() < 13) {
            System.out.println("Invalid Card");
            return PaymentStatus.FAILED;
        }
        
        if (amount <= 0) {
            System.out.println("Invalid Amount");
            return PaymentStatus.FAILED;
        }
        
        System.out.println("Card Payment $" + amount + " for " + cardHolder);
        return PaymentStatus.SUCCESS;
    }
    
    @Override
    public String getPaymentType() {
        return "CREDIT_CARD";
    }
}
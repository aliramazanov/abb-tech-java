package com.abb;

@SuppressWarnings("ClassCanBeRecord")
public class CashPayment implements PaymentMethod {
    
    private final double cashAvailable;
    
    public CashPayment(double cashAvailable) {
        this.cashAvailable = cashAvailable;
    }
    
    @Override
    public PaymentStatus processPayment(double amount) {
        
        if (amount <= 0) {
            System.out.println("Invalid Amount");
            return PaymentStatus.FAILED;
        }
        
        if (cashAvailable < amount) {
            System.out.println("Insufficient Cash. Available: $" + cashAvailable);
            return PaymentStatus.FAILED;
        }
        
        System.out.println("Cash Payment $" + amount);
        return PaymentStatus.SUCCESS;
    }
    
    @Override
    public String getPaymentType() {
        return "CASH";
    }
}
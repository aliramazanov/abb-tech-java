package com.abb;

public interface PaymentMethod {
   
    PaymentStatus processPayment(double amount);
   
    String getPaymentType();
}
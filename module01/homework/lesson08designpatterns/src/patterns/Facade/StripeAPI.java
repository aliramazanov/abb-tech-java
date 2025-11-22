package patterns.Facade;

public class StripeAPI {
    
    public void configure(String apiKey, String mode) {
        System.out.println("Configuring Stripe API");
    }
    
    public String createCustomer(String email, String name) {
        System.out.println("Creating Stripe customer");
        return "customer_123";
    }
    
    public String createPaymentIntent(String customerId, int amount, String currency) {
        System.out.println("Creating payment intent");
        return "payment_intent_456";
    }
    
    public void confirmPayment(String paymentIntentId, String paymentMethod) {
        System.out.println("Confirming payment");
    }
    
    // has more methods you don't need
    // updateCustomer, deleteCustomer, listTransactions, createPayout, etc
}
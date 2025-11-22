package patterns.Facade;

public class PaymentFacade {
    
    private final StripeAPI stripe;
    
    public PaymentFacade(String apiKey) {
        this.stripe = new StripeAPI();
        stripe.configure(apiKey, "live");
    }
    
    public void charge(String email, String name, int amount) {
        
        String customerId = stripe.createCustomer(email, name);
        String paymentIntent = stripe.createPaymentIntent(customerId, amount, "USD");
       
        stripe.confirmPayment(paymentIntent, "card");
       
        System.out.println("Payment successful");
    }
}
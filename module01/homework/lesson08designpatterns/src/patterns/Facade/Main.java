package patterns.Facade;

public class Main {
    
    static void main () {
        
        PaymentFacade payment = new PaymentFacade("test_123");
        payment.charge("ali@mail.com", "Ali", 5000);
    }
}
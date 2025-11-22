package patterns.Abstract_Factory;

public class PaymentFactory extends DocumentFactory {
    
    private final double salary;
    
    public PaymentFactory (double salary) {
        this.salary = salary;
    }
    
    @Override
    protected Document makeDocument (Employee employee) {
        return new PaymentDocument(employee, salary);
    }
}
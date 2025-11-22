package patterns.Abstract_Factory;

@SuppressWarnings("ClassCanBeRecord")
public class PaymentDocument implements Document {
   
    private final Employee employee;
    private final double salary;
    
    public PaymentDocument (Employee employee, double salary) {
        this.employee = employee;
        this.salary = salary;
    }
    
    public String generate () {
        return employee.getName() + ": $" + this.salary;
    }
}

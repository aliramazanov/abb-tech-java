package patterns.Abstract_Factory;

@SuppressWarnings("ClassCanBeRecord")
public class ContractDocument implements Document {
   
    private final Employee employee;
    private final String position;
    private final String startDate;
    
    public ContractDocument (Employee employee, String position, String startDate) {
        this.employee = employee;
        this.position = position;
        this.startDate = startDate;
    }
    
    public String generate () {
        return employee.getName() + ": " + position + ". " + "Start Date: " + startDate;
    }
}
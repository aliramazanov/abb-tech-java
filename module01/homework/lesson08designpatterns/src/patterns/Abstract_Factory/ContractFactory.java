package patterns.Abstract_Factory;

public class ContractFactory extends DocumentFactory {
    
    private final String position;
    private final String startDate;
    
    public ContractFactory (String position, String startDate) {
        this.position = position;
        this.startDate = startDate;
    }
    
    @Override
    protected Document makeDocument (Employee employee) {
        return new ContractDocument(employee, position, startDate);
    }
}
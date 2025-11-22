package patterns.Abstract_Factory;

@SuppressWarnings("ClassCanBeRecord")
public class Employee {
    
    private final String name;
    
    public Employee (String id, String name) {
        this.name = name;
    }
    
    public String getName () { return name; }
}
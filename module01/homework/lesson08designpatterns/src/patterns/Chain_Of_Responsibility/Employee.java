package patterns.Chain_Of_Responsibility;

public class Employee {
    
    private final String name;
    private final int leaveBalance;
    
    public Employee (String name, int leaveBalance) {
        this.name = name;
        this.leaveBalance = leaveBalance;
    }
    
    public int getLeaveBalance () { return leaveBalance; }
    
    public String getName () {
        return name;
    }
}
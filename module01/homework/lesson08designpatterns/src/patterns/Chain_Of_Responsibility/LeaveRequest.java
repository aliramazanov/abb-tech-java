package patterns.Chain_Of_Responsibility;

public class LeaveRequest {
    
    private final Employee employee;
    private final int days;
    private String status;
    
    public LeaveRequest (Employee employee, int days) {
        this.employee = employee;
        this.days = days;
        this.status = "Waiting";
    }
    
    public Employee getEmployee () { return employee; }
    
    public int getDays () { return days; }
    
    public String getStatus () { return status; }
    
    public void setStatus (String status) { this.status = status; }
}
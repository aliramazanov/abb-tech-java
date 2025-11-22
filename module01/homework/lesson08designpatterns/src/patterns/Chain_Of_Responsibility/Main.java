package patterns.Chain_Of_Responsibility;

public class Main {
    
    static void main () {
        
        AbstractLeaveHandler balanceCheck = new LeaveBalanceHandler();
        AbstractLeaveHandler teamLead = new LeadApprovalHandler();
        AbstractLeaveHandler hr = new HRApprovalHandler();
        
        balanceCheck.setNext(teamLead);
        teamLead.setNext(hr);
        
        Employee employee001 = new Employee("Ali", 15);
        Employee employee002 = new Employee("Sara", 5);
        
        System.out.println("Request 1: " + employee001.getName() + " - 2 days");
        LeaveRequest request1 = new LeaveRequest(employee001, 2);
        balanceCheck.processRequest(request1);
        System.out.println("Final Status: " + request1.getStatus());
        
        System.out.println("\nRequest 2:  " + employee001.getName() + "  - 5 days");
        LeaveRequest request2 = new LeaveRequest(employee001, 5);
        balanceCheck.processRequest(request2);
        System.out.println("Final Status: " + request2.getStatus());
        
        System.out.println("\nRequest 3: " + employee001.getName() + "  - 10 days");
        LeaveRequest request3 = new LeaveRequest(employee001, 10);
        balanceCheck.processRequest(request3);
        System.out.println("Final Status: " + request3.getStatus());
        
        System.out.println("\nRequest 4:  " + employee002.getName() + "  - 10 days (insufficient balance)");
        LeaveRequest request4 = new LeaveRequest(employee002, 10);
        balanceCheck.processRequest(request4);
        System.out.println("Final Status: " + request4.getStatus());
    }
}
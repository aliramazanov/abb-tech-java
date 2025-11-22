package patterns.Chain_Of_Responsibility;

public class LeaveBalanceHandler extends AbstractLeaveHandler {
    
    @Override
    protected boolean canHandle (LeaveRequest request) {
        return true;
    }
    
    @Override
    protected void handle (LeaveRequest request) {
        int availableLeave = request.getEmployee().getLeaveBalance();
        
        if (request.getDays() > availableLeave) {
            request.setStatus("Rejected");
            System.out.println("Rejected: Available: " + availableLeave + ", Requested: " + request.getDays());
        }
        else {
            System.out.println("Leave balance check passed. Available: " + availableLeave);
        }
    }
}
package patterns.Chain_Of_Responsibility;

public class LeadApprovalHandler extends AbstractLeaveHandler {
    
    @Override
    protected boolean canHandle (LeaveRequest request) {
        return request.getDays() <= 7;
    }
    
    @Override
    protected void handle (LeaveRequest request) {
        System.out.println("Team Lead approved " + request.getDays() + " days leave");
        request.setStatus("Approved_By_Team_Lead");
    }
}
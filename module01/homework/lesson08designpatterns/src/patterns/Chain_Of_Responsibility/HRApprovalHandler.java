package patterns.Chain_Of_Responsibility;

public class HRApprovalHandler extends AbstractLeaveHandler {
    
    @Override
    protected boolean canHandle (LeaveRequest request) {
        return request.getDays() >= 8;
    }
    
    @Override
    protected void handle (LeaveRequest request) {
        System.out.println("HR approved " + request.getDays() + " days leave");
        request.setStatus("Approved_By_HR");
    }
}
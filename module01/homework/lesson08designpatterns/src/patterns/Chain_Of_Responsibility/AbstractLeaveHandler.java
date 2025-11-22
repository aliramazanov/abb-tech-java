package patterns.Chain_Of_Responsibility;

public abstract class AbstractLeaveHandler {
    
    protected AbstractLeaveHandler nextHandler;
    
    public void setNext (AbstractLeaveHandler handler) {
        this.nextHandler = handler;
    }
    
    public void processRequest (LeaveRequest request) {
        if (canHandle(request)) {
            handle(request);
        }
        
        if (nextHandler != null && !request.getStatus().equals("Rejected")) {
            nextHandler.processRequest(request);
        }
    }
    
    protected abstract boolean canHandle (LeaveRequest request);
    
    protected abstract void handle (LeaveRequest request);
}
package threads;

public class NotificationPractice {
    
    static void main () {
       
        Notification notificationService = new Notification();
        
        Thread notifyUser = new Thread(() -> {
            try {
                notificationService.notifyUser();
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        
        Thread notifyAdmin = new Thread(notificationService::notifyAdmin);
        
        notifyUser.start();
        notifyAdmin.start();
        notificationService.printThreadDetails();
    }
}

public class Deadlock {
    
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    
    public void setLock1 () {
        synchronized (lock1) {
            System.out.println("Operation on lock1 on method 1");
            synchronized (lock2) {
                System.out.println("Operation on lock2 on method 1");
            }
        }
    }
    
    public void setLock2 () {
        
        synchronized (lock2) {
            System.out.println("Operation on lock2 on method 2");
            synchronized (lock1) {
                System.out.println("Operation on lock1 on method 2");
            }
        }
    }
}

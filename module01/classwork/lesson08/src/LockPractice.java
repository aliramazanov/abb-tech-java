class LockPractice {
    private volatile boolean locked = false;
    
    public void lock() {
        System.out.println("Lock Start");
        
        while (locked) {
        }
        locked = true;
        
        System.out.println("Locked");
    }
    
    public void unlock() {
        locked = false;
    }
}
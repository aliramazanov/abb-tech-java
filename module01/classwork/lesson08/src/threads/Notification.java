package threads;

import java.util.Arrays;

public class Notification {
    
    public void notifyUser () throws InterruptedException {
       
        /*
        When a thread enters a synchronized(this) block,
        it acquires the intrinsic lock (also known as a monitor)
        associated with that specific object instance.
        */
        
        synchronized (this) {
            System.out.println("Trying to send");
            this.wait();
            System.out.println("User Notified");
        }
    }
    
    public void notifyAdmin () {
        
        System.out.println("Trying to send (Admin)");
        synchronized (this) {
            System.out.println("Admin Notified");
            this.notify();
            //this.notifyAll();
        }
    }
    
    public void printThreadDetails () {
        Thread t = Thread.currentThread();
        String name = t.getName();
        long id = t.threadId();
        int priority = t.getPriority();
        Thread.State state = t.getState();
        boolean isAlive = t.isAlive();
        String stackTrace = Arrays.toString(t.getStackTrace());
        
        System.out.println("\nThread Name: " + name);
        System.out.println("Thread ID: " + id);
        System.out.println("Thread Priority: " + priority);
        System.out.println("Thread State: " + state);
        System.out.println("Stack Trace: " + stackTrace);
        System.out.println("Is Alive: " + isAlive + "\n");
    }
}

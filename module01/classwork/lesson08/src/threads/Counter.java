package threads;

import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("CommentedOutCode")
public class Counter {
    
    private int count;
    private final AtomicInteger aInt = new AtomicInteger();
    
    private Object syncBlock = new Object();
    private Object syncMethod = new Object();
    
    // synchronized - non-access modifier
    public synchronized void incrementSync () {
        count++;
        System.out.println("Count is: " + count);
    }
    
    public void increment () {
        synchronized (this) {
            try {
                count++;
                System.out.println("Count is: " + count);
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    /* public void increment () {
        synchronized (this) {
            count++;
            System.out.println("Count is: " + count);
        }
    } */
    
     /* public void increment () {
        synchronized (Counter.class) {
            count++;
            System.out.println("Count is: " + count);
        }
    } */
    
    /* public  void increment () {
        count++;
        System.out.println("Count is: " + count);
    } */
    
    
    public void incrementAtomic () {
    
    }
    
    // Reentrant Lock
    // Deadlock, Livelock, Starvation
}

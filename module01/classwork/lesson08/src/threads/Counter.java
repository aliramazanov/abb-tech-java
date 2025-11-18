package threads;

import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("CommentedOutCode")
public class Counter {

    private int count;
    private AtomicInteger aInt = new AtomicInteger();
   
    // synchronized - non-access modifier
    public synchronized void increment () {
        count++;
        System.out.println("Count is: " + count);
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
}

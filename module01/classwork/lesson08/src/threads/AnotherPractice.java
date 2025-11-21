package threads;

public class AnotherPractice {
    
    static void main () {
        
        Counter counter = new Counter();
        
        Runnable runnable = () -> {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            
            counter.incrementSync();
        };
        
        Thread zero = new Thread(runnable, "Zero");
        Thread one = new Thread(runnable, "One");
        Thread two = new Thread(runnable, "Two");
        Thread three = new Thread(runnable, "Three");
        Thread four = new Thread(runnable, "Four");
        
        zero.start();
        one.start();
        two.start();
        three.start();
        four.start();
        
        Thread threadSync = new Thread(counter::incrementSync);
        Thread threadNonSync = new Thread(counter::increment);
        
        threadNonSync.start();
        threadSync.start();
        
        System.out.println("Main Thread");
    }
}

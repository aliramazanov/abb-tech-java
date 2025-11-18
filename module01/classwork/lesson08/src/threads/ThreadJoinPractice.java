package threads;
import java.time.LocalDateTime;

public class ThreadJoinPractice {
    
    static void main () {
        
        Thread one = new Thread(() -> System.out.println("Thread One " + LocalDateTime.now()));
        
        Thread two = new Thread(() -> {
            try {
                one.join();
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            
            System.out.println("Thread Two " + LocalDateTime.now());
            
            try {
                Thread.sleep(1500);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        
        Thread three = new Thread(() -> {
            try {
                two.join();
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            
            System.out.println("Thread Three " + LocalDateTime.now());
        });
        
        one.start();
        two.start();
        three.start();
    }
}

package threads;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Concurrency & Parallelism, Threads

public class Practice {
    
    static void main () {
        
        ThreadExample te = new ThreadExample();
        //noinspection CallToThreadRun
        te.run();
        te.start();
        
        ThreadWithRunnable threadWithRunnable = new ThreadWithRunnable();
        //threadWithRunnable.run();
        Thread thread = new Thread(threadWithRunnable);
        thread.start();
        
        Thread.ofVirtual().factory().newThread(threadWithRunnable).start();
        
        Thread t = new Thread(() -> {
            System.out.println("Running the Thread with Lambda Expression");
        }, "ThreadPractice");
        t.start();
        
       try (ExecutorService es = Executors.newFixedThreadPool(10)){
          
           for (int i = 0; i < 10; i++) {
               es.execute(() -> System.out.println("Running Executor Service" + LocalDateTime.now()));
           }
       }
       
        // This executes on the main (current) thread, for multithreading, it should be passed to a new Thread.
        Runnable runnable = () -> System.out.println("Runnable");
        runnable.run();
        Thread tR = new Thread(runnable);
        tR.start();
    }
}

package threads;

public class ThreadWithRunnable implements Runnable {
   
    @Override
    public void run () {
        System.out.println("Runnable Thread");
    }
}

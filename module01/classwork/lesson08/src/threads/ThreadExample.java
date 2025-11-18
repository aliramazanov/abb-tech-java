package threads;

public class ThreadExample extends Thread {
    
    @Override
    public void run () {
        System.out.println("Thread Test Run");
    }
    
    @Override
    public void start () {
        System.out.println("Thread Test Start");
    }
}

public class Practice {
    
    static void main () {
        
        Deadlock deadlock = new Deadlock();
        
        Thread thread = new Thread(deadlock::setLock1);
        
        Thread threadOther = new Thread(deadlock::setLock2);
        
        thread.start();
        threadOther.start();
        
        LockPractice lockPractice = new LockPractice();
        lockPractice.lock();
        lockPractice.unlock();
    }
}

package news;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    
    static void main () {
        
        NewsPublisher publisher = new NewsPublisher();
        
        Subscriber subscriber1 = new Subscriber("İzləyici-1", publisher);
        Subscriber subscriber2 = new Subscriber("İzləyici-2", publisher);
        Subscriber subscriber3 = new Subscriber("İzləyici-3", publisher);
        
        publisher.getSubscriberList().add(subscriber1);
        publisher.getSubscriberList().add(subscriber2);
        publisher.getSubscriberList().add(subscriber3);
        
        try (ExecutorService executorService = Executors.newFixedThreadPool(3)) {
            executorService.execute(subscriber1);
            executorService.execute(subscriber2);
            executorService.execute(subscriber3);
            
            int counter = 1;
            
            while (true) {
                Thread.sleep(2000);
                publisher.publishNews("Xəbər #" + counter++);
            }
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
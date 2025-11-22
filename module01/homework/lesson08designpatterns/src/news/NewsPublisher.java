package news;

import java.util.ArrayList;
import java.util.List;

public class NewsPublisher {
    private final List<Subscriber> subscriberList = new ArrayList<>();
    public String latestNews;
    public boolean isNewsAvailable;
    
    public List<Subscriber> getSubscriberList () {
        return subscriberList;
    }
    
    public synchronized void publishNews (String news) {
        this.latestNews = news;
        this.isNewsAvailable = true;
        System.out.println("Publisher: Yeni xəbər yayımlandı -> " + news);
        notifyAll();
    }
    
    public synchronized void notifyAllSubscribers () {
        for (Subscriber subscriber : subscriberList) {
            subscriber.update(latestNews);
        }
    }
    
    public synchronized String getNews () throws InterruptedException {
        while (!isNewsAvailable) {
            wait();
        }
        isNewsAvailable = false;
        return latestNews;
    }
}

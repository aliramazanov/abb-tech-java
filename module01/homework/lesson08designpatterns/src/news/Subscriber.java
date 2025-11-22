package news;

@SuppressWarnings("ClassCanBeRecord")
public class Subscriber implements Runnable {
    private final String name;
    private final NewsPublisher publisher;
    
    public Subscriber (String name, NewsPublisher publisher) {
        this.name = name;
        this.publisher = publisher;
    }
    
    public void update (String news) {
        System.out.println(name + " xəbər aldı: " + news);
    }
    
    @Override
    public void run () {
        while (true) {
            try {
                String news = publisher.getNews();
                update(news);
            }
            catch (InterruptedException e) {
                return;
            }
        }
    }
}
package anonymous;

public class Practice {
    
    static void main () {
        
        DisplayService tv = new TV();
        DisplayService projector = new Projector();
        
        tv.display();
        projector.display();
        
        new DisplayService() {
            
            @Override
            public void display () {
                System.out.println("Displaying anonymous");
            }
        };
        
        DisplayService ids = () -> System.out.println("Anonymous displayed again");
        ids.display();
        
        AbstractDisplayService ads = new AbstractDisplayService() {
           
            @Override
            void display () {
                System.out.println("Displaying AbstractDisplayService ");
            }
        };
        
        ads.display();
    }
}

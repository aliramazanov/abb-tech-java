package generics;

public class GenericPrinter <T> {
    
    public void print (T[] objects) {
       
        if (!(objects.length == 0)) {
           
            for (T object : objects) {
                System.out.println(object);
            }
        }
    }
}

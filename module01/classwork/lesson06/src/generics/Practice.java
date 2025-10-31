package generics;

public class Practice {
    
    static void main () {
        
        GenericPrinter<String> string = new GenericPrinter<>();
        string.print(new String[] { "Hello", "World", "!" });
        
        GenericPrinter<Integer> integer = new GenericPrinter<>();
        integer.print(new Integer[] { 4, 8, 10, 12 });
    }
    
    public <T> void doSomething (T arg) {};
}

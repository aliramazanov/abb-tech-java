package inheritance;

public interface InterfaceBehaviour {
    
    default void sleepInterface () {
        System.out.println("The animal is sleeping");
    }
}

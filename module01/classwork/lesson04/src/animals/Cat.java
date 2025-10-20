package animals;

public class Cat {
    
    static int counter = 0;
    
    static {
        System.out.println("Static Initializer Block Run");
    }
    
    static {
        System.out.println("Second Static Initializer Block Run");
    }
    
    static {
        System.out.println("Third Static Initializer Block Run");
    }
    
    public String name;
    public int age;
    
    {
        System.out.println("Initializer Block: " + counter);
        counter++;
    }
    
    {
        System.out.println("Initializer Block: " + counter);
        counter++;
    }
    
    {
        System.out.println("Initializer Block: " + counter);
        counter++;
    }
    
    public Cat () {
        System.out.println("Constructor Works");
    }
    
}

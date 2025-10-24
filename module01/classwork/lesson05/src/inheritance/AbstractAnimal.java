package inheritance;

public abstract class AbstractAnimal {
    
    private final String name;
    private final int age;
    
    protected AbstractAnimal (String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public abstract void eat ();
    
    public void sleepAbstract () {
        System.out.println("Sleeping...");
    }
    
    public int getAge () {
        return age;
    }
    
    public String getName () {
        return name;
    }
}

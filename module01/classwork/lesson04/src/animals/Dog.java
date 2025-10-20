package animals;

public class Dog {
    
    public static int food = 100;
    
    public String name;
    public int age;
    protected String type;
    private int count;
    private String owner;
    
    public Dog (String name, int age, String owner, int count, String type) {
        this.age = age;
        this.name = name;
        this.owner = "Owner";
        this.count = count;
        this.type = type;
    }
    
    public Dog (String name) {
        this.name = name;
    }
    
    public Dog (int age) {
        this.age = age;
    }
    
    static public void eat (int howMuchEaten) {
        food = food - howMuchEaten;
    }
    
    public void run (long distance, short speed) {
        System.out.println(name + " is running at " + speed + "km/h speed for the " + distance + "km distance.");
    }
}
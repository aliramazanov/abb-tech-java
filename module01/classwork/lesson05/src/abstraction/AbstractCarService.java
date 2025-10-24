package abstraction;

public abstract class AbstractCarService {
    
    public final String name;
    public String address;
    public String workDays;
    
    public AbstractCarService (String name, String address, String workDays) {
        this.name = name;
        this.address = address;
        this.workDays = workDays;
    }
    
    public abstract void repair ();
    
    public void changeTires () {
        System.out.println("Repairing the car");
    }
    
    public void paint () {
        System.out.println("Painting the car");
    }
    
    public final void diagnose () {
        System.out.println("Diagnosing the car");
    }
}

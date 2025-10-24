package inheritance;

public class Dog extends AbstractAnimal implements InterfaceAnimal, InterfaceBehaviour {
    
    private final String parentProperty;
    
    protected Dog (String name, int age, String parentProperty) {
        super(name, age);
        this.parentProperty = parentProperty;
    }
    
    @Override
    public void eat () {
        System.out.println("The dog is eating");
    }
    
    public String getParentProperty () {
        return parentProperty;
    }
}

package inheritance;

public class Cat extends AbstractAnimal{
    
    private final String parentProperty;
    
    protected Cat (String name, int age, String parentProperty) {
        super(name, age);
        this.parentProperty = parentProperty;
    }
    
    @Override
    public void eat () {
    
    }
    
    public String getParentProperty () {
        return parentProperty;
    }
}

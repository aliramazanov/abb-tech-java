import java.util.Objects;

@SuppressWarnings("FieldMayBeFinal")
public class Car {
 
    private int id;
    private String brand;
    private String model;
    private int year;
    
    public Car(int id, String brand, String model, int year) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    
    public String getModel() {
        return model;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return brand + " " + model + " (" + year + ")";
    }
}
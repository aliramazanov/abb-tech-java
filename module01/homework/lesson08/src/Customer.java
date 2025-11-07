import java.util.Objects;

@SuppressWarnings("FieldMayBeFinal")
public class Customer {
    
    private int id;
    private String name;
    private String licenseNumber;
    
    public Customer (int id, String name, String licenseNumber) {
        this.id = id;
        this.name = name;
        this.licenseNumber = licenseNumber;
    }
    
    public String getName () {
        return name;
    }
    
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id;
    }
    
    @Override
    public int hashCode () {
        return Objects.hash(id);
    }
    
    @Override
    public String toString () {
        return "Customer: " + id + " Name: " + name;
    }
    
    public String getLicenseNumber () {
        return licenseNumber;
    }
}
public class OverloadMethods {
    
    public void drive (int distance, String name) {
        System.out.println("Driving " + distance + " miles on " + name);
    }
    
    public void drive (String name) {
        System.out.println("Driving " + name);
    }
    
    public void drive () {
        System.out.println("Driving Toyota");
    }
    
    public void drive (String make, String model) {
        System.out.println("Driving " + make + " " + model);
    }
}

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@SuppressWarnings("FieldMayBeFinal")
public class CarRental {
    
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm:ss a");
    
    private Set<Car> allCars;
    private Map<Customer, Car> activeRentals;
    private Map<Car, LocalDateTime> rentalStartTimes;
    private Set<Car> availableCars;
    private List<Record> rentalHistory;
    private Map<Car, LocalDateTime> history;
    
    public CarRental () {
        this.allCars = new HashSet<>();
        this.activeRentals = new HashMap<>();
        this.rentalStartTimes = new HashMap<>();
        this.availableCars = new HashSet<>();
        this.rentalHistory = new ArrayList<>();
        this.history = new HashMap<>();
    }
    
    public void addCar (Car car) {
        allCars.add(car);
        availableCars.add(car);
    }
    
    public void rentCar (Customer customer, Car car) {
        if (!availableCars.contains(car)) {
            System.out.println("Car is not available!");
            return;
        }
        
        availableCars.remove(car);
        activeRentals.put(customer, car);
        
        LocalDateTime rentTime = LocalDateTime.now();
        rentalStartTimes.put(car, rentTime);
        
        Record record = new Record(car, customer, rentTime);
        rentalHistory.add(record);
        
        System.out.println(customer.getName() + " rented " + car.getModel() + " at " + rentTime.format(FORMATTER));
    }
    
    public void returnCar(Customer customer) {
        
        Car car = activeRentals.get(customer);
        
        if (car == null) {
            System.out.println("No active rental found for " + customer.getName());
            return;
        }
        
        LocalDateTime rentTime = rentalStartTimes.get(car);
        
        if (rentTime == null) {
            System.out.println("Missing start time for car " + car + ". Cannot compute duration.");
            return;
        }
        
        LocalDateTime returnTime = LocalDateTime.now();
        Duration duration = Duration.between(rentTime, returnTime);
        
        long days = duration.toDays();
        long hoursRemainder = duration.minusDays(days).toHours();
        
        for (Record record : rentalHistory) {
            if (record.getCar().equals(car) && record.getReturnTime() == null) {
                record.setReturnTime(returnTime);
                break;
            }
        }
        
        activeRentals.remove(customer);
        rentalStartTimes.remove(car);
        availableCars.add(car);
        history.put(car, returnTime);
        
        System.out.println("Returned at: " + returnTime.format(FORMATTER));
        
        System.out.println(
                customer.getName() + " returned " + car.getModel()
                + " after " + days + " days " + hoursRemainder + " hours ("
                + duration.toHours() + " hours total)"
        );
    }
    
    public void printActiveRentals () {
        System.out.println("Active Rentals:");
        for (Map.Entry<Customer, Car> entry : activeRentals.entrySet()) {
            Customer customer = entry.getKey();
            Car car = entry.getValue();
            LocalDateTime rentTime = rentalStartTimes.get(car);
            System.out.println(customer.getName() + " -> " + car.getModel() + " (rented at " + rentTime.format(FORMATTER) + ")");
        }
    }
    
    public void printAvailableCars () {
        System.out.println("Available Cars: ");
        
        for (Car car : availableCars) {
            System.out.println(car);
        }
    }
    
    public void printHistory() {
        System.out.println("Rental History:");
        
        for (Record r : rentalHistory) {
            if (r.getReturnTime() != null) {
                System.out.println(
                        r.getCar() +
                        " | started renting at " + r.getRentTime().format(FORMATTER) +
                        " | returned at " + r.getReturnTime().format(FORMATTER)
                );
            }
        }
        
        System.out.println("Last Return Times:");
        
        for (Map.Entry<Car, LocalDateTime> entry : history.entrySet()) {
            System.out.println(entry.getKey() + " last returned at " + entry.getValue().format(FORMATTER));
        }
    }
}
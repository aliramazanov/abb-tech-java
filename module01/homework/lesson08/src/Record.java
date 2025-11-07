import java.time.LocalDateTime;

public class Record {
   
    private Car car;
    private Customer customer;
    private LocalDateTime rentTime;
    private LocalDateTime returnTime;
    
    public Record(Car car, Customer customer, LocalDateTime rentTime) {
        this.car = car;
        this.customer = customer;
        this.rentTime = rentTime;
    }
    
    public Car getCar() {
        return car;
    }
    
    public LocalDateTime getReturnTime() {
        return returnTime;
    }
    
    public void setReturnTime(LocalDateTime returnTime) {
        this.returnTime = returnTime;
    }
    
    public LocalDateTime getRentTime () {
        return rentTime;
    }
    
    public Customer getCustomer () {
        return customer;
    }
}
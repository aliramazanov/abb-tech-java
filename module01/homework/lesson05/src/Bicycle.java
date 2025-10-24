public class Bicycle implements Transport {
    
    private final double ratePerKm;
    private final double speed;
    
    public Bicycle (double ratePerKm, double speed) {
        this.ratePerKm = TransportType.BICYCLE.getRatePerKm();
        this.speed = TransportType.BICYCLE.getSpeed();
    }
    
    @Override
    public double calculateFare (double distance) {
        return this.ratePerKm * distance;
    }
    
    @Override
    public double calculateFare (double distance, int passengers) {
        return this.ratePerKm * distance;
    }
    
    @Override
    public double calculateTime (double distance) {
        return distance / this.speed;
    }
    
    @Override
    public String getTransportInfo () {
        return "Bicycle  -> " + "Rate per KM: " + ratePerKm + ", and Speed: " + speed;
    }
}

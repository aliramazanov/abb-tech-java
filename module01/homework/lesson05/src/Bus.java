public class Bus implements Transport {
    
    private final double ratePerKm;
    private final double speed;
    
    public Bus (double ratePerKm, double speed) {
        this.ratePerKm = TransportType.BUS.getRatePerKm();
        this.speed = TransportType.BUS.getSpeed();
    }
    
    @Override
    public double calculateFare (double distance) {
        return this.ratePerKm * distance;
    }
    
    @Override
    public double calculateFare (double distance, int passengers) {
        return this.ratePerKm * passengers;
    }
    
    @Override
    public double calculateTime (double distance) {
        return distance / this.speed;
    }
    
    @Override
    public String getTransportInfo () {
        return "Bus transport -> " + "Rate per KM: " + ratePerKm + ", and Speed: " + speed;
    }
}

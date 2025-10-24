public class Scooter implements Transport {
   
    private final double ratePerKm;
    private final double speed;
    
    public Scooter (double ratePerKm, double speed) {
        this.ratePerKm = TransportType.SCOOTER.getRatePerKm();
        this.speed = TransportType.SCOOTER.getSpeed();
    }
    
    @Override
    public double calculateFare (double distance) {
        return this.ratePerKm * distance;
    }
    
    @Override
    public double calculateFare (double distance, int passengers) {
        return distance * ratePerKm + 2.5;
    }
    
    @Override
    public double calculateTime (double distance) {
        return distance / this.speed;
    }
    
    @Override
    public String getTransportInfo () {
        return "Scooter -> " + "Rate per KM: " + ratePerKm + ", and Speed: " + speed;
    }
}

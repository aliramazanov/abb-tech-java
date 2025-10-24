public class Taxi implements Transport {
    
    private final double ratePerKm;
    private final double speed;
    
    public Taxi (double ratePerKm, double speed) {
        this.ratePerKm = TransportType.TAXI.getRatePerKm();
        this.speed = TransportType.TAXI.getSpeed();
    }
    
    @Override
    public double calculateFare (double distance) {
        return this.ratePerKm * distance;
    }
    
    @Override
    public double calculateFare (double distance, int passengers) {
        double baseFare = distance * ratePerKm + 5.0;
        return passengers > 2 ? baseFare + (passengers - 2) * 3.0 : baseFare;
    }
    
    @Override
    public double calculateTime (double distance) {
        return distance / this.speed;
    }
    
    @Override
    public String getTransportInfo () {
        return "Taxi transport -> " + "Rate per KM: " + ratePerKm + ", and Speed: " + speed;
    }
}

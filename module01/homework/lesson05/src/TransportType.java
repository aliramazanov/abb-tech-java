public enum TransportType {
    
    BUS(0.6, 40.0, "Commuting, Tourism, School"),
    TAXI(4.0, 80.0, "Business, Emergency, Comfort"),
    BICYCLE(0.3, 10.0, "Exercise, Recreation, Eco-friendly"),
    SCOOTER(0.5, 25.0, "Quick-trips, Urban, Last-mile");
    
    private final double ratePerKm;
    private final double speed;
    private final String usageCases;
    
    TransportType (double ratePerKm, double speed, String usageCases) {
        this.ratePerKm = ratePerKm;
        this.speed = speed;
        this.usageCases = usageCases;
    }
    
    public double getRatePerKm () {
        return ratePerKm;
    }
    
    public double getSpeed () {
        return speed;
    }
    
    public String getUsageCases () {
        return usageCases;
    }
}
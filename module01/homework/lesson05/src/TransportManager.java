import java.util.Scanner;

public class TransportManager {
    
    static void main () {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Available transports:");
        TransportType[] transports = TransportType.values();
        
        for (TransportType transportType : transports) {
            System.out.println(transportType + " - " + transportType.getUsageCases());
        }
        
        System.out.print("\nChoose transport (1-4): ");
        int choice = scanner.nextInt();
        
        TransportType userChoice = transports[choice - 1];
        Transport transport = getTransport(userChoice);
        
        System.out.print("Enter distance (km): ");
        double distance = scanner.nextDouble();
        
        System.out.print("Enter number of passengers: ");
        int passengers = scanner.nextInt();
        
        String info = null;
        if (transport != null) {
            info = transport.getTransportInfo();
        }
        
        double fare = 0;
        if (transport != null) {
            fare = transport.calculateFare(distance, passengers);
        }
        
        double time = 0;
        if (transport != null) {
            time = transport.calculateTime(distance);
        }
        
        System.out.println("\nTransport Info: " + info);
        System.out.println("Fare for " + passengers + " passenger(s): " + String.format("%.1f", fare));
        System.out.println("Estimated time: " + time + " hours");
        scanner.close();
    }
    
    public static Transport getTransport (TransportType type) {
        switch (type) {
            case BUS -> { return new Bus(type.getRatePerKm(), type.getSpeed()); }
            case TAXI -> { return new Taxi(type.getRatePerKm(), type.getSpeed()); }
            case BICYCLE -> { return new Bicycle(type.getRatePerKm(), type.getSpeed()); }
            case SCOOTER -> { return new Scooter(type.getRatePerKm(), type.getSpeed()); }
            
            default -> {
                System.out.println("Error!");
                return null;
            }
        }
    }
}
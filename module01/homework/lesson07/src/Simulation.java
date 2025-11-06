import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("ExplicitToImplicitClassMigration")
public class Simulation {

    private static final String[] NAMES = {
            "Aysel", "Rauf", "Murad", "Nigar", "Samir",
            "Leyla", "Tural", "Sevinc", "Laman",
            "Emin", "Gunel", "Orxan", "Kamran",
            "Nurlan", "Sabina"
    };

    private static final java.util.Random randomName = new java.util.Random();

    static void main() {
        List<Stop> stops = new LinkedList<>();

        for (StopId id : StopId.values()) {
            stops.add(new Stop(id));
        }

        Bus bus = new Bus();

        seedStops(stops, new int[]{4, 3, 2, 5});

        for (Stop stop : stops) {
            System.out.println(stop.getId().getLabel() + " reached.");

            int leaving = 1 + randomName.nextInt(2);
            List<Passenger> left = bus.removeRandomPassengers(leaving);

            for (Passenger p : left) {
                System.out.println(p + " left the bus.");
            }

            int boardedCount = stop.boardToCount(bus);

            if (boardedCount > 0) {
                System.out.println(boardedCount + " passenger(s) boarded.");
            } else {
                System.out.println("No one boarded.");
            }

            System.out.println("Bus now: " + (bus.getExistingPassengers()));
            System.out.println(stop.getId().getLabel() + " remaining: " + stop.getRemainingPassengers());
            System.out.println();
        }

        System.out.println("Simulation finished.");
        System.out.println("Passengers left: " + bus.getExistingPassengers());
    }

    private static void seedStops(List<Stop> stops, int[] countsPerStop) {

        int usable = Math.min(stops.size(), countsPerStop.length);

        for (int i = 0; i < usable; i++) {
            Stop stop = stops.get(i);
            int count = countsPerStop[i];

            for (int j = 0; j < count; j++) {
                String name = randomName();
                boolean priority = randomPriority();
                stop.addPassenger(new Passenger(name, priority));
            }
        }
    }

    private static String randomName() {
        return NAMES[randomName.nextInt(NAMES.length)];
    }

    private static boolean randomPriority() {
        return randomName.nextBoolean();
    }
}

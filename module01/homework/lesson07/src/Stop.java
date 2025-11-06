import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Stop {

    private static final int MAX_CAPACITY = 10;
    private final StopId id;
    private final Queue<Passenger> priority;
    private final Queue<Passenger> normal;

    public Stop(StopId id) {
        this.id = id;
        this.priority = new LinkedList<>();
        this.normal = new LinkedList<>();
    }

    public void addPassenger(Passenger passenger) {
        if (canAddPassenger()) {
            enqueuePassenger(passenger);
        } else {
            handleFullStop(passenger);
        }
    }

    private int currentSize() {
        return priority.size() + normal.size();
    }

    private boolean canAddPassenger() {
        return currentSize() < MAX_CAPACITY;
    }

    private void enqueuePassenger(Passenger passenger) {
        if (passenger.isPriority()) {
            priority.add(passenger);
        }
        else {
            normal.add(passenger);
        }
    }

    private void handleFullStop(Passenger passenger) {
        String message = "[Stop: " + id + "] Capacity is full (10). Cannot add: " + passenger.getName();
        System.out.println(message);
    }

    public int boardToCount(Bus bus) {
        int boarded = 0;
        List<Passenger> boardedPassengers = new LinkedList<>();

        while (!priority.isEmpty() && bus.tryBoard(priority.peek())) {
            boardedPassengers.add(priority.poll());
            boarded++;
        }

        while (!normal.isEmpty() && bus.tryBoard(normal.peek())) {
            boardedPassengers.add(normal.poll());
            boarded++;
        }

        for (Passenger p : boardedPassengers) {
            System.out.println(p + " boarded the bus.");
        }

        return boarded;
    }

    public java.util.List<Passenger> getRemainingPassengers() {
        java.util.List<Passenger> out = new java.util.LinkedList<>(priority);
        out.addAll(normal);
        return out;
    }

    public StopId getId() {
        return id;
    }
}

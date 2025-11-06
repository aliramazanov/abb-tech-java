import java.util.LinkedList;
import java.util.List;

public class Bus {

    private static final int MAX_CAPACITY = 5;
    private final List<Passenger> passengers;
    private final java.util.Random random;

    Bus() {
        this.passengers = new LinkedList<>();
        random = new java.util.Random();
    }

    public boolean tryBoard(Passenger passenger) {
        if (!canAddPassenger()) {
            return false;
        }

        passengers.add(passenger);
        return true;
    }

    private int getCurrentSize() {
        return passengers.size();
    }

    private boolean canAddPassenger() {
        return getCurrentSize() < MAX_CAPACITY;
    }

    private boolean canRemovePassenger() {
        return getCurrentSize() > 0;
    }

    public List<Passenger> removeRandomPassengers(int count) {
        if (!canRemovePassenger()) {
            return new LinkedList<>();
        }

        int num = getCurrentSize();
        int allowed = Math.min(count, num);

        List<Passenger> removed = new LinkedList<>();

        for (int i = 0; i < allowed; i++) {
            int index = random.nextInt(getCurrentSize());
            Passenger removedPassenger = passengers.remove(index);
            removed.add(removedPassenger);
        }

        return removed;
    }

    public List<Passenger> getExistingPassengers() {
        return new LinkedList<>(passengers);
    }
}

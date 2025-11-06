@SuppressWarnings("ClassCanBeRecord")
public final class Passenger {

    private final String name;
    private final boolean isPriority;

    public Passenger(String name, boolean isPriority) {
        if (name == null) {
            System.out.println("Passenger name has not been entered correctly");
            this.name = "InvalidName";
        } else {
            this.name = name;
        }

        this.isPriority = isPriority;
    }

    public String getName() {
        return name;
    }

    public boolean isPriority() {
        return isPriority;
    }

    @Override
    public String toString() {
        return isPriority ? name + "(PRIORITY)" : name;
    }
}

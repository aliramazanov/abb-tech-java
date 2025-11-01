import java.util.Objects;

@SuppressWarnings("ClassCanBeRecord")
public class Elephant implements Comparable<Elephant> {
    
    private final String name;
    private final int age;
    private final String color;
    private final int numberOfLegs;
    
    public Elephant (String name, int age, String color, int numberOfLegs) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.numberOfLegs = numberOfLegs;
    }
    
    @Override
    public String toString () {
        return "Elephant " + this.name + " " + this.color;
    }
    
    @Override
    public int compareTo (Elephant o) {
        return this.age - o.age;
    }
    
    @Override
    public boolean equals (Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Elephant other = (Elephant) obj;
        return age == other.age &&
               numberOfLegs == other.numberOfLegs &&
               Objects.equals(name, other.name) &&
               Objects.equals(color, other.color);
    }
    
    
    @Override
    public int hashCode () {
        return Objects.hash(name, age, color, numberOfLegs);
    }
}

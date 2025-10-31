public class Car {
    
    private final String name;
    private final String color;
    
    Car (String name, String color) {
        this.name = name;
        this.color = color;
    }
    
    public class Engine {
       
        private final int horsepower;
        
        Engine (int horsepower) {
            this.horsepower = horsepower;
        }
        
        public void start () {
            System.out.println("Engine started for the " + color + " " + name);
        }
        
        public int getHorsepower () {
            return this.horsepower;
        }
    }
    
    static class Transmission {
       
        public static int numberOfGears;
        
        Transmission (int numberOfGears) {
            Transmission.numberOfGears = numberOfGears;
        }
        
        public void shiftGearUp () {
            numberOfGears++;
            System.out.println("Gears shifted up: " + numberOfGears);
        }
        
        public void shiftGearDown () {
            numberOfGears--;
            System.out.println("Gears shifted down: " + numberOfGears);
        }
    }
}

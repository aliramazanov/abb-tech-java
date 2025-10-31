void main () {
    Car.Engine ferrari = new Car("Ferrari", "red").new Engine(450);
    ferrari.start();
    
    Car porsche = new Car("Porsche", "black");
    Car.Engine porscheEngine = porsche.new Engine(800);
    
    porscheEngine.start();
    int horsepower = porscheEngine.getHorsepower();
    
    System.out.println(horsepower);
    
    Car.Engine pagani = new Car("Pagani", "grey").new Engine(550);
    pagani.start();
    Car.Transmission transmission = new Car.Transmission(6);
    transmission.shiftGearUp();
}

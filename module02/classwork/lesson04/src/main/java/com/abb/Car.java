package com.abb;

public class Car {
    String name;
    String color;
    int year;
    int speed;
    
    public Car (
            String name,
            String color,
            int year,
            int speed
    ) {
        this.name = name;
        this.color = color;
        this.year = year;
        this.speed = speed;
    }
    
    @Override
    public String toString () {
        return "Car{" +
               "name='" + name + '\'' +
               ", color='" + color + '\'' +
               ", year=" + year +
               ", speed=" + speed +
               '}';
    }
}

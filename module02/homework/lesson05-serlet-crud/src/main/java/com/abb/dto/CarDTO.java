package com.abb.dto;

public class CarDTO {
    
    private final String color;
    private final int speed;
    private int id;
    
    public CarDTO (String color, int speed) {
        this.color = color;
        this.speed = speed;
    }
    
    private CarDTO (CarBuilder builder) {
        this.color = builder.color;
        this.speed = builder.speed;
        this.id = builder.id;
    }
    
    public static CarBuilder builder () {
        return new CarBuilder();
    }
    
    public String getColor () {
        return color;
    }
    
    public int getSpeed () {
        return speed;
    }
    
    public int getId () {
        return id;
    }
    
    public static class CarBuilder {
        
        private String color;
        private int speed;
        private int id;
        
        public CarBuilder () {
        }
        
        public CarBuilder color (String color) {
            this.color = color;
            return this;
        }
        
        public CarBuilder speed (int speed) {
            this.speed = speed;
            return this;
        }
        
        public CarBuilder id (int id) {
            this.id = id;
            return this;
        }
        
        public CarDTO build () {
            return new CarDTO(this);
        }
    }
}

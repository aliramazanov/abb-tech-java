package com.abb.repository;

import com.abb.model.CarModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarRepositoryImplementation implements CarRepository {
    
    private static final List<CarModel> cars = new ArrayList<>();
    private static int idCounter = 0;
    
    @Override
    public List<CarModel> getCars () {
        return cars;
    }
    
    @Override
    public Optional<CarModel> getCarById (int id) {
        return cars
                .stream()
                .filter(car -> car.getId() == id)
                .findFirst();
    }
    
    @Override
    public void saveCar (CarModel car) {
        idCounter++;
        
        car.setId(idCounter);
        car.setDbCode("Car" + car.getId());
        
        cars.add(car);
    }
    
    @Override
    public void deleteCarById (int id) {
        cars.removeIf(car -> car.getId() == id);
    }
    
    @Override
    public void updateCar (int id, CarModel car) {
        Optional<CarModel> optional = getCarById(id);
       
        if (optional.isPresent()) {
            CarModel existingCar = optional.get();
            existingCar.setColor(car.getColor());
            existingCar.setSpeed(car.getSpeed());
        }
    }
    
    @Override
    public void clear () {
        cars.clear();
        idCounter = 0;
    }
}
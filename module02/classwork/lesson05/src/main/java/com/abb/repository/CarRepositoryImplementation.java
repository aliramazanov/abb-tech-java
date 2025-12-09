package com.abb.repository;

import com.abb.dto.CarDTO;
import com.abb.model.CarModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarRepositoryImplementation implements CarRepository {
    
    private static List<CarModel> cars = new ArrayList<>();
    
    @Override
    public List<CarModel> getCars() {
        return cars;
    }
    
    @Override
    public Optional<Car> getCarById(int id) {
        return cars.stream()
                .filter(car -> car.getId() == id)
                .findFirst();
    }
    
    @Override
    public CarModel addCar (CarModel car) {
        car.setId(cars.size() + 1);
        car.setDbCode("Car" + car.getId());
        cars.add(car);
        return car;
    }
    
    @Override
    public void deleteCarById (int id) {
        cars.removeIf(car -> car.getId() == id);
    }
    
    @Override
    public void updateCar(int id, CarDTO car) {
        Optional<CarDTO> optional = getCarById(id);
        if (optional.isPresent()) {
            CarDTO newCar = optional.get();
            car.setColor(newCar.getColor());
            car.setSpeed(newCar.getSpeed());
            car.setDbCode(newCar.getDbCode());
            cars.set(cars.indexOf(car), car);
        }
    }
    
}

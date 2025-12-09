package com.abb.service;

import com.abb.dto.CarDTO;
import com.abb.repository.CarRepository;

import java.util.List;

public class CarServiceImplementation implements CarService{
    private final CarRepository carRepository;
    
    public CarServiceImplementation (CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    
    @Override
    public List<CarDTO> getCars () {
        return List.of();
    }
    
    @Override
    public CarDTO getCarById (int id) {
        return null;
    }
    
    @Override
    public CarDTO addCar (CarDTO car) {
        return null;
    }
    
    @Override
    public void updateCar (CarDTO car) {
    
    }
    
    @Override
    public void deleteCar (int id) {
    
    }
}

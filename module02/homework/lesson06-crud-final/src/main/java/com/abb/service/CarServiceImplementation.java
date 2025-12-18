package com.abb.service;

import com.abb.dto.CarDTO;
import com.abb.exception.CarNotFoundException;
import com.abb.model.CarModel;
import com.abb.repository.CarRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CarServiceImplementation implements CarService {
   
    private final CarRepository carRepository;
    
    public CarServiceImplementation (CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    
    @Override
    public List<CarDTO> getCars () {
        return carRepository.getCars()
                .stream()
                .map(car -> CarDTO.builder()
                        .color(car.getColor())
                        .speed(car.getSpeed())
                        .id(car.getId())
                        .build())
                .collect(Collectors.toList());
    }
    
    @Override
    public CarDTO getCarById (int id) {
        CarModel car = carRepository.getCarById(id).orElseThrow(
                () -> new CarNotFoundException("Car not found")
        );
        
        return CarDTO.builder()
                .color(car.getColor())
                .speed(car.getSpeed())
                .id(car.getId())
                .build();
    }
    
    @Override
    public void addCar (CarDTO car) {
        carRepository.saveCar(new CarModel(car.getColor(), car.getSpeed()));
    }
    
    @Override
    public void deleteCarById (int id) {
        carRepository.getCarById(id).orElseThrow(
                () -> new CarNotFoundException("Car not found")
        );
        
        carRepository.deleteCarById(id);
    }
    
    @Override
    public void updateCar (int id, CarDTO carDto) {
        carRepository.getCarById(id).orElseThrow(
                () -> new CarNotFoundException("Car not found")
        );
        
        carRepository.updateCar(id, new CarModel(carDto.getColor(), carDto.getSpeed()));
    }

    @Override
    public int count () {
        return carRepository.count();
    }

    @Override
    public void deleteAll () {
        carRepository.deleteAll();
    }
}
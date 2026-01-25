package com.abbtech.repository;

import com.abbtech.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarRepository {
    List<Car> getCars();

    Optional<Car> getCarById(String id);

    void saveCar(Car car);

    void deleteCarById(String id);

    Car updateCar(String id, Car carDto);
}

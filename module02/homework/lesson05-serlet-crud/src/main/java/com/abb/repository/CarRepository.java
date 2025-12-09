package com.abb.repository;

import com.abb.model.CarModel;

import java.util.List;
import java.util.Optional;

public interface CarRepository {
    
    List<CarModel> getCars ();
    
    Optional<CarModel> getCarById (int id);
    
    void saveCar (CarModel car);
    
    void deleteCarById (int id);
    
    void updateCar (int id, CarModel carDto);
    
    void clear ();
}

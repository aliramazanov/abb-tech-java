package com.abb.repository;

import com.abb.dto.CarDTO;
import com.abb.model.CarModel;

import java.util.List;

public interface CarRepository {
    
    List<CarDTO> getCars ();
    
    CarDTO getCarById (int id);
    
    CarModel addCar (CarModel car);
    
    void deleteCarById (int id);
    
    void updateCar (int id, CarDTO car);
    
    void deleteCar (int id);
}

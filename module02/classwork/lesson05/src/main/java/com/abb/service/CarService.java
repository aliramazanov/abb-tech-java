package com.abb.service;

import com.abb.dto.CarDTO;

import java.util.List;

public interface CarService {
    
    List<CarDTO> getCars ();
    
    CarDTO getCarById (int id);
    
    CarDTO addCar (CarDTO car);
    
    void updateCar (CarDTO car);
    
    void deleteCar (int id);
}

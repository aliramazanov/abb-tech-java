package com.abb.service;

import com.abb.dto.CarDTO;

import java.util.List;

public interface CarService {
    
    List<CarDTO> getCars ();
    
    CarDTO getCarById (int id);
    
    void addCar (CarDTO car);
    
    void deleteCarById (int id);
    
    void updateCar (int id, CarDTO carDto);

    int count ();

    void deleteAll ();
}

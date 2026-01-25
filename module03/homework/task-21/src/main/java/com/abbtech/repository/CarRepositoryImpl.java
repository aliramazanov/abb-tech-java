package com.abbtech.repository;

import com.abbtech.model.Car;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Setter
@Getter
@Repository
@RequiredArgsConstructor
public class CarRepositoryImpl implements CarRepository {

   private Map<String, Car> carList = new HashMap<>();
    
    @Override
    public List<Car> getCars() {
        return List.copyOf(carList.values());
    }

    @Override
    public Optional<Car> getCarById(String id) {
        return Optional.ofNullable(carList.get(id));
    }

    @Override
    public void saveCar(Car car) {
        carList.put(car.getId(), car);
    }

    @Override
    public void deleteCarById(String id) {
        carList.remove(id);
    }

    @Override
    public Car updateCar(String id, Car carDto) {
        carList.put(id, carDto);
        return carDto;
    }
}

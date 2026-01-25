package com.abbtech.service;

import com.abbtech.dto.ReqCarDto;
import com.abbtech.dto.RespCarDto;
import com.abbtech.exception.CarErrorEnum;
import com.abbtech.exception.CarException;
import com.abbtech.model.Car;
import com.abbtech.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<RespCarDto> getCars() {
        return carRepository.getCars()
                .stream()
                .map(mapCarToResponseCarDto())
                .toList();
    }

    private static Function<Car, RespCarDto> mapCarToResponseCarDto() {
        return car -> new RespCarDto(car.getId(), car.getName(), car.getColor());
    }

    @Override
    public RespCarDto getCarById(String id) {
        return carRepository.getCarById(id)
                .map(mapCarToResponseCarDto())
                .orElseThrow(() -> new CarException(CarErrorEnum.CAR_NOT_FOUND));
    }

    @Override
    public RespCarDto addCar(ReqCarDto car) {
        Car newCar = buildCar(car);
        carRepository.saveCar(newCar);
        return mapCarToResponseCarDto().apply(newCar);
    }
    
    @Override
    public RespCarDto updateCar(String id, ReqCarDto carDto) {
        Car existing = carRepository.getCarById(id)
                .orElseThrow(() -> new CarException(CarErrorEnum.CAR_NOT_FOUND));

        if (carDto.getName() != null) {
            existing.setName(carDto.getName());
        }
        
        if (carDto.getColor() != null) {
            existing.setColor(carDto.getColor());
        }

        Car updated = carRepository.updateCar(id, existing);
        return mapCarToResponseCarDto().apply(updated);
    }
    
    @Override
    public void deleteCarById(String id) {
        carRepository.getCarById(id)
                .orElseThrow(() -> new CarException(CarErrorEnum.CAR_NOT_FOUND));
        carRepository.deleteCarById(id);
    }

    private static Car buildCar(ReqCarDto car) {
        String carID = UUID.randomUUID().toString();
        return Car.builder()
                .id(carID)
                .name(car.getName())
                .color(car.getColor())
                .build();
    }
}

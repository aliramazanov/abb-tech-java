package com.abbtech.service.car;

import com.abbtech.dto.car.ReqCarDto;
import com.abbtech.dto.car.RespCarDto;

import java.util.List;

public interface CarService {

    List<RespCarDto> getCars();

    RespCarDto getCarById(String id);
    
    RespCarDto addCar(ReqCarDto car);

    void deleteCarById(String  id);

    RespCarDto updateCar(String id, ReqCarDto carDto);
}

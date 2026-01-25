package com.abbtech.service;

import com.abbtech.dto.ReqCarDto;
import com.abbtech.dto.RespCarDto;

import java.util.List;

public interface CarService {

    List<RespCarDto> getCars();

    RespCarDto getCarById(String id);
    
    RespCarDto addCar(ReqCarDto car);

    void deleteCarById(String  id);

    RespCarDto updateCar(String id, ReqCarDto carDto);
}

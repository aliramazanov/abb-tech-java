package com.abbtech.controller;

import com.abbtech.dto.OnCreate;
import com.abbtech.dto.OnUpdate;
import com.abbtech.dto.ReqCarDto;
import com.abbtech.dto.RespCarDto;
import com.abbtech.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RespCarDto> getCars() {
        return carService.getCars();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RespCarDto getCarById(@PathVariable String id) {
        return carService.getCarById(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RespCarDto addCar(@Validated(OnCreate.class) @RequestBody ReqCarDto reqCarDto) {
        return carService.addCar(reqCarDto);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RespCarDto updateCar(
            @PathVariable String id,
            @Validated(OnUpdate.class) @RequestBody ReqCarDto carDto
    ) {
        return carService.updateCar(id, carDto);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable String id) {
        carService.deleteCarById(id);
    }
}

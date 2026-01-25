package com.abbtech.controller;

import com.abbtech.config.AppConfig;
import com.abbtech.config.ValueConfig;
import com.abbtech.dto.groups.OnCreate;
import com.abbtech.dto.groups.OnUpdate;
import com.abbtech.dto.car.ReqCarDto;
import com.abbtech.dto.car.RespCarDto;
import com.abbtech.service.car.CarService;
import com.abbtech.service.logging.LoggingService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;
    private final LoggingService loggingService;
    private final AppConfig appConfig;
    private final ValueConfig valueConfig;

    public CarController(
            CarService carService,
            LoggingService loggingService,
            AppConfig appConfig,
            ValueConfig valueConfig
    ) {
        this.carService = carService;
        this.loggingService = loggingService;
        this.appConfig = appConfig;
        this.valueConfig = valueConfig;
    }

    @GetMapping
    public List<RespCarDto> getCars() {
        loggingService.log("GET /cars");
        return carService.getCars();
    }

    @GetMapping("/{id}")
    public RespCarDto getCarById(@PathVariable String id) {
        loggingService.log("GET /cars/{}", id);
        return carService.getCarById(id);
    }
    
    @GetMapping("/validate/{id}")
    public RespCarDto validateAndGetCar(@PathVariable String id) {
        if (id.length() < 3) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID must be 3+ characters");
        }
        return carService.getCarById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RespCarDto addCar(@Validated(OnCreate.class) @RequestBody ReqCarDto reqCarDto) {
        loggingService.log("POST /cars - {}", reqCarDto);
        return carService.addCar(reqCarDto);
    }

    @PutMapping("/{id}")
    public RespCarDto updateCar(
            @PathVariable String id,
            @Validated(OnUpdate.class) @RequestBody ReqCarDto carDto
    ) {
        loggingService.log("PUT /cars/{}", id);
        return carService.updateCar(id, carDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable String id) {
        loggingService.log("DELETE /cars/{}", id);
        carService.deleteCarById(id);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalArgument(IllegalArgumentException ex) {
        return "Controller error: " + ex.getMessage();
    }

    @GetMapping("/config")
    public String getConfig() {
        return "App Config: env=" +
               appConfig.getEnv() +
               " " + "\n" +
               "Value Config: env=" +
               valueConfig.getEnv() +
               ", port=" + valueConfig.getPort();
    }
}

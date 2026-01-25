package com.abbtech;

import com.abbtech.dto.car.ReqCarDto;
import com.abbtech.dto.car.RespCarDto;
import com.abbtech.exception.car.CarException;
import com.abbtech.model.Car;
import com.abbtech.repository.CarRepository;
import com.abbtech.service.car.CarServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {

    private CarServiceImpl carService;
    private FakeCarRepository fakeRepository;

    @BeforeEach
    void setUp() {
        fakeRepository = new FakeCarRepository();
        carService = new CarServiceImpl(fakeRepository);
    }

    @Test
    void getCars_shouldReturnAllCars() {
        fakeRepository.saveCar(Car.builder().id("1").name("BMW").color("Black").build());
        fakeRepository.saveCar(Car.builder().id("2").name("Audi").color("White").build());

        List<RespCarDto> cars = carService.getCars();

        assertEquals(2, cars.size());
    }

    @Test
    void getCarById_exists_shouldReturnCar() {
        fakeRepository.saveCar(Car.builder().id("1").name("BMW").color("Black").build());

        RespCarDto car = carService.getCarById("1");

        assertEquals("BMW", car.getName());
        assertEquals("Black", car.getColor());
    }

    @Test
    void getCarById_notExists_shouldThrowException() {
        assertThrows(CarException.class, () -> carService.getCarById("nonexistent"));
    }

    @Test
    void addCar_shouldCreateCar() {
        ReqCarDto req = new ReqCarDto();
        req.setName("Tesla");
        req.setColor("Red");

        RespCarDto car = carService.addCar(req);

        assertNotNull(car.getId());
        assertEquals("Tesla", car.getName());
        assertEquals("Red", car.getColor());
    }

    @Test
    void updateCar_shouldUpdateFields() {
        fakeRepository.saveCar(Car.builder().id("1").name("BMW").color("Black").build());

        ReqCarDto req = new ReqCarDto();
        req.setColor("White");

        RespCarDto updated = carService.updateCar("1", req);

        assertEquals("BMW", updated.getName());
        assertEquals("White", updated.getColor());
    }

    @Test
    void deleteCar_exists_shouldDelete() {
        fakeRepository.saveCar(Car.builder().id("1").name("BMW").color("Black").build());

        carService.deleteCarById("1");

        assertTrue(fakeRepository.getCars().isEmpty());
    }

    @Test
    void deleteCar_notExists_shouldThrowException() {
        assertThrows(CarException.class, () -> carService.deleteCarById("nonexistent"));
    }

    static class FakeCarRepository implements CarRepository {
        private final java.util.Map<String, Car> cars = new java.util.HashMap<>();

        @Override
        public List<Car> getCars() {
            return new java.util.ArrayList<>(cars.values());
        }

        @Override
        public Optional<Car> getCarById(String id) {
            return Optional.ofNullable(cars.get(id));
        }

        @Override
        public void saveCar(Car car) {
            cars.put(car.getId(), car);
        }

        @Override
        public void deleteCarById(String id) {
            cars.remove(id);
        }

        @Override
        public Car updateCar(String id, Car car) {
            cars.put(id, car);
            return car;
        }
    }
}

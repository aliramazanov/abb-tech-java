package abb.repository;

import com.abb.model.CarModel;
import com.abb.repository.CarRepository;
import com.abb.repository.CarRepositoryImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryTest {
    
    private CarRepository repository;
    
    @BeforeEach
    void setUp () {
        repository = new CarRepositoryImplementation();
        repository.clear();
    }
    
    @Test
    void testSaveCar_SetIdAndDbCode () {
        CarModel car = new CarModel("Green", 120);
        
        repository.saveCar(car);
        
        assertEquals(1, car.getId());
        assertEquals("Car1", car.getDbCode());
    }
    
    @Test
    void testSaveCar_IncrementsIds () {
        CarModel car1 = new CarModel("Blue", 120);
        CarModel car2 = new CarModel("Black", 150);
        
        repository.saveCar(car1);
        repository.saveCar(car2);
        
        assertEquals(1, car1.getId());
        assertEquals(2, car2.getId());
    }
    
    @Test
    void testGetCars_ReturnsAllCars () {
        CarModel car1 = new CarModel("Red", 120);
        CarModel car2 = new CarModel("Blue", 150);

        repository.saveCar(car1);
        repository.saveCar(car2);

        List<CarModel> result = repository.getCars();

        assertEquals(2, result.size());
    }

    @Test
    void testGetCars_EmptyList () {
        List<CarModel> result = repository.getCars();

        assertTrue(result.isEmpty());
    }

    @Test
    void testGetCarById_Found () {
        CarModel car = new CarModel("Red", 120);
        
        repository.saveCar(car);
        
        Optional<CarModel> result = repository.getCarById(1);
        
        assertTrue(result.isPresent());
        assertEquals("Red", result.get().getColor());
    }
    
    @Test
    void testGetCarById_NotFound () {
        Optional<CarModel> result = repository.getCarById(999);
        
        assertFalse(result.isPresent());
    }
    
    @Test
    void testDeleteCarById_Success () {
        CarModel car = new CarModel("Red", 120);
       
        repository.saveCar(car);
        
        repository.deleteCarById(1);
        
        assertEquals(0, repository.getCars().size());
    }
    
    @Test
    void testUpdateCar_UpdatesColorAndSpeed () {
        CarModel car = new CarModel("Red", 120);
        repository.saveCar(car);
        
        CarModel updates = new CarModel("Blue", 180);
        repository.updateCar(1, updates);
        
        Optional<CarModel> updatedOpt = repository.getCarById(1);
        
        assertTrue(updatedOpt.isPresent());
        
        CarModel updated = updatedOpt.get();
        
        assertEquals("Blue", updated.getColor());
        assertEquals(180, updated.getSpeed());
    }

    @Test
    void testCount_ReturnsCorrectNumber () {
        repository.saveCar(new CarModel("Red", 120));
        repository.saveCar(new CarModel("Blue", 150));

        assertEquals(2, repository.count());
    }

    @Test
    void testCount_ReturnsZeroWhenEmpty () {
        assertEquals(0, repository.count());
    }

    @Test
    void testDeleteAll_RemovesAllCars () {
        repository.saveCar(new CarModel("Red", 120));
        repository.saveCar(new CarModel("Blue", 150));

        repository.deleteAll();

        assertEquals(0, repository.count());
    }
}
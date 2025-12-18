package abb.service;

import com.abb.dto.CarDTO;
import com.abb.exception.CarNotFoundException;
import com.abb.model.CarModel;
import com.abb.repository.CarRepository;
import com.abb.service.CarService;
import com.abb.service.CarServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {
    
    private CarService service;
    
    @Mock
    private CarRepository repository;
    
    @BeforeEach
    void setUp () {
        service = new CarServiceImplementation(repository);
    }
    
    @Test
    void testGetCars_ReturnsList () {
        
        CarModel car1 = new CarModel("Red", 120);
        car1.setId(1);
        
        CarModel car2 = new CarModel("Blue", 150);
        car2.setId(2);
        
        when(repository.getCars()).thenReturn(Arrays.asList(car1, car2));
        
        List<CarDTO> result = service.getCars();
        
        assertEquals(2, result.size());
        assertEquals("Red", result.getFirst().getColor());
        assertEquals(1, result.getFirst().getId());
    }
    
    @Test
    void testGetCarById_Found () {
        
        CarModel car = new CarModel("Red", 120);
        
        car.setId(1);
        
        when(repository.getCarById(1)).thenReturn(Optional.of(car));
        
        CarDTO result = service.getCarById(1);
        
        assertEquals("Red", result.getColor());
        assertEquals(120, result.getSpeed());
        assertEquals(1, result.getId());
    }
    
    @Test
    void testGetCarById_NotFound () {
        when(repository.getCarById(999)).thenReturn(Optional.empty());
        
        assertThrows(CarNotFoundException.class, () -> service.getCarById(999));
    }
    
    @Test
    void testAddCar_UseRepository () {
        CarDTO dto = new CarDTO("Red", 120);
        
        service.addCar(dto);
        
        verify(repository).saveCar(any(CarModel.class));
    }
    
    @Test
    void testDeleteCarById_Found () {
        CarModel car = new CarModel("Red", 120);
        car.setId(1);
        
        when(repository.getCarById(1)).thenReturn(Optional.of(car));
        
        service.deleteCarById(1);
        
        verify(repository).deleteCarById(1);
    }
    
    @Test
    void testDeleteCarById_NotFound () {
        when(repository.getCarById(999)).thenReturn(Optional.empty());
        
        assertThrows(CarNotFoundException.class, () -> service.deleteCarById(999));
        verify(repository, never()).deleteCarById(999);
    }
    
    @Test
    void testUpdateCar_Found () {
        CarModel car = new CarModel("Red", 120);
        car.setId(1);
        
        when(repository.getCarById(1)).thenReturn(Optional.of(car));
        
        CarDTO dto = new CarDTO("Blue", 180);
        
        service.updateCar(1, dto);
        
        verify(repository).updateCar(eq(1), any(CarModel.class));
    }
    
    @Test
    void testUpdateCar_NotFound () {
        when(repository.getCarById(999)).thenReturn(Optional.empty());
        CarDTO dto = new CarDTO("Blue", 180);
        
        assertThrows(CarNotFoundException.class, () -> service.updateCar(999, dto));
        verify(repository, never()).updateCar(anyInt(), any(CarModel.class));
    }

    @Test
    void testCount_ReturnsRepositoryCount () {
        when(repository.count()).thenReturn(5);

        int result = service.count();

        assertEquals(5, result);
        verify(repository).count();
    }

    @Test
    void testDeleteAll_CallsRepository () {
        service.deleteAll();

        verify(repository).deleteAll();
    }
}
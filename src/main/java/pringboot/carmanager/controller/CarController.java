package pringboot.carmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pringboot.carmanager.CarSegment;
import pringboot.carmanager.Car;
import pringboot.carmanager.CarService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/segment/{segment}")
    public List<Car> getCarsBySegment(@PathVariable("segment") CarSegment segment) {
        return carService.getCarsForSegment(segment);
    }

    @GetMapping("/cars")
    public List<Car> getAllCars(){
        return new ArrayList<>(carService.getAllCars());
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCarId(@PathVariable int id){
        return ResponseEntity.ok(carService.getCarByIdFromDB(id));
    }
    @PostMapping("/cars")
    public void addCar(Car car){
        carService.addCar(car);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Car> deleteBook(@PathVariable int id){
        carService.deleteCar(id);
        return ResponseEntity.ok().build();
    }


}

package pringboot.carmanager;

import org.springframework.stereotype.Component;
import pringboot.carmanager.data.CarDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Component
public class CarService {

    private final CarDatabase carDatabase;

    public CarService(CarDatabase carDatabase) {
        this.carDatabase = carDatabase;
    }

    public List<Car> getCarsForSegment(CarSegment carSegment) {
        return carDatabase.getAllCars().stream()
                .filter(car -> car.getCarSegment().equals(carSegment))
                .collect(Collectors.toList());
    }

    public List<Car> getAllCars(){
        return new ArrayList<>(carDatabase.getAllCars());
    }

    public Car getCarByIdFromDB(int id){
        return carDatabase.getAllCars().stream().filter(car -> car.getId()==id).findFirst().orElseThrow(()->new NoSuchElementException("No book with id:"+id));
    }

    public void addCar(Car car){
        carDatabase.addCar(car);
    }

    public void deleteCar(int id){
        carDatabase.delete(carDatabase.getCarById(id).getId());
    }

}

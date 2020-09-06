package pringboot.carmanager.data;

import pringboot.carmanager.Car;

import java.util.Collection;

public interface CarDatabase {
    Collection<Car> getAllCars();
    Car getCarById(int id);
    void addCar(Car car);
    void delete(int id);

}

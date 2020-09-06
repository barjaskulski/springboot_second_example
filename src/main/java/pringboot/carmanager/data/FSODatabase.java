package pringboot.carmanager.data;

import org.springframework.stereotype.Component;
import pringboot.carmanager.CarSegment;
import pringboot.carmanager.Car;

import java.util.*;

@Component
public class FSODatabase implements CarDatabase {
    List<Car> carInformation = new ArrayList<>();

    public FSODatabase() {
        carInformation.add(new Car(5,"Polonez Caro", CarSegment.C, "5-drzwiowy hatchback", 1967, "1.4 l", 86));
        carInformation.add(new Car(6,"Fiat 125p", CarSegment.D, "Samochód osobowy klasy średniej", 1976, "1.5 l", 60));
        carInformation.add(new Car(7,"Fiat 126", CarSegment.A, "Małe autko", 1973, "0.6 l", 23));
    }

    public Collection<Car> getAllCars() {
        System.out.println("Getting all cars");
        return carInformation;
    }

    @Override
    public Car getCarById(int id) {
        System.out.println("Getting car by id");
        return carInformation.stream().filter(car -> car.getId()==id).findFirst().orElseThrow(()->new NoSuchElementException("No car with id:"+id));
    }

    @Override
    public void addCar(Car car) {
        carInformation.add(car);
    }

    @Override
    public void delete(int id) {
        Car carFound = getCarById(id);
        carInformation.remove(carFound);
    }
}

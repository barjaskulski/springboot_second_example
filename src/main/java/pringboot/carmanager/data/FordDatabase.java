package pringboot.carmanager.data;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pringboot.carmanager.CarSegment;
import pringboot.carmanager.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

@Primary
@Component
public class FordDatabase implements CarDatabase {
    List<Car> carInformation = new ArrayList<>();

    public FordDatabase() {
        carInformation.add(new Car(1,"Ford Focus", CarSegment.C, "Ford's Compact car based on global C-car platform", 1998, "1.5 l", 134));
        carInformation.add(new Car(2,"Ford Fiesta", CarSegment.B, "Ford's long running subcompact line based on global B-car Platform", 1976, "1.5 l", 200));
        carInformation.add(new Car(3,"Ford Transit", CarSegment.B, "Leisure activity vehicle", 2014, "1.6 l", 100));
        carInformation.add(new Car(4,"Ford Mondeo", CarSegment.D, "Mid sized passenger sedan with \"One-Ford\" design based on CD4 platform.", 1998, "2 l", 203));
    }

    public Collection<Car> getAllCars() {
        System.out.println("Getting all cars");
        return carInformation;
    }

    @Override
    public Car getCarById(int id) {
        System.out.println("Getting car by ide");
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

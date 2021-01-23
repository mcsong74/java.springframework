package com.cybertek;

import com.cybertek.entity.Car;
import com.cybertek.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ComApplication {
    @Autowired //inject CarRepository
    CarRepository carRepository;

    public static void main(String[] args) {
        SpringApplication.run(ComApplication.class, args);
    }

    @PostConstruct //always pre-execute before operations when it run
    public void dataInit() {
        Car c1 = new Car(2010, "BMW", "M5");
        Car c2 = new Car(2020, "Mercedes Benz", "SLK");
        Car c3 = new Car(2019, "Hyundai", "Sonata");
        Car c4 = new Car(2018, "Toyota", "RAV4");
        carRepository.save(c1);
        carRepository.save(c2);
        carRepository.save(c3);
        carRepository.save(c4);

        List<Car> cars = new ArrayList<>();
        cars.add(new Car(2017, "Hyundai", "Genesis"));
        cars.add(new Car(2019, "Hyundai", "Genesis"));
        cars.add(new Car(2020, "Kia", "Sportage"));
        cars.add(new Car(2019, "Ford", "Mustang"));
        carRepository.saveAll(cars);

    }

}

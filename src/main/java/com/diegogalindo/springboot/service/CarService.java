package com.diegogalindo.springboot.service;

import com.diegogalindo.springboot.domain.Car;
import com.diegogalindo.springboot.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAll(){
        return carRepository.findAll();
    }

    public Car save(Car car){
        return carRepository.save(car);
    }
}

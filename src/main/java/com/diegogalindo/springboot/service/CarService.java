package com.diegogalindo.springboot.service;

import com.diegogalindo.springboot.domain.Car;
import com.diegogalindo.springboot.dto.CarDTO;
import com.diegogalindo.springboot.map.CarMapper;
import com.diegogalindo.springboot.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Car save(CarDTO carDTO){
        carDTO.setId(null);
        return carRepository.save(CarMapper.INSTANCE.toCar(carDTO));
    }

    public Car findById(Long id){
        return carRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    public Car update(CarDTO carDTO){
        findById(CarMapper.INSTANCE.toCar(carDTO).getId());
        return carRepository.save(CarMapper.INSTANCE.toCar(carDTO));
    }
}

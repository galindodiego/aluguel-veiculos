package com.diegogalindo.springboot.controller;

import com.diegogalindo.springboot.domain.Car;
import com.diegogalindo.springboot.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public ResponseEntity<List<Car>> findAll(){
        return new ResponseEntity<>(carService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Car> save(@RequestBody Car car){
        return new ResponseEntity<>(carService.save(car),HttpStatus.CREATED);
    }
}

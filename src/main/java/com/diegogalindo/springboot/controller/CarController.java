package com.diegogalindo.springboot.controller;

import com.diegogalindo.springboot.domain.Car;
import com.diegogalindo.springboot.dto.CarDTO;
import com.diegogalindo.springboot.dto.CarDTOPatchBody;
import com.diegogalindo.springboot.dto.CarDTOPostBody;
import com.diegogalindo.springboot.dto.CarDTOPutBody;
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
    public ResponseEntity<Car> save(@RequestBody CarDTOPostBody carDTOPostBody){
        return new ResponseEntity<>(carService.save(carDTOPostBody),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> findById(@PathVariable Long id){
        return new ResponseEntity<>(carService.findById(id),HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Car> update(@RequestBody CarDTOPutBody carDTOPutBody){
        return new ResponseEntity<>(carService.update(carDTOPutBody),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        carService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Car> updatePartially(@PathVariable Long id,
                                               @RequestBody CarDTOPatchBody carDTOPatchBody){
        return new ResponseEntity<>(carService.updatePartially(id,carDTOPatchBody),HttpStatus.OK);

    }
}

package com.diegogalindo.springboot.service;

import com.diegogalindo.springboot.domain.Car;
import com.diegogalindo.springboot.dto.CarDTOPatchBody;
import com.diegogalindo.springboot.dto.CarDTOPostBody;
import com.diegogalindo.springboot.dto.CarDTOPutBody;
import com.diegogalindo.springboot.map.CarPatchMapper;
import com.diegogalindo.springboot.map.CarPostMapper;
import com.diegogalindo.springboot.map.CarPutMapper;
import com.diegogalindo.springboot.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Field;
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

    public Car save(CarDTOPostBody carDTOPostBody){
        return carRepository.save(CarPostMapper.INSTANCE.toCar(carDTOPostBody));
    }

    public Car findById(Long id){
        return carRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    public Car update(CarDTOPutBody carDTOPutBody){
        Car car = findById(carDTOPutBody.getId());

        if(!car.getReplaceable()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"This car with id "+ car.getId()+" is not replaceable");
        }

        Car newCar= CarPutMapper.INSTANCE.toCar(carDTOPutBody);
        newCar.setReplaceable(car.getReplaceable());

        return carRepository.save(newCar);
    }
    public void delete(Long id){
        carRepository.delete(findById(id));
    }

    public Car updatePartially(Long id, CarDTOPatchBody carDTOPatchBody){

        Car car= findById(id);
        Car newCar= CarPatchMapper.INSTANCE.toCar(carDTOPatchBody);


        for (Field field : Car.class.getDeclaredFields()) {
            field.setAccessible(true);

            try {
                if(field.get(newCar)!= null && !field.get(newCar).equals(field.get(car))){
                    field.set(car, field.get(newCar));
                }
             } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }


        long start = System.nanoTime();
        if(newCar.getModel() != null && !newCar.getModel().equals(car.getModel())) car.setModel(newCar.getModel());
        if(newCar.getColor() != null && !newCar.getColor().equals(car.getColor())) car.setColor(newCar.getColor());
        if(newCar.getYear() != null && !newCar.getYear().equals(car.getYear())) car.setYear(newCar.getYear());
        if(newCar.getReplaceable() != null && !newCar.getReplaceable().equals(car.getReplaceable())) car.setReplaceable(newCar.getReplaceable());
        if(newCar.getAvailable() != null && !newCar.getAvailable().equals(car.getAvailable())) car.setAvailable(newCar.getAvailable());

        long end = System.nanoTime();
        System.out.println(end - start);

        return carRepository.save(car);

    }
}

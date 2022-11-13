package com.diegogalindo.springboot.map;

import com.diegogalindo.springboot.domain.Car;
import com.diegogalindo.springboot.dto.CarDTO;
import com.diegogalindo.springboot.dto.CarDTOPutBody;

public enum CarPutMapper {
    INSTANCE;

    public Car toCar(CarDTOPutBody carDTOPutBody) {
        if (carDTOPutBody == null) return null;
        Car car = new Car();


        car.setId(carDTOPutBody.getId());

        car.setModel(carDTOPutBody.getModel());
        car.setColor(carDTOPutBody.getColor());
        car.setYear(carDTOPutBody.getYear());
        return car;
    }
}

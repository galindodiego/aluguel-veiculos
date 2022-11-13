package com.diegogalindo.springboot.map;

import com.diegogalindo.springboot.domain.Car;
import com.diegogalindo.springboot.dto.CarDTOPostBody;
import com.diegogalindo.springboot.dto.CarDTOPutBody;

public enum CarPostMapper {
    INSTANCE;

    public Car toCar(CarDTOPostBody carDTOPostBody) {
        if (carDTOPostBody == null) return null;
        Car car = new Car();

        car.setModel(carDTOPostBody.getModel());
        car.setColor(carDTOPostBody.getColor());
        car.setYear(carDTOPostBody.getYear());
        car.setReplaceable(carDTOPostBody.getReplaceable());
        return car;
    }
}

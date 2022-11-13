package com.diegogalindo.springboot.map;

import com.diegogalindo.springboot.domain.Car;
import com.diegogalindo.springboot.dto.CarDTOPatchBody;
import com.diegogalindo.springboot.dto.CarDTOPostBody;

public enum CarPatchMapper {
    INSTANCE;

    public Car toCar(CarDTOPatchBody carDTOPatchBody) {
        if (carDTOPatchBody == null) return null;
        Car car = new Car();

        car.setModel(carDTOPatchBody.getModel());
        car.setColor(carDTOPatchBody.getColor());
        car.setYear(carDTOPatchBody.getYear());
        car.setReplaceable(carDTOPatchBody.getReplaceable());
        car.setAvailable(carDTOPatchBody.getAvailable());
        return car;
    }
}

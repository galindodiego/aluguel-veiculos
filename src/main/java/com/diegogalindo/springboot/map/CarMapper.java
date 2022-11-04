package com.diegogalindo.springboot.map;

import com.diegogalindo.springboot.domain.Car;
import com.diegogalindo.springboot.dto.CarDTO;

public enum CarMapper {
    INSTANCE;

    public Car toCar(CarDTO carDTO) {
        if (carDTO == null) return null;
        Car car = new Car();
        car.setId(carDTO.getId());
        car.setModel(carDTO.getModel());
        car.setColor(carDTO.getColor());
        car.setYear(carDTO.getYear());
        return car;
    }
}

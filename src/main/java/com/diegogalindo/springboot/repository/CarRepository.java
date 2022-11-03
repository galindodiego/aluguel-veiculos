package com.diegogalindo.springboot.repository;

import com.diegogalindo.springboot.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {

}

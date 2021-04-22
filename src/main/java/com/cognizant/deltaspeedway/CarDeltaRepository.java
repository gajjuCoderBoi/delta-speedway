package com.cognizant.deltaspeedway;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CarDeltaRepository extends JpaRepository<CarDeltaEntity,Long> {

    CarDeltaEntity findByName(String name);
}

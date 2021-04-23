package com.cognizant.deltaspeedway.repository;

import com.cognizant.deltaspeedway.entity.CarDeltaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDeltaRepository extends JpaRepository<CarDeltaEntity,Long> {

  //  CarDeltaEntity findByName(String name);
}

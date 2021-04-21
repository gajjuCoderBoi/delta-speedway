package com.cognizant.deltaspeedway;

import org.springframework.data.jpa.repository.JpaRepository;


public interface DriverDeltaRepository extends JpaRepository<DriverDeltaEntity,Long> {

    DriverDeltaEntity findByName(String name);
}

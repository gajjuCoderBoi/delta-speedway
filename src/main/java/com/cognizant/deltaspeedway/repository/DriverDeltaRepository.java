package com.cognizant.deltaspeedway.repository;

import com.cognizant.deltaspeedway.entity.DriverDeltaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverDeltaRepository extends JpaRepository<DriverDeltaEntity,Long> {

    DriverDeltaEntity findByNickname(String nickname);
}

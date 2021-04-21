package com.cognizant.deltaspeedway.repository;

import com.cognizant.deltaspeedway.entity.RacecarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceCarRepository extends JpaRepository<RacecarEntity, Long> {
}

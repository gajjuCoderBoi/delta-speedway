package com.cognizant.deltaspeedway.repository;

import com.cognizant.deltaspeedway.entity.RaceOutcomesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceOutcomesRepository extends JpaRepository<RaceOutcomesEntity, Long> {
}

package com.cognizant.deltaspeedway.repository;

import com.cognizant.deltaspeedway.entity.RaceStatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceStatsRepository extends JpaRepository<RaceStatsEntity, Long> {
}

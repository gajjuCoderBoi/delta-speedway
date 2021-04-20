package com.cognizant.deltaspeedway.service;

import com.cognizant.deltaspeedway.entity.RacecarEntity;
import com.cognizant.deltaspeedway.repository.RaceCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceCarService {
    @Autowired
    private RaceCarRepository raceCarRepository;

    public List<RacecarEntity> getAllRaceCar(){
        return raceCarRepository.findAll();
    }
}

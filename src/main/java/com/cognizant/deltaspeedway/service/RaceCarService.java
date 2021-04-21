package com.cognizant.deltaspeedway.service;

import com.cognizant.deltaspeedway.entity.RacecarEntity;
import com.cognizant.deltaspeedway.repository.RaceCarRepository;
import com.cognizant.deltaspeedway.request.CarRequest;
import com.cognizant.deltaspeedway.response.CarResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceCarService {
    @Autowired
    private RaceCarRepository raceCarRepository;

    public List<RacecarEntity> getAllRaceCar(){
        return raceCarRepository.findAll();
    }

    public CarResponse createCar(CarRequest carRequest) {
        RacecarEntity savedRaceCarEntity = RacecarEntity.builder()
                .model(carRequest.getModel())
                .make(carRequest.getMake())
                .build();

        raceCarRepository.save(savedRaceCarEntity);

        return CarResponse.builder()
                .message("Car has been created.")
                .status(HttpStatus.CREATED)
                .build();
    }

    public RacecarEntity getCarById(Long carId) {
        return raceCarRepository.findById(carId).orElse(null);
    }

}

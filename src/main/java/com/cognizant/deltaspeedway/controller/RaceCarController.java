package com.cognizant.deltaspeedway.controller;

import com.cognizant.deltaspeedway.request.CarRequest;
import com.cognizant.deltaspeedway.response.CarResponse;
import com.cognizant.deltaspeedway.service.RaceCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/racecar")
public class RaceCarController {

    @Autowired
    private RaceCarService raceCarService;

    @GetMapping
    public ResponseEntity<?> getAllRaceCar(){
        return new ResponseEntity<>(raceCarService.getAllRaceCar(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createCar(@RequestBody CarRequest carRequest){
        CarResponse response = raceCarService.createCar(carRequest);
        return new ResponseEntity<>(response, response.getStatus());
    }
}

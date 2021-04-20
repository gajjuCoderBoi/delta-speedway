package com.cognizant.deltaspeedway.controller;

import com.cognizant.deltaspeedway.service.RaceCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/racecar")
public class RaceCarController {

    @Autowired
    private RaceCarService raceCarService;

    @GetMapping
    public ResponseEntity<?> getAllRaceCar(){
        return new ResponseEntity<>(raceCarService.getAllRaceCar(), HttpStatus.OK);
    }
}

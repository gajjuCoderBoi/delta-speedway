package com.cognizant.deltaspeedway.controller;

import com.cognizant.deltaspeedway.request.RaceRequest;
import com.cognizant.deltaspeedway.service.RaceStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/races")
public class RaceStatsController {

    @Autowired
    RaceStatsService raceStatsService;

    @PostMapping
    public ResponseEntity createRace(@RequestBody RaceRequest raceRequest) {
        RaceRequest createdRace = raceStatsService.createRace(raceRequest);
        return new ResponseEntity<>(createdRace, HttpStatus.CREATED);
    }
}


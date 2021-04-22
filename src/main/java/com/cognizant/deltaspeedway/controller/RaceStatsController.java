package com.cognizant.deltaspeedway.controller;

import com.cognizant.deltaspeedway.DTO.RaceDto;
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
    public ResponseEntity<?> createRace(@RequestBody RaceDto raceDto) {
        RaceDto createdRace = raceStatsService.createRace(raceDto);
        return new ResponseEntity<>(createdRace, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllRaceDetails() {
        return new ResponseEntity<>(raceStatsService.getAllRaceDetails(), HttpStatus.OK);
    }
}


package com.cognizant.deltaspeedway.controller;

import com.cognizant.deltaspeedway.request.RaceRequest;
import com.cognizant.deltaspeedway.request.RaceStatsRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/races")
public class RaceStatsController {

    @PostMapping
    public ResponseEntity createRace(@RequestBody RaceRequest raceRequest) {
        return new ResponseEntity<>(raceRequest, HttpStatus.CREATED);
    }
}

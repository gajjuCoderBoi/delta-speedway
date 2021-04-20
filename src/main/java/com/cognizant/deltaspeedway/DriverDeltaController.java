package com.cognizant.deltaspeedway;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DriverDeltaController {
    @Autowired
    DriverDeltaService driverDeltaService;

    @GetMapping("/drivers/{drivername}")
    public Object getDriverDetails(@PathVariable String drivername){
        //return "[]";
        return driverDeltaService.getDriverDetails(drivername);
    }

    @PostMapping("/drivers")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDriver(@RequestBody DriverDeltaDto driverDeltaDto) throws Exception{
        driverDeltaService.saveDriver(driverDeltaDto);
    }

}

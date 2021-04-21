package com.cognizant.deltaspeedway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverDeltaService {
    @Autowired
    DriverDeltaRepository driverDeltaRepository;

    public Object getDriverDetails(String name){
        DriverDeltaEntity response = driverDeltaRepository.findByName(name);

            return  new DriverDeltaDto(response.getName())   ;
        }



    public void saveDriver(DriverDeltaDto driverDeltaDto) {
        driverDeltaRepository.save(new DriverDeltaEntity(driverDeltaDto.getName()));
    }
}



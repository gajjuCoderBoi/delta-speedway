package com.cognizant.deltaspeedway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverDeltaService {
    @Autowired
    DriverDeltaRepository driverDeltaRepository;

    public Object getDriverDetails(String name){
        DriverDeltaEntity response = driverDeltaRepository.findByName(name);

            return  new DriverDeltaDto(response.getLastName())   ;
        }



    public void saveDriver(DriverDeltaDto driverDeltaDto) {
        driverDeltaRepository.save(new DriverDeltaEntity(driverDeltaDto.getFirstName()));
    }
}



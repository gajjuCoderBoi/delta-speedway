package com.cognizant.deltaspeedway.service;

import com.cognizant.deltaspeedway.CarsDto;
import com.cognizant.deltaspeedway.DriverDeltaDto;
import com.cognizant.deltaspeedway.entity.CarDeltaEntity;
import com.cognizant.deltaspeedway.entity.DriverDeltaEntity;
import com.cognizant.deltaspeedway.repository.DriverDeltaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class DriverDeltaService {
    @Autowired
    DriverDeltaRepository driverDeltaRepository;

    public Object getDriverDetails(String name){
        DriverDeltaEntity driverDeltaEntity=driverDeltaRepository.findAll().stream().filter(x->x.getNickname().equals(name)).findAny().get();
        DriverDeltaEntity response = driverDeltaRepository.findById(driverDeltaEntity.getId()).get();
        Set<CarsDto> carsDto=  new LinkedHashSet<>();
        for(CarDeltaEntity carDeltaEntity:response.getCars())
            carsDto.add(new CarsDto(carDeltaEntity.getNickname()));
        //response.getCars().stream().iterate(x->carsDto.add(new CarsDto(x.getNickname())));
            return  new DriverDeltaDto(response.getFirstName(),  response.getLastName(), response.getAge(), response.getNickname() ,  response.getWins(),response.getLosses(),carsDto)   ;
        }



    public void saveDriver(DriverDeltaDto driverDeltaDto) {
        Set<CarDeltaEntity> carDeltaEntities=new LinkedHashSet<>();
        for(CarsDto carDto:driverDeltaDto.getCars())
            carDeltaEntities.add(new CarDeltaEntity(carDto.getNickname(),carDto.getModel(),carDto.getYear(),carDto.getOwner(),carDto.getStatus(),carDto.getTop_speed()));
        driverDeltaRepository.save(new DriverDeltaEntity(driverDeltaDto.getFirstName(),driverDeltaDto.getLastName(),driverDeltaDto.getAge(),driverDeltaDto.getNickname(),driverDeltaDto.getWins(),driverDeltaDto.getLosses(), carDeltaEntities));
    }
}



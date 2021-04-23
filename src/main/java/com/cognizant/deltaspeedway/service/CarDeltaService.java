package com.cognizant.deltaspeedway.service;

import com.cognizant.deltaspeedway.CarsDto;
import com.cognizant.deltaspeedway.entity.CarDeltaEntity;
import com.cognizant.deltaspeedway.repository.CarDeltaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarDeltaService {
    @Autowired
    CarDeltaRepository carDeltaRepository;

//    public Object getCarDetails(String name){
//        CarDeltaEntity response = carDeltaRepository.findByName(name);
//            return  new CarsDto(response.getNickname())   ;
//        }


    public CarDeltaService(CarDeltaRepository carDeltaRepository) {
        this.carDeltaRepository = carDeltaRepository;
    }

    public void saveDriver(CarsDto carsDto) {
        carDeltaRepository.save(new CarDeltaEntity(carsDto.getNickname(),carsDto.getModel(),carsDto.getYear(),carsDto.getOwner(),carsDto.getStatus(),carsDto.getTop_speed()));
    }
}



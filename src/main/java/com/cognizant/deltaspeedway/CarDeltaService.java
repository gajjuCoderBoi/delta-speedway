package com.cognizant.deltaspeedway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarDeltaService {
    @Autowired
    CarDeltaRepository carDeltaRepository;

    public Object getCarDetails(String name){
        CarDeltaEntity response = carDeltaRepository.findByName(name);
            return  new CarsDto(response.getNickname())   ;
        }



    public void saveDriver(CarsDto carsDto) {
        carDeltaRepository.save(new CarDeltaEntity(carsDto.getNickname()));
    }
}



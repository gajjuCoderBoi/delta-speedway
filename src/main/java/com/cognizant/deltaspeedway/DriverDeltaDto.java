package com.cognizant.deltaspeedway;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.deltaspeedway.CarsDto;

@Data
@NoArgsConstructor
public class DriverDeltaDto {
    String firstName;
    String lastName;
    String age;
    String nickname;
    int wins;
    int losses;
    List<CarsDto> cars= new ArrayList<>();
    

    public DriverDeltaDto(String firstName, String lastName, String age, String nickname,  int wins, int losses,List<CarsDto> cars) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
        this.nickname=nickname;
        this.wins=wins;
        this.losses=losses;
        this.cars=cars;


    }

    public DriverDeltaDto(String lastName) {
    }
}

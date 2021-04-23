package com.cognizant.deltaspeedway;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cognizant.deltaspeedway.CarsDto;

@Data
@NoArgsConstructor
@Builder
public class DriverDeltaDto {
    String firstName;
    String lastName;
    String age;
    String nickname;
    int wins;
    int losses;
    Set<CarsDto> cars;
    

    public DriverDeltaDto(String firstName, String lastName, String age, String nickname,  int wins, int losses,Set<CarsDto> cars) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
        this.nickname=nickname;
        this.wins=wins;
        this.losses=losses;
        this.cars=cars;


    }

    public DriverDeltaDto(String nickname) {
        this.nickname=nickname;
    }
}

package com.cognizant.deltaspeedway;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarsDto {
     String nickname;
     String model;
     String year;
     String owner;
     String status;
     int top_speed;

     public CarsDto(String nickname) {
     }
}

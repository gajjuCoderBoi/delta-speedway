package com.cognizant.deltaspeedway;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
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

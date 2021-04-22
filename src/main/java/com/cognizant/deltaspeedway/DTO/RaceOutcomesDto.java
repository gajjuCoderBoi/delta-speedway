package com.cognizant.deltaspeedway.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RaceOutcomesDto {
    private String firstPositionName;
    private String secondPositionName;
    private String thirdPositionName;
}

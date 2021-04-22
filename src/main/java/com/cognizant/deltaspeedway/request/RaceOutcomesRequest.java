package com.cognizant.deltaspeedway.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RaceOutcomesRequest {
    private String firstPositionName;
    private String secondPositionName;
    private String thirdPositionName;
}

package com.cognizant.deltaspeedway.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RaceDto {
    private RaceStatsDto stats;
    private List<String> participants;
    private RaceOutcomesDto outcomes;
}

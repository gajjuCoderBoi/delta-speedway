package com.cognizant.deltaspeedway.service;

import com.cognizant.deltaspeedway.DTO.RaceOutcomesDto;
import com.cognizant.deltaspeedway.DTO.RaceStatsDto;
import com.cognizant.deltaspeedway.entity.RaceEntity;
import com.cognizant.deltaspeedway.entity.RaceOutcomesEntity;
import com.cognizant.deltaspeedway.entity.RaceStatsEntity;
import com.cognizant.deltaspeedway.repository.RaceRepository;
import com.cognizant.deltaspeedway.DTO.RaceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RaceStatsService {
    @Autowired
    RaceRepository raceRepository;

    public RaceDto createRace(RaceDto raceDto) {
        RaceEntity entity = RaceEntity.builder()
                .stats(RaceStatsEntity.builder()
                        .name(raceDto.getStats().getName())
                        .city(raceDto.getStats().getCity())
                        .build()
                    )
                .participants(raceDto.getParticipants())
                .outcomes(RaceOutcomesEntity.builder()
                        .firstPositionName(raceDto.getOutcomes().getFirstPositionName())
                        .secondPositionName(raceDto.getOutcomes().getSecondPositionName())
                        .thirdPositionName(raceDto.getOutcomes().getThirdPositionName())
                        .build()
                    )
                .build();
        raceRepository.save(entity);
        return raceDto;
    }

    public List<RaceDto> getAllRaceDetails() {
        List<RaceEntity> savedRaces = raceRepository.findAll();
        return savedRaces.stream().map(race-> RaceDto.builder()
                .stats(RaceStatsDto.builder()
                        .name(race.getStats().getName())
                        .city(race.getStats().getCity())
                        .build())
                .outcomes(RaceOutcomesDto.builder()
                        .firstPositionName(race.getOutcomes().getFirstPositionName())
                        .secondPositionName(race.getOutcomes().getSecondPositionName())
                        .thirdPositionName(race.getOutcomes().getThirdPositionName())
                        .build())
                .participants(race.getParticipants())
                .build()).collect(Collectors.toList());
    }
}

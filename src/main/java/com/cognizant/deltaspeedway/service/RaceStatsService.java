package com.cognizant.deltaspeedway.service;

import com.cognizant.deltaspeedway.entity.RaceEntity;
import com.cognizant.deltaspeedway.entity.RaceOutcomesEntity;
import com.cognizant.deltaspeedway.entity.RaceStatsEntity;
import com.cognizant.deltaspeedway.repository.RaceRepository;
import com.cognizant.deltaspeedway.request.RaceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaceStatsService {
    @Autowired
    RaceRepository raceRepository;

    public RaceRequest createRace(RaceRequest raceRequest) {
        RaceEntity entity = RaceEntity.builder()
                .stats(RaceStatsEntity.builder()
                        .name(raceRequest.getStats().getName())
                        .city(raceRequest.getStats().getCity())
                        .build()
                    )
                .participants(raceRequest.getParticipants())
                .outcomes(RaceOutcomesEntity.builder()
                        .firstPositionName(raceRequest.getOutcomes().getFirstPositionName())
                        .secondPositionName(raceRequest.getOutcomes().getSecondPositionName())
                        .thirdPositionName(raceRequest.getOutcomes().getThirdPositionName())
                        .build()
                    )
                .build();
        raceRepository.save(entity);
        return raceRequest;
    }
}

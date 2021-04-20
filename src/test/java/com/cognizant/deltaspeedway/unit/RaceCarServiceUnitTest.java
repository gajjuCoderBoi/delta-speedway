package com.cognizant.deltaspeedway.unit;

import com.cognizant.deltaspeedway.entity.RacecarEntity;
import com.cognizant.deltaspeedway.repository.RaceCarRepository;
import com.cognizant.deltaspeedway.service.RaceCarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("qa")
public class RaceCarServiceUnitTest {
    @InjectMocks
    private RaceCarService raceCarService;

    @Mock
    private RaceCarRepository raceCarRepository;

    private List<RacecarEntity> mockRaceCars;

    @BeforeEach
    void init(){
        mockRaceCars = Arrays.asList(
                RacecarEntity.builder()
                        .make("Galvanize")
                        .model("2021")
                        .build(),
                RacecarEntity.builder()
                        .make("Cognizant")
                        .model("2021")
                        .build()
        );
    }

    @Test
    public void getAllRaceCarTest(){

        when(raceCarRepository.findAll()).thenReturn(mockRaceCars);
        List<RacecarEntity> actual = raceCarService.getAllRaceCar();

        assertNotNull(actual);
        assertTrue(actual.size()>0);
        assertEquals(actual.size(), 2);
        assertEquals(actual, List.of(RacecarEntity.builder()
                        .make("Galvanize")
                        .model("2021")
                        .build(),
                RacecarEntity.builder()
                        .make("Cognizant")
                        .model("2021")
                        .build()));

    }
}

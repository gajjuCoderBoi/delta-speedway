package com.cognizant.deltaspeedway.integration;

import com.cognizant.deltaspeedway.entity.RacecarEntity;
import com.cognizant.deltaspeedway.repository.RaceCarRepository;
import com.cognizant.deltaspeedway.request.CarRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@ActiveProfiles("qa")
public class DeltaRaceCarIT {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private RaceCarRepository raceCarRepository;

    @Test
    @DirtiesContext
    public void getAllRaceCarTest_Success() throws Exception {
        raceCarRepository.saveAll(Arrays.asList(
                RacecarEntity.builder()
                        .make("Galvanize")
                        .model("2021")
                        .build(),
                RacecarEntity.builder()
                        .make("Cognizant")
                        .model("2021")
                        .build()
        ));

        RequestBuilder getAllRaceCar = get("/racecar")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(getAllRaceCar)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)))
                .andDo(print());
    }

    @Test
    @DirtiesContext
    public void createRaceCar_Success() throws Exception {
        CarRequest testCarRequest = CarRequest.builder()
                .make("Cognizant")
                .model("2021")
                .build();
        RequestBuilder postCar = post("/racecar")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(testCarRequest));

        mockMvc.perform(postCar)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("message").value("Car has been created."))
                .andDo(print());
    }

    @Test
    @DirtiesContext
    public void getRaceCarByIdTest_Success() throws Exception {
        raceCarRepository.saveAll(Arrays.asList(
                RacecarEntity.builder()
                        .id(1L)
                        .make("Galvanize")
                        .model("2021")
                        .build(),
                RacecarEntity.builder()
                        .id(2L)
                        .make("Cognizant")
                        .model("2021")
                        .build()
        ));

        RequestBuilder getRaceCarById = get("/racecar")
                .param("car_id", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(getRaceCarById)
                .andExpect(status().isOk())
                .andExpect(jsonPath("make").value("Galvanize"))
                .andExpect(jsonPath("model").value("2021"))
                .andDo(print());
    }
}

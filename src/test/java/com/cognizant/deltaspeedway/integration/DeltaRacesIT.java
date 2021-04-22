package com.cognizant.deltaspeedway.integration;

import com.cognizant.deltaspeedway.entity.RacecarEntity;
import com.cognizant.deltaspeedway.repository.RaceCarRepository;
import com.cognizant.deltaspeedway.request.CarRequest;
import com.cognizant.deltaspeedway.request.RaceOutcomesRequest;
import com.cognizant.deltaspeedway.request.RaceRequest;
import com.cognizant.deltaspeedway.request.RaceStatsRequest;
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
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
@ActiveProfiles("qa")
public class DeltaRacesIT {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void createRaceCar_Success() throws Exception {
        RaceRequest raceRequest = RaceRequest.builder()
                .stats(RaceStatsRequest.builder().name("Race1").city("Daytona").build())
                .participants(List.of("David", "Wes", "Jose", "Mayank"))
                .outcomes(RaceOutcomesRequest.builder().firstPositionName("Jose").secondPositionName("Mayank").thirdPositionName("David").build())
                .build();
        RequestBuilder postRaces = post("/races")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(raceRequest));

        mockMvc.perform(postRaces)
                .andExpect(status().isCreated())
                .andDo(print());
    }
}

package com.cognizant.deltaspeedway.integration;

import com.cognizant.deltaspeedway.DTO.RaceOutcomesDto;
import com.cognizant.deltaspeedway.DTO.RaceDto;
import com.cognizant.deltaspeedway.DTO.RaceStatsDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
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

    private static RaceDto raceDto;

    @BeforeAll
    static void setup(){
        raceDto = RaceDto.builder()
                .stats(RaceStatsDto.builder().name("Race1").city("Daytona").build())
                .participants(List.of("David", "Wes", "Jose", "Mayank"))
                .outcomes(RaceOutcomesDto.builder().firstPositionName("Jose").secondPositionName("Mayank").thirdPositionName("David").build())
                .build();
    }

    @Test
    public void createRaceDetail_Success() throws Exception {

        MvcResult mvcResult = postARaceDetail();

        assertThat(mvcResult.getResponse().getContentAsString(), is(mapper.writeValueAsString(raceDto)));
    }

    @Test
    public void getAllRaces_Success() throws Exception {
        RequestBuilder getAllRaces = get("/races")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(getAllRaces)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(0)));
    }



    private MvcResult postARaceDetail() throws Exception {

        RequestBuilder postRaces = post("/races")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(raceDto));

        return mockMvc.perform(postRaces)
                .andExpect(status().isCreated())
                .andReturn();
    }
}

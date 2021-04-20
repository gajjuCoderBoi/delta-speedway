package com.cognizant.deltaspeedway.unit;

import com.cognizant.deltaspeedway.controller.RaceCarController;
import com.cognizant.deltaspeedway.entity.RacecarEntity;
import com.cognizant.deltaspeedway.service.RaceCarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RaceCarController.class)
@ActiveProfiles("qa")
public class RaceCarControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RaceCarService raceCarService;

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
    public void getAllRaceCarTest() throws Exception {
        RequestBuilder getAllRaceCar = get("/racecar")
                .accept(MediaType.APPLICATION_JSON);

        when(raceCarService.getAllRaceCar()).thenReturn(mockRaceCars);
        verifyNoInteractions(raceCarService);

        mockMvc.perform(getAllRaceCar)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)))
                .andDo(print());
    }
}

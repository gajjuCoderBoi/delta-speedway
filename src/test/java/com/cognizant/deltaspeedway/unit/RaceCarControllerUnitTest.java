package com.cognizant.deltaspeedway.unit;

import com.cognizant.deltaspeedway.controller.RaceCarController;
import com.cognizant.deltaspeedway.entity.RacecarEntity;
import com.cognizant.deltaspeedway.request.CarRequest;
import com.cognizant.deltaspeedway.response.CarResponse;
import com.cognizant.deltaspeedway.service.RaceCarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RaceCarController.class)
@ActiveProfiles("qa")
public class RaceCarControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private RaceCarService raceCarService;

    private List<RacecarEntity> mockRaceCars;
    private CarResponse mockResponse;

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
        mockResponse = CarResponse.builder()
                .message("Car has been created.")
                .status(HttpStatus.CREATED)
                .build();
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

    @Test
    @DirtiesContext
    public void createRaceCar() throws Exception {

        CarRequest testCarRequest = CarRequest.builder()
                .make("Cognizant")
                .model("2021")
                .build();
        RequestBuilder postCar = post("/racecar")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(testCarRequest));

        when(raceCarService.createCar(any())).thenReturn(mockResponse);

        mockMvc.perform(postCar)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("message").value("Car has been created."))
                .andDo(print());
    }
}

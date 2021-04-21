package com.cognizant.deltaspeedway;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DriversTestIT {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper   objectMapper;

    @Test
    public void getDriverByName() throws Exception {
        DriverDeltaDto vettel=new DriverDeltaDto("vettel");
        DriverDeltaDto hamilton=new DriverDeltaDto("hamilton");
        DriverDeltaDto riccardo=new DriverDeltaDto("riccardo");


        mockMvc.perform(post("/drivers")
                .content(objectMapper.writeValueAsString(vettel))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
        mockMvc.perform(post("/drivers")
                .content(objectMapper.writeValueAsString(hamilton))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
        mockMvc.perform(post("/drivers")
                .content(objectMapper.writeValueAsString(riccardo))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
        mockMvc.perform(get(String.format("/drivers/%s", vettel.getName()))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("vettel"));


    }


}
package com.cognizant.deltaspeedway;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

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
        CarsDto carCondor=new CarsDto("Condor","Corvette","2019","27","AVAILABLE",189);
        CarsDto carCondor123=new CarsDto("Condor","Corvette","2021","27","AVAILABLE",189);
        CarsDto carCondor345=new CarsDto("Condor","Corvette","2022","27","AVAILABLE",189);

        List<CarsDto> carsVettel=new ArrayList<>();

        carsVettel.add(carCondor);
        List<CarsDto> carsHamilton=new ArrayList<>();
        carsHamilton.add(carCondor123);
        List<CarsDto> carsRicciardo=new ArrayList<>();
        carsRicciardo.add(carCondor345);


        DriverDeltaDto vettel=new DriverDeltaDto("Seb","vettel","22","tetrachapmpion",4,1,carsHamilton);
        DriverDeltaDto hamilton=new DriverDeltaDto("Lewis","Hamilton","28","Mr Consistent",5,0,carsHamilton);
        DriverDeltaDto riccardo=new DriverDeltaDto("Daniel","Ricciardo","28","Honey Badger",2,2,carsRicciardo);


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
        mockMvc.perform(get(String.format("/drivers/%s", vettel.getFirstName()))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("vettel"));


    }


}

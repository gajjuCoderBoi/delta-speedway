package com.cognizant.deltaspeedway;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@Transactional
public class DriversTestIT {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper   objectMapper;

    @Test
    public void getDriverByNickname() throws Exception {
        CarsDto carCondor=new CarsDto("Condor","Corvette","2019","27","AVAILABLE",189);
        CarsDto carCondor123=new CarsDto("Condor","Corvette","2021","27","AVAILABLE",189);
        CarsDto carCondor345=new CarsDto("Condor","Corvette","2022","27","AVAILABLE",189);

        Set<CarsDto> carsVettel=new LinkedHashSet<>();
        carsVettel.add(carCondor);
        Set<CarsDto> carsHamilton=new LinkedHashSet<>();
        carsHamilton.add(carCondor123);
        Set<CarsDto> carsRicciardo=new LinkedHashSet<>();
        carsRicciardo.add(carCondor345);


        DriverDeltaDto vettel=new DriverDeltaDto("Seb","vettel","22","tetrachampion",4,1,carsHamilton);
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
        mockMvc.perform(get(String.format("/drivers/%s", vettel.getNickname()))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.nickname").value("tetrachampion"))
        .andDo(document("driver POST", responseFields(
                fieldWithPath("firstName").description("Seb"),
                fieldWithPath("lastName").description("vettel"),
                fieldWithPath("age").description("22"),
                fieldWithPath("nickname").description("tetrachampion"),
                fieldWithPath("wins").description(4),
                fieldWithPath("losses").description(1),
                fieldWithPath("cars[].nickname").description("Condor"),
                fieldWithPath("cars[].model").description("Corvette"),
                fieldWithPath("cars[].year").description("2019"),
                fieldWithPath("cars[].owner").description("27"),
                fieldWithPath("cars[].status").description("AVAILABLE"),
                fieldWithPath("cars[].top_speed").description(189)

        )));

    }


}

package com.cognizant.deltaspeedway;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class DriverDeltaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String firstName;
    String lastName;
    String age;
    String nickname;
    int wins;
    int losses;
    @OneToMany(mappedBy="DriverDeltaEntity")
    List<CarsDto> cars= new ArrayList<>();


    public DriverDeltaEntity (String lastName){
        this.lastName = lastName;
    }
}

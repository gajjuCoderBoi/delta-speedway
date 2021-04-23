package com.cognizant.deltaspeedway.entity;

import com.cognizant.deltaspeedway.CarsDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Data
@Table(name="drivers")
@EqualsAndHashCode
@NoArgsConstructor
public class DriverDeltaEntity {
    @Id
    @Getter
    @Setter
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String firstName;
    String lastName;
    String age;
    String nickname;
    int wins;
    int losses;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "driverDeltaEntity")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Setter
    private Set<CarDeltaEntity> cars;

    public DriverDeltaEntity(String firstName, String lastName, String age, String nickname, int wins, int losses, Set<CarDeltaEntity> carDeltaEntities) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
        this.nickname=nickname;
        this.wins=wins;
        this.losses=losses;
        this.cars=carDeltaEntities;
    }


    @JsonIgnore
    public Set<CarDeltaEntity> getCars() {
        return cars;
    }

    public DriverDeltaEntity (String nickname){
        this.nickname = nickname;
    }
}

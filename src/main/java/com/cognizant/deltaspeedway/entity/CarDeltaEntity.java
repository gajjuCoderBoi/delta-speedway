package com.cognizant.deltaspeedway.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class CarDeltaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String nickname;
    String model;
    String year;
    String owner;
    String status;
    int top_speed;

    @JoinColumn(name = "parent", referencedColumnName = "id")
    @ManyToOne
    private DriverDeltaEntity driverDeltaEntity;

    public CarDeltaEntity(String nickname){
        this.nickname = nickname;
    }

    public CarDeltaEntity(String nickname, String model, String year, String owner, String status, int top_speed) {
    this.nickname=nickname;
    this.model=model;
    this.year=year;
    this.owner=owner;
    this.status=status;
    this.top_speed=top_speed;

    }
}

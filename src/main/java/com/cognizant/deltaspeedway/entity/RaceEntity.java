package com.cognizant.deltaspeedway.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private RaceStatsEntity stats;

    @ElementCollection
    private List<String> participants;

    @OneToOne(cascade = CascadeType.ALL)
    private RaceOutcomesEntity outcomes;
}

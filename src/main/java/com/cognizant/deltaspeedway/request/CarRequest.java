package com.cognizant.deltaspeedway.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class CarRequest {
    private String make;

    private String model;
}

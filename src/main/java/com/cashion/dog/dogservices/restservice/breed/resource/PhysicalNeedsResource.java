package com.cashion.dog.dogservices.restservice.breed.resource;

import lombok.Data;

import javax.validation.constraints.Max;
import java.io.Serializable;

@Data
public class PhysicalNeedsResource implements Serializable {
    @Max(value = 5)
    private Long energyLevel;

    @Max(value = 5)
    private Long intensity;

    @Max(value = 5)
    private Long exerciseNeeds;

    @Max(value = 5)
    private Long potentialForPlayfulness;
}

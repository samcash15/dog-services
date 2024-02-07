package com.cashion.dog.dogservices.restservice.breed.request;

import jakarta.validation.constraints.Max;
import java.io.Serializable;
import lombok.Data;

@Data
public class PhysicalNeedsRequest implements Serializable {
    @Max(value = 5)
    private Long energyLevel;

    @Max(value = 5)
    private Long intensity;

    @Max(value = 5)
    private Long exerciseNeeds;

    @Max(value = 5)
    private Long potentialForPlayfulness;
}

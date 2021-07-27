package com.cashion.dog.dogservices.restservice.breed.resource;

import lombok.Data;

import javax.validation.constraints.Max;
import java.io.Serializable;

@Data
public class HealthAndGroomingNeedsResource implements Serializable {
    @Max(value = 5)
    private Long amountOfShedding;

    @Max(value = 5)
    private Long droolingPotential;

    @Max(value = 5)
    private Long easyToGroom;

    @Max(value = 5)
    private Long generalHealth;

    @Max(value = 5)
    private Long potentialForWeightGain;

    @Max(value = 5)
    private Long size;
}

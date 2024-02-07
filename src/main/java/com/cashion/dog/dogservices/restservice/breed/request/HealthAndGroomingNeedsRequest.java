package com.cashion.dog.dogservices.restservice.breed.request;

import jakarta.validation.constraints.Max;
import java.io.Serializable;
import lombok.Data;

@Data
public class HealthAndGroomingNeedsRequest implements Serializable {
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

package com.cashion.dog.dogservices.restservice.breed.request;

import jakarta.validation.constraints.Max;
import java.io.Serializable;
import lombok.Data;

@Data
public class AdaptabilityRequest implements Serializable {
    @Max(value = 5)
    private Long adaptsWellToApartmentLiving;

    @Max(value = 5)
    private Long goodForNoviceOwners;

    @Max(value = 5)
    private Long sensitivityLevel;

    @Max(value = 5)
    private Long toleratesBeingAlone;

    @Max(value = 5)
    private Long toleratesColdWeather;

    @Max(value = 5)
    private Long toleratesHotWeather;
}

package com.cashion.dog.dogservices.restservice.breed.resource;

import lombok.Data;

import javax.validation.constraints.Max;
import java.io.Serializable;

@Data
public class AdaptabilityResource implements Serializable {
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

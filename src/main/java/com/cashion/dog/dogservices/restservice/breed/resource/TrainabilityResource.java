package com.cashion.dog.dogservices.restservice.breed.resource;

import lombok.Data;

import javax.validation.constraints.Max;
import java.io.Serializable;

@Data
public class TrainabilityResource implements Serializable {
    @Max(value = 5)
    private Long easyToTrain;

    @Max(value = 5)
    private Long intelligence;

    @Max(value = 5)
    private Long potentialForMouthiness;

    @Max(value = 5)
    private Long preyDrive;

    @Max(value = 5)
    private Long tendencyToBarkOrHowl;

    @Max(value = 5)
    private Long wanderlustPotential;
}

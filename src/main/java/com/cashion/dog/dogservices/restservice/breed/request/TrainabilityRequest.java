package com.cashion.dog.dogservices.restservice.breed.request;

import jakarta.validation.constraints.Max;
import java.io.Serializable;
import lombok.Data;

@Data
public class TrainabilityRequest implements Serializable {
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

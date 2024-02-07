package com.cashion.dog.dogservices.restservice.breed.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.Data;

@Data
public class DogBreedRequest implements Serializable {

    @Size(max = 50)
    @NotBlank(message = "Breed cannot be blank.")
    @NotEmpty(message = "Breed cannot be empty.")
    private String breed;

    @Size(max = 15)
    @NotEmpty(message = "The approximate weight cannot be empty.")
    @NotBlank(message = "The approximate weight cannot be blank.")
    private String approximateWeight;

    @Size(max = 10)
    @NotBlank
    @NotEmpty
    private String size;

    @Max(value = 5)
    private Long adaptabilityRating;

    @Max(value = 5)
    private Long friendlinessRating;

    @Max(value = 5)
    private Long groomingNeedsRating;

    @Max(value = 5)
    private Long trainabilityRating;

    @Max(value = 5)
    private Long physicalNeedsRating;

//    private AdaptabilityRequest adaptabilityRequest;
//    private FriendlinessRequest friendlinessRequest;
//    private HealthAndGroomingNeedsRequest healthAndGroomingNeedsRequest;
//    private TrainabilityRequest trainabilityRequest;
//    private PhysicalNeedsRequest physicalNeedsRequest;

}

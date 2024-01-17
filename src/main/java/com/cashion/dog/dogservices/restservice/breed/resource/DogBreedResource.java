package com.cashion.dog.dogservices.restservice.breed.resource;

import java.io.Serializable;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class DogBreedResource implements Serializable {

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

    private AdaptabilityResource adaptabilityResource;
    private FriendlinessResource friendlinessResource;
    private HealthAndGroomingNeedsResource healthAndGroomingNeedsResource;
    private TrainabilityResource trainabilityResource;
    private PhysicalNeedsResource physicalNeedsResource;

    @Autowired
    public DogBreedResource(AdaptabilityResource adaptabilityResource,
                            FriendlinessResource friendlinessResource,
                            HealthAndGroomingNeedsResource healthAndGroomingNeedsResource,
                            TrainabilityResource trainabilityResource,
                            PhysicalNeedsResource physicalNeedsResource) {
        this.adaptabilityResource = adaptabilityResource;
        this.friendlinessResource = friendlinessResource;
        this.healthAndGroomingNeedsResource = healthAndGroomingNeedsResource;
        this.trainabilityResource = trainabilityResource;
        this.physicalNeedsResource = physicalNeedsResource;

    }

    public DogBreedResource() {

    }
}

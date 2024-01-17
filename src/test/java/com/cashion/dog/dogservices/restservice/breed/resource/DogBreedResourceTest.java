package com.cashion.dog.dogservices.restservice.breed.resource;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DogBreedResourceTest {

    private static Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void whenValidDogBreedResource_thenNoConstraintViolations() {
        DogBreedResource resource = buildDogBreedResource();

        Set<ConstraintViolation<DogBreedResource>> violations = validator.validate(resource);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void whenOverMaxSizeBreed_thenOneConstraintViolation() {
        DogBreedResource resource = buildDogBreedResource();
        String breed = StringUtils.repeat("a", 51);
        resource.setBreed(breed);

        Set<ConstraintViolation<DogBreedResource>> violations = validator.validate(resource);
        assertFalse(violations.isEmpty());
    }

    public DogBreedResource buildDogBreedResource() {
        DogBreedResource resource = new DogBreedResource();
        resource.setBreed("German Shepherd");
        resource.setApproximateWeight("50-75lbs");
        resource.setSize("LARGE");
        resource.setAdaptabilityRating(4L);
        resource.setFriendlinessRating(4L);
        resource.setGroomingNeedsRating(4L);
        resource.setTrainabilityRating(5L);
        resource.setPhysicalNeedsRating(5L);

        return resource;
    }
}

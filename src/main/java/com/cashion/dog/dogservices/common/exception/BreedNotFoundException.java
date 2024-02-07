package com.cashion.dog.dogservices.common.exception;

public class BreedNotFoundException extends DogBreedException {
    public BreedNotFoundException(String breed) {
        super("Breed not found: " + breed);
    }
}

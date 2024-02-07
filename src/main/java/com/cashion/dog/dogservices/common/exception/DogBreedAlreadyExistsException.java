package com.cashion.dog.dogservices.common.exception;

public class DogBreedAlreadyExistsException extends DogBreedException {
    public DogBreedAlreadyExistsException(String breed) {
        super("Breed already exists: " + breed);
    }
}

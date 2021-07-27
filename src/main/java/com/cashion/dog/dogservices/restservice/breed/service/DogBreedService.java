package com.cashion.dog.dogservices.restservice.breed.service;

import com.cashion.dog.dogservices.persistence.domain.DogBreed;
import com.cashion.dog.dogservices.restservice.breed.resource.DogBreedResource;

public interface DogBreedService {

    void saveBreed(DogBreedResource dogBreedResource);

    DogBreed getBreed(String breed);
}

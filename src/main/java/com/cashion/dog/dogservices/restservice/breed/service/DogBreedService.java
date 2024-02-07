package com.cashion.dog.dogservices.restservice.breed.service;

import com.cashion.dog.dogservices.persistence.domain.DogBreed;
import com.cashion.dog.dogservices.restservice.breed.request.DogBreedRequest;
import java.util.List;

public interface DogBreedService {

    DogBreed saveBreed(DogBreedRequest dogBreedRequest);

    void updateBreed(DogBreedRequest dogBreedRequest);

    void deleteBreed(String breed);

    DogBreed getBreed(String breed);

    List<String> getAllBreeds();

}

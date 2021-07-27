package com.cashion.dog.dogservices.restservice.breed.mapper;

import com.cashion.dog.dogservices.persistence.domain.DogBreed;
import com.cashion.dog.dogservices.restservice.breed.resource.DogBreedResource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DogBreedMapper {

    public DogBreed mapResourceToDomain(DogBreedResource resource) {
        if (resource == null) {
            return null;
        }

        DogBreed domain = new DogBreed();
        domain.setBreed(resource.getBreed());
        domain.setApproximateWeight(resource.getApproximateWeight());
        domain.setSize(resource.getSize());
        domain.setAdaptabilityRating(resource.getAdaptabilityRating());
        domain.setFriendlinessRating(resource.getFriendlinessRating());
        domain.setGroomRating(resource.getGroomingNeedsRating());
        domain.setTrainRating(resource.getTrainabilityRating());
        domain.setPhysicalNeedRating(resource.getPhysicalNeedsRating());
        domain.setCreateDate(new Date());

        return domain;
    }
}

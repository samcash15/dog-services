package com.cashion.dog.dogservices.restservice.breed.mapper;

import com.cashion.dog.dogservices.persistence.domain.DogBreed;
import com.cashion.dog.dogservices.restservice.breed.request.DogBreedRequest;
import com.cashion.dog.dogservices.restservice.breed.response.DogBreedResponse;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class DogBreedMapper {

    public DogBreed mapRequestToDomain(DogBreedRequest request) {
        if (request == null) {
            return null;
        }

        DogBreed domain = new DogBreed();
        domain.setBreed(request.getBreed());
        domain.setApproximateWeight(request.getApproximateWeight());
        domain.setSize(request.getSize());
        domain.setAdaptabilityRating(request.getAdaptabilityRating());
        domain.setFriendlinessRating(request.getFriendlinessRating());
        domain.setGroomRating(request.getGroomingNeedsRating());
        domain.setTrainRating(request.getTrainabilityRating());
        domain.setPhysicalNeedRating(request.getPhysicalNeedsRating());
        domain.setCreateDate(new Date());

        return domain;
    }

    public DogBreedResponse mapDomainToResponse(DogBreed domain) {
        if (domain == null) {
            return null;
        }
        DogBreedResponse response = new DogBreedResponse();
        response.setBreed(domain.getBreed());
        response.setApproximateWeight(domain.getApproximateWeight());
        response.setSize(domain.getSize());
        response.setAdaptabilityRating(domain.getAdaptabilityRating());
        response.setFriendlinessRating(domain.getFriendlinessRating());
        response.setGroomRating(domain.getGroomRating());
        response.setTrainRating(domain.getTrainRating());
        response.setPhysicalNeedRating(domain.getPhysicalNeedRating());
        response.setCreateDate(domain.getCreateDate());
        response.setUpdateDate(domain.getUpdateDate());

        return response;
    }

    public void updateDomainFromResource(DogBreed existingDomain, DogBreedRequest resource) {
        if (existingDomain == null || resource == null) {
            return;
        }

        existingDomain.setBreed(resource.getBreed());
        existingDomain.setApproximateWeight(resource.getApproximateWeight());
        existingDomain.setSize(resource.getSize());
        existingDomain.setAdaptabilityRating(resource.getAdaptabilityRating());
        existingDomain.setFriendlinessRating(resource.getFriendlinessRating());
        existingDomain.setGroomRating(resource.getGroomingNeedsRating());
        existingDomain.setTrainRating(resource.getTrainabilityRating());
        existingDomain.setPhysicalNeedRating(resource.getPhysicalNeedsRating());
        // Not updating createDate since this is the initial creation of the record.
    }
}

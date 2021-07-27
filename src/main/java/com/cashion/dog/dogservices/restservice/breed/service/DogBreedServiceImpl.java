package com.cashion.dog.dogservices.restservice.breed.service;

import com.cashion.dog.dogservices.persistence.domain.*;
import com.cashion.dog.dogservices.persistence.repository.*;
import com.cashion.dog.dogservices.restservice.breed.mapper.*;
import com.cashion.dog.dogservices.restservice.breed.resource.DogBreedResource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogBreedServiceImpl implements DogBreedService {
    public static final Log LOG = LogFactory.getLog(DogBreedServiceImpl.class);

    private final DogBreedMapper dogBreedMapper;
    private final AdaptabilityMapper adaptabilityMapper;
    private final FriendlinessMapper friendlinessMapper;
    private final HealthAndGroomingNeedsMapper healthAndGroomingNeedsMapper;
    private final PhysicalNeedsMapper physicalNeedsMapper;
    private final TrainabilityMapper trainabilityMapper;
    private final DogBreedRepository repository;
    private final AdaptabilityRepository adaptRepo;
    private final FriendlinessRepository friendlinessRepo;
    private final HealthAndGroomingNeedsRepository healthRepo;
    private final PhysicalNeedsRepository physicalNeedsRepo;
    private final TrainabilityRepository trainRepo;

    @Autowired
    public DogBreedServiceImpl(DogBreedMapper dogBreedMapper,
                               AdaptabilityMapper adaptabilityMapper,
                               FriendlinessMapper friendlinessMapper,
                               HealthAndGroomingNeedsMapper healthAndGroomingNeedsMapper,
                               PhysicalNeedsMapper physicalNeedsMapper,
                               TrainabilityMapper trainabilityMapper,
                               DogBreedRepository repository,
                               AdaptabilityRepository adaptRepo,
                               FriendlinessRepository friendlinessRepo,
                               HealthAndGroomingNeedsRepository healthRepo,
                               PhysicalNeedsRepository physicalNeedsRepo,
                               TrainabilityRepository trainRepo) {
        this.dogBreedMapper = dogBreedMapper;
        this.adaptabilityMapper = adaptabilityMapper;
        this.friendlinessMapper = friendlinessMapper;
        this.healthAndGroomingNeedsMapper = healthAndGroomingNeedsMapper;
        this.physicalNeedsMapper = physicalNeedsMapper;
        this.trainabilityMapper = trainabilityMapper;
        this.repository = repository;
        this.adaptRepo = adaptRepo;
        this.friendlinessRepo = friendlinessRepo;
        this.healthRepo = healthRepo;
        this.physicalNeedsRepo = physicalNeedsRepo;
        this.trainRepo = trainRepo;
    }

    public void saveBreed(DogBreedResource resource) {
        try {
            if (resource != null) {
                DogBreed dogBreed = dogBreedMapper.mapResourceToDomain(resource);
                Adaptability adaptability = adaptabilityMapper.mapResourceToDomain(resource.getAdaptabilityResource());
                Friendliness friendliness = friendlinessMapper.mapResourceToDomain(resource.getFriendlinessResource());
                HealthAndGroomingNeeds healthAndGroomingNeeds = healthAndGroomingNeedsMapper.mapResourceToDomain(resource.getHealthAndGroomingNeedsResource());
                PhysicalNeeds physicalNeeds = physicalNeedsMapper.mapResourceToDomain(resource.getPhysicalNeedsResource());
                Trainability trainability = trainabilityMapper.mapResourceToDomain(resource.getTrainabilityResource());

                repository.save(dogBreed);

                if (adaptability != null) {
                    adaptability.setDogId(dogBreed);
                    adaptRepo.save(adaptability);
                }

                if (friendliness != null) {
                    friendliness.setDogId(dogBreed);
                    friendlinessRepo.save(friendliness);
                }

                if (healthAndGroomingNeeds != null) {
                    healthAndGroomingNeeds.setDogId(dogBreed);
                    healthRepo.save(healthAndGroomingNeeds);
                }

                if (physicalNeeds != null) {
                    physicalNeeds.setDogId(dogBreed);
                    physicalNeedsRepo.save(physicalNeeds);
                }

                if (trainability != null) {
                    trainability.setDogId(dogBreed);
                    trainRepo.save(trainability);
                }

            }
        } catch(Exception e) {
            LOG.error("Could not save information to DOG_BREED table. " +
                    "DogBreedInfoResource: " + resource +
                    "Exception Occurred: " + e.getMessage());
        }
    }

    public DogBreed getBreed(String breed) {
        DogBreed dogBreed = new DogBreed();

        try {
            LOG.info("Attempting to get " + breed + " information from DOG_BREED table.");
            dogBreed = repository.findByBreed(breed);
            if (dogBreed != null) {
                LOG.info("Retrieved information on " + breed + " from DOG_BREED table.");
            } else {
                throw new IllegalStateException("DOG_BREED came back null with the given breed: " + breed);
            }

        } catch(IllegalStateException illegalStateException) {
          LOG.error("Could not find record in the DOG_BREED table with the given breed." +
                  "Breed: " + breed +
                  "IllegalStateException: " + illegalStateException.getMessage());
        } catch(Exception e) {
            LOG.error("Could not get information on " + breed + " from DOG_BREED table. " +
                    "Exception Occurred: " + e.getMessage());
        }

        return dogBreed;
    }
}

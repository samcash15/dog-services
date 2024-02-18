package com.cashion.dog.dogservices.restservice.breed.service;

import com.cashion.dog.dogservices.common.exception.DogBreedAlreadyExistsException;
import com.cashion.dog.dogservices.common.exception.DogBreedException;
import com.cashion.dog.dogservices.persistence.domain.Adaptability;
import com.cashion.dog.dogservices.persistence.domain.DogBreed;
import com.cashion.dog.dogservices.persistence.domain.Friendliness;
import com.cashion.dog.dogservices.persistence.domain.HealthAndGroomingNeeds;
import com.cashion.dog.dogservices.persistence.domain.PhysicalNeeds;
import com.cashion.dog.dogservices.persistence.domain.Trainability;
import com.cashion.dog.dogservices.persistence.repository.AdaptabilityRepository;
import com.cashion.dog.dogservices.persistence.repository.DogBreedRepository;
import com.cashion.dog.dogservices.persistence.repository.FriendlinessRepository;
import com.cashion.dog.dogservices.persistence.repository.HealthAndGroomingNeedsRepository;
import com.cashion.dog.dogservices.persistence.repository.PhysicalNeedsRepository;
import com.cashion.dog.dogservices.persistence.repository.TrainabilityRepository;
import com.cashion.dog.dogservices.restservice.breed.mapper.AdaptabilityMapper;
import com.cashion.dog.dogservices.restservice.breed.mapper.DogBreedMapper;
import com.cashion.dog.dogservices.restservice.breed.mapper.FriendlinessMapper;
import com.cashion.dog.dogservices.restservice.breed.mapper.HealthAndGroomingNeedsMapper;
import com.cashion.dog.dogservices.restservice.breed.mapper.PhysicalNeedsMapper;
import com.cashion.dog.dogservices.restservice.breed.mapper.TrainabilityMapper;
import com.cashion.dog.dogservices.restservice.breed.request.DogBreedRequest;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public DogBreed saveBreed(DogBreedRequest request) {
        if (repository.existsByBreed(request.getBreed())) {
            throw new DogBreedAlreadyExistsException("Breed already exists: " + request.getBreed());
        }

        try {
                DogBreed dogBreed = dogBreedMapper.mapRequestToDomain(request);
                Adaptability adaptability = adaptabilityMapper.mapResourceToDomain(request.getAdaptabilityRequest());
                Friendliness friendliness = friendlinessMapper.mapResourceToDomain(request.getFriendlinessRequest());
                HealthAndGroomingNeeds healthAndGroomingNeeds = healthAndGroomingNeedsMapper.mapResourceToDomain(request.getHealthAndGroomingNeedsRequest());
                PhysicalNeeds physicalNeeds = physicalNeedsMapper.mapResourceToDomain(request.getPhysicalNeedsRequest());
                Trainability trainability = trainabilityMapper.mapResourceToDomain(request.getTrainabilityRequest());

                repository.save(dogBreed);

                if (adaptability != null) {
                    adaptability.setDogBreed(dogBreed);
                    adaptRepo.save(adaptability);
                }

                if (friendliness != null) {
                    friendliness.setDogBreed(dogBreed);
                    friendlinessRepo.save(friendliness);
                }

                if (healthAndGroomingNeeds != null) {
                    healthAndGroomingNeeds.setDogBreed(dogBreed);
                    healthRepo.save(healthAndGroomingNeeds);
                }

                if (physicalNeeds != null) {
                    physicalNeeds.setDogBreed(dogBreed);
                    physicalNeedsRepo.save(physicalNeeds);
                }

                if (trainability != null) {
                    trainability.setDogBreed(dogBreed);
                    trainRepo.save(trainability);
                }
                LOG.info("Successfully saved to all the corresponding tables.");
                return dogBreed;
        } catch(Exception e) {
            LOG.error("Could not save information to DOG_BREED table. " +
                    "DogBreedInfoResource: " + request +
                    "Exception Occurred: " + e.getMessage());
            throw new ServiceException("Failed to save breed: " + request.getBreed(), e);
        }
    }

    @Transactional
    public void updateBreed(DogBreedRequest resource) {
        try {
            if (resource != null) {
                DogBreed existingDogBreed = repository.findByBreed(resource.getBreed());
                if (existingDogBreed == null) {
                    LOG.warn("Dog Breed does not exist in the database yet. Please create a new one before updating.");
                    throw new DogBreedException(resource.getBreed());
                }

                dogBreedMapper.updateDomainFromResource(existingDogBreed, resource);
                repository.save(existingDogBreed);

                LOG.info("Successfully updated the breed and its corresponding information.");
            }
        } catch (DogBreedException dogBreedException) {
          LOG.error("Could not update information in DOG_BREED table. " +
                  "DogBreedResource: " + resource +
                  "BreedNotFoundException Occurred: " + dogBreedException.getMessage());
        } catch (Exception e) {
            LOG.error("Could not update information in DOG_BREED table. " +
                    "DogBreedResource: " + resource +
                    "Exception Occurred: " + e.getMessage());
        }
    }

    @Transactional
    public void deleteBreed(String breed) {
        try {
            if (breed != null) {
                DogBreed existingDogBreed = repository.findByBreed(breed);
                if (existingDogBreed == null) {
                    LOG.warn("Dog Breed does not exist in the database yet.");
                    throw new DogBreedException(breed);
                }

                repository.delete(existingDogBreed);

                LOG.info("Successfully deleted the following breed and all its information from the database: " + breed);
            }
        } catch (DogBreedException dogBreedException) {
            LOG.error("Could not delete information in DOG_BREED table. " +
                    "BreedNotFoundException Occurred: " + dogBreedException.getMessage());
        } catch (Exception e) {
            LOG.error("Could not delete information in DOG_BREED table for breed: . " + breed +
                    "Exception Occurred: " + e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public DogBreed getBreed(String breed) {
        DogBreed dogBreed = new DogBreed();

        try {
            LOG.info("Attempting to get " + breed + " information from DOG_BREED table.");
            dogBreed = repository.findByBreed(breed);

            if (dogBreed != null) {
                LOG.info("Retrieved information on " + breed + " from DOG_BREED table. " + dogBreed);
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

    @Transactional(readOnly = true)
    public List<String> getAllBreeds() {
        List<String> dogBreedList = new ArrayList<>();

        try {
            dogBreedList = repository.getAllBreeds();

            if (dogBreedList != null) {
                LOG.info("Retrieved information on  all " + dogBreedList.size() + " dog breeds");
            } else {
                throw new IllegalStateException("No dog breeds to show.");
            }
        } catch (Exception e) {
            LOG.error("Could not  get a list of dog breeds from the DOG_BREED table."
                    + "Exception Occurred: " + e.getMessage());
        }
        return dogBreedList;
    }
}

package com.cashion.dog.dogservices.restservice.breed.controller;

import com.cashion.dog.dogservices.persistence.domain.DogBreed;
import com.cashion.dog.dogservices.persistence.repository.DogBreedRepository;
import com.cashion.dog.dogservices.restservice.breed.mapper.DogBreedMapper;
import com.cashion.dog.dogservices.restservice.breed.request.DogBreedRequest;
import com.cashion.dog.dogservices.restservice.breed.response.DogBreedResponse;
import com.cashion.dog.dogservices.restservice.breed.service.DogBreedService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/breed")
public class DogBreedController {
    public static final Log LOG = LogFactory.getLog(DogBreedController.class);

    private final DogBreedService dogBreedService;
    private final DogBreedRepository dogBreedRepository;
    private final DogBreedMapper dogBreedMapper;

    @Autowired
    public DogBreedController(DogBreedService dogBreedService,
                              DogBreedRepository dogBreedRepository,
                              DogBreedMapper dogBreedMapper) {
        this.dogBreedService = dogBreedService;
        this.dogBreedRepository = dogBreedRepository;
        this.dogBreedMapper = dogBreedMapper;
    }

    @PostMapping(path = "/addBreed", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> addBreed(@Valid @RequestBody DogBreedRequest dogBreedRequest,
                                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getAllErrors()
                    .stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining(", "));
            LOG.warn("Binding errors occurred: " + errorMessage);
            return ResponseEntity.badRequest().body(errorMessage);
        }

        DogBreed savedDogBreed = dogBreedService.saveBreed(dogBreedRequest);
        DogBreedResponse dogBreedResponse = dogBreedMapper.mapDomainToResponse(savedDogBreed);

        return ResponseEntity.ok(dogBreedResponse);
    }

    @GetMapping(path = "/getBreed/{breed}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<DogBreedResponse> getBreed(@PathVariable String breed) {
        DogBreed dogBreed = dogBreedService.getBreed(breed);

        if (dogBreed == null) {
            LOG.warn("Could not retrieve information on that breed: " + breed);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        DogBreedResponse dogBreedResponse = dogBreedMapper.mapDomainToResponse(dogBreed);

        return ResponseEntity.ok(dogBreedResponse);
    }

    @GetMapping(path = "/getAllBreeds", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<String>> getAllBreeds() {
        List<String> dogBreedList = dogBreedService.getAllBreeds();

        if (dogBreedList.isEmpty()) {
            LOG.warn("There are no dog breeds to retrieve from the DOG_BREED table.");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(dogBreedList);
    }

    @PutMapping(path = "/updateBreed/{breed}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> updateBreed(@Valid @RequestBody DogBreedRequest dogBreedRequest,
                                              BindingResult bindingResult) {

        DogBreed dogBreed = dogBreedService.getBreed(dogBreedRequest.getBreed());

        if (dogBreed == null) {
            LOG.warn("Breed does not exist in the database. Please add that breed before updating.");
            return ResponseEntity.notFound().build();
        } else if (bindingResult.hasErrors()) {
            LOG.warn("Binding errors occurred " + bindingResult.getAllErrors());
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors().toString());
        } else {
            dogBreedService.updateBreed(dogBreedRequest);
            LOG.info("Successfully updated the following breed: " + dogBreedRequest.getBreed());
        }

        return ResponseEntity.ok().build();

    }

    @DeleteMapping(path = "/deleteBreed/{breed}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> deleteBreed(@PathVariable String breed) {
        DogBreed dogBreed = dogBreedRepository.findByBreed(breed);

        if (dogBreed == null) {
            LOG.warn("Breed does not exist in the database.");
            return ResponseEntity.notFound().build();
        } else {
            dogBreedService.deleteBreed(breed);
            LOG.info("Successfully deleted the following breed: " + breed);
        }

        return ResponseEntity.ok().build();
    }

}

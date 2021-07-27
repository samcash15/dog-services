package com.cashion.dog.dogservices.restservice.breed.controller;

import com.cashion.dog.dogservices.persistence.domain.DogBreed;
import com.cashion.dog.dogservices.persistence.repository.DogBreedRepository;
import com.cashion.dog.dogservices.restservice.breed.resource.DogBreedResource;
import com.cashion.dog.dogservices.restservice.breed.service.DogBreedService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DogBreedController {
    public static final Log LOG = LogFactory.getLog(DogBreedController.class);

    private DogBreedService dogBreedService;
    private DogBreedRepository dogBreedRepository;

    @Autowired
    public DogBreedController(DogBreedService dogBreedService,
                              DogBreedRepository dogBreedRepository) {
        this.dogBreedService = dogBreedService;
        this.dogBreedRepository = dogBreedRepository;
    }

    @PostMapping(path = "/addBreed", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> addBreed(@Valid @RequestBody DogBreedResource dogBreedResource,
                                                  BindingResult bindingResult) {
        dogBreedService.saveBreed(dogBreedResource);

        if (bindingResult.hasErrors()) {
            LOG.warn("Binding errors occurred " + bindingResult.getAllErrors().toString());
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors().toString());
        }

        return ResponseEntity.ok("");
    }

    @GetMapping(path = "/getAllBreeds", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<DogBreed> getAllBreeds() {
        return dogBreedRepository.findAll();
    }

    @GetMapping(path = "/getBreed/{breed}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<DogBreed> getBreed(@PathVariable String breed) {
        DogBreed dogBreed = dogBreedService.getBreed(breed);
        if (dogBreed == null) {
            LOG.warn("Could not retrieve information on that breed: " + breed);
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(dogBreed);
    }
}

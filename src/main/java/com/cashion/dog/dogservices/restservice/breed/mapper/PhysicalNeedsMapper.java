package com.cashion.dog.dogservices.restservice.breed.mapper;

import com.cashion.dog.dogservices.persistence.domain.PhysicalNeeds;
import com.cashion.dog.dogservices.restservice.breed.resource.PhysicalNeedsResource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PhysicalNeedsMapper {

    public PhysicalNeeds mapResourceToDomain(PhysicalNeedsResource resource) {
        if (resource == null) {
            return null;
        }

        PhysicalNeeds domain = new PhysicalNeeds();
        domain.setEnergyLevel(resource.getEnergyLevel());
        domain.setIntensity(resource.getIntensity());
        domain.setExerciseNeeds(resource.getExerciseNeeds());
        domain.setPotentialForPlayfulness(resource.getPotentialForPlayfulness());
        domain.setCreateDate(new Date());

        return domain;
    }
}

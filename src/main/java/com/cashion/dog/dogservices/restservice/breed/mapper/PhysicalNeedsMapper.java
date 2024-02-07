package com.cashion.dog.dogservices.restservice.breed.mapper;

import com.cashion.dog.dogservices.persistence.domain.PhysicalNeeds;
import com.cashion.dog.dogservices.restservice.breed.request.PhysicalNeedsRequest;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PhysicalNeedsMapper {

    public PhysicalNeeds mapResourceToDomain(PhysicalNeedsRequest request) {
        if (request == null) {
            return null;
        }

        PhysicalNeeds domain = new PhysicalNeeds();
        domain.setEnergyLevel(request.getEnergyLevel());
        domain.setIntensity(request.getIntensity());
        domain.setExerciseNeeds(request.getExerciseNeeds());
        domain.setPotentialForPlayfulness(request.getPotentialForPlayfulness());
        domain.setCreateDate(new Date());

        return domain;
    }
}

package com.cashion.dog.dogservices.restservice.breed.mapper;

import com.cashion.dog.dogservices.persistence.domain.Trainability;
import com.cashion.dog.dogservices.restservice.breed.resource.TrainabilityResource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TrainabilityMapper {

    public Trainability mapResourceToDomain(TrainabilityResource resource) {
        if (resource == null) {
            return null;
        }

        Trainability domain = new Trainability();
        domain.setEasyToTrain(resource.getEasyToTrain());
        domain.setIntelligence(resource.getIntelligence());
        domain.setPotentialForMouthiness(resource.getPotentialForMouthiness());
        domain.setPreyDrive(resource.getPreyDrive());
        domain.setTendencyToBarkOrHowl(resource.getTendencyToBarkOrHowl());
        domain.setWanderlustPotential(resource.getWanderlustPotential());
        domain.setCreateDate(new Date());

        return domain;
    }
}

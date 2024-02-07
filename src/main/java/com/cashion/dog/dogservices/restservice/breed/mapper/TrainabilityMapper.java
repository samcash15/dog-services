package com.cashion.dog.dogservices.restservice.breed.mapper;

import com.cashion.dog.dogservices.persistence.domain.Trainability;
import com.cashion.dog.dogservices.restservice.breed.request.TrainabilityRequest;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TrainabilityMapper {

    public Trainability mapResourceToDomain(TrainabilityRequest request) {
        if (request == null) {
            return null;
        }

        Trainability domain = new Trainability();
        domain.setEasyToTrain(request.getEasyToTrain());
        domain.setIntelligence(request.getIntelligence());
        domain.setPotentialForMouthiness(request.getPotentialForMouthiness());
        domain.setPreyDrive(request.getPreyDrive());
        domain.setTendencyToBarkOrHowl(request.getTendencyToBarkOrHowl());
        domain.setWanderlustPotential(request.getWanderlustPotential());
        domain.setCreateDate(new Date());

        return domain;
    }
}

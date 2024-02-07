package com.cashion.dog.dogservices.restservice.breed.mapper;

import com.cashion.dog.dogservices.persistence.domain.HealthAndGroomingNeeds;
import com.cashion.dog.dogservices.restservice.breed.request.HealthAndGroomingNeedsRequest;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HealthAndGroomingNeedsMapper {

    public HealthAndGroomingNeeds mapResourceToDomain(HealthAndGroomingNeedsRequest request) {
        if (request == null) {
            return null;
        }

        HealthAndGroomingNeeds domain = new HealthAndGroomingNeeds();
        domain.setAmountOfShedding(request.getAmountOfShedding());
        domain.setDroolingPotential(request.getDroolingPotential());
        domain.setEasyToGroom(request.getEasyToGroom());
        domain.setGeneralHealth(request.getGeneralHealth());
        domain.setPotentialForWeightGain(request.getPotentialForWeightGain());
        domain.setSize(request.getSize());
        domain.setCreateDate(new Date());

        return domain;
    }

}

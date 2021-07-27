package com.cashion.dog.dogservices.restservice.breed.mapper;

import com.cashion.dog.dogservices.persistence.domain.HealthAndGroomingNeeds;
import com.cashion.dog.dogservices.restservice.breed.resource.HealthAndGroomingNeedsResource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HealthAndGroomingNeedsMapper {

    public HealthAndGroomingNeeds mapResourceToDomain(HealthAndGroomingNeedsResource resource) {
        if (resource == null) {
            return null;
        }

        HealthAndGroomingNeeds domain = new HealthAndGroomingNeeds();
        domain.setAmountOfShedding(resource.getAmountOfShedding());
        domain.setDroolingPotential(resource.getDroolingPotential());
        domain.setEasyToGroom(resource.getEasyToGroom());
        domain.setGeneralHealth(resource.getGeneralHealth());
        domain.setPotentialForWeightGain(resource.getPotentialForWeightGain());
        domain.setSize(resource.getSize());
        domain.setCreateDate(new Date());

        return domain;
    }

}

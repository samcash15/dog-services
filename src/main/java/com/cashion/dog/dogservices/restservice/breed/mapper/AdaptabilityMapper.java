package com.cashion.dog.dogservices.restservice.breed.mapper;

import com.cashion.dog.dogservices.persistence.domain.Adaptability;
import com.cashion.dog.dogservices.restservice.breed.resource.AdaptabilityResource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AdaptabilityMapper {

    public Adaptability mapResourceToDomain(AdaptabilityResource resource) {
        if (resource == null) {
            return null;
        }

        Adaptability domain = new Adaptability();
        domain.setAdaptsWellToApartmentLiving(resource.getAdaptsWellToApartmentLiving());
        domain.setGoodForNoviceOwners(resource.getGoodForNoviceOwners());
        domain.setSensitivityLevel(resource.getSensitivityLevel());
        domain.setToleratesBeingAlone(resource.getToleratesBeingAlone());
        domain.setToleratesColdWeather(resource.getToleratesColdWeather());
        domain.setToleratesHotWeather(resource.getToleratesHotWeather());
        domain.setCreateDate(new Date());

        return domain;
    }
}

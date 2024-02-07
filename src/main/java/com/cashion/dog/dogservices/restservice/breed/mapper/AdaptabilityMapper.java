package com.cashion.dog.dogservices.restservice.breed.mapper;

import com.cashion.dog.dogservices.persistence.domain.Adaptability;
import com.cashion.dog.dogservices.restservice.breed.request.AdaptabilityRequest;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AdaptabilityMapper {

    public Adaptability mapResourceToDomain(AdaptabilityRequest request) {
        if (request == null) {
            return null;
        }

        Adaptability domain = new Adaptability();
        domain.setAdaptsWellToApartmentLiving(request.getAdaptsWellToApartmentLiving());
        domain.setGoodForNoviceOwners(request.getGoodForNoviceOwners());
        domain.setSensitivityLevel(request.getSensitivityLevel());
        domain.setToleratesBeingAlone(request.getToleratesBeingAlone());
        domain.setToleratesColdWeather(request.getToleratesColdWeather());
        domain.setToleratesHotWeather(request.getToleratesHotWeather());
        domain.setCreateDate(new Date());

        return domain;
    }
}

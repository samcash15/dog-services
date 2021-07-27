package com.cashion.dog.dogservices.restservice.breed.mapper;

import com.cashion.dog.dogservices.persistence.domain.Friendliness;
import com.cashion.dog.dogservices.restservice.breed.resource.FriendlinessResource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class FriendlinessMapper {

    public Friendliness mapResourceToDomain(FriendlinessResource resource) {
        if (resource == null) {
            return null;
        }

        Friendliness domain = new Friendliness();
        domain.setAffectionateWithFamily(resource.getAffectionateWithFamily());
        domain.setKidFriendly(resource.getKidFriendly());
        domain.setDogFriendly(resource.getDogFriendly());
        domain.setFriendlyTowardStrangers(resource.getFriendlyTowardStrangers());
        domain.setCreateDate(new Date());

        return domain;
    }
}

package com.cashion.dog.dogservices.restservice.breed.mapper;

import com.cashion.dog.dogservices.persistence.domain.Friendliness;
import com.cashion.dog.dogservices.restservice.breed.request.FriendlinessRequest;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class FriendlinessMapper {

    public Friendliness mapResourceToDomain(FriendlinessRequest request) {
        if (request == null) {
            return null;
        }

        Friendliness domain = new Friendliness();
        domain.setAffectionateWithFamily(request.getAffectionateWithFamily());
        domain.setKidFriendly(request.getKidFriendly());
        domain.setDogFriendly(request.getDogFriendly());
        domain.setFriendlyTowardStrangers(request.getFriendlyTowardStrangers());
        domain.setCreateDate(new Date());

        return domain;
    }
}

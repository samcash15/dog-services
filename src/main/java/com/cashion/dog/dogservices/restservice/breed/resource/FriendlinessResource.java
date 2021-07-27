package com.cashion.dog.dogservices.restservice.breed.resource;

import lombok.Data;

import javax.validation.constraints.Max;
import java.io.Serializable;

@Data
public class FriendlinessResource implements Serializable {
    @Max(value = 5)
    private Long affectionateWithFamily;

    @Max(value = 5)
    private Long kidFriendly;

    @Max(value = 5)
    private Long dogFriendly;

    @Max(value = 5)
    private Long friendlyTowardStrangers;
}

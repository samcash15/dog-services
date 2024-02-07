package com.cashion.dog.dogservices.restservice.breed.request;

import jakarta.validation.constraints.Max;
import java.io.Serializable;
import lombok.Data;

@Data
public class FriendlinessRequest implements Serializable {
    @Max(value = 5)
    private Long affectionateWithFamily;

    @Max(value = 5)
    private Long kidFriendly;

    @Max(value = 5)
    private Long dogFriendly;

    @Max(value = 5)
    private Long friendlyTowardStrangers;
}

package com.cashion.dog.dogservices.restservice.breed.response;

import java.util.Date;
import lombok.Data;

@Data
public class DogBreedResponse {
    private String breed;
    private String approximateWeight;
    private String size;
    private Long adaptabilityRating;
    private Long friendlinessRating;
    private Long groomRating;
    private Long trainRating;
    private Long physicalNeedRating;
    private Date createDate;
    private Date updateDate;
}

package com.cashion.dog.dogservices.persistence.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "HEALTH_AND_GROOMING_NEEDS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class HealthAndGroomingNeeds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOG_ID")
    private DogBreed dogId;

    @Max(value = 5)
    @Column(name = "AMOUNT_OF_SHEDDING")
    private Long amountOfShedding;

    @Max(value = 5)
    @Column(name = "DROOLING_POTENTIAL")
    private Long droolingPotential;

    @Max(value = 5)
    @Column(name = "EASY_TO_GROOM")
    private Long easyToGroom;

    @Max(value = 5)
    @Column(name = "GENERAL_HEALTH")
    private Long generalHealth;

    @Max(value = 5)
    @Column(name = "POTENTIAL_FOR_WEIGHT_GAIN")
    private Long potentialForWeightGain;

    @Max(value = 5)
    @Column(name = "SIZE")
    private Long size;

    @Column(name = "CREATE_DATE")
    private Date createDate;
}

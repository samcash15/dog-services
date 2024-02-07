package com.cashion.dog.dogservices.persistence.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import java.util.Date;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "HEALTH_AND_GROOMING_NEEDS")
@Inheritance(strategy = InheritanceType.JOINED)
public class HealthAndGroomingNeeds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOG_ID")
    private DogBreed dogBreed;

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

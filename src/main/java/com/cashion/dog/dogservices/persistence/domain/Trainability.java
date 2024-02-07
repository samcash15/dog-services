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
@Table(name = "TRAINABILITY")
@Inheritance(strategy = InheritanceType.JOINED)
public class Trainability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOG_ID", referencedColumnName = "DOG_ID")
    private DogBreed dogBreed;

    @Max(value = 5)
    @Column(name = "EASY_TO_TRAIN")
    private Long easyToTrain;

    @Max(value = 5)
    @Column(name = "INTELLIGENCE")
    private Long intelligence;

    @Max(value = 5)
    @Column(name = "POTENTIAL_FOR_MOUTHINESS")
    private Long potentialForMouthiness;

    @Max(value = 5)
    @Column(name = "PREY_DRIVE")
    private Long preyDrive;

    @Max(value = 5)
    @Column(name = "TENDENCY_TO_BARK_OR_HOWL")
    private Long tendencyToBarkOrHowl;

    @Max(value = 5)
    @Column(name = "WANDERLUST_POTENTIAL")
    private Long wanderlustPotential;

    @Column(name = "CREATE_DATE")
    private Date createDate;
}


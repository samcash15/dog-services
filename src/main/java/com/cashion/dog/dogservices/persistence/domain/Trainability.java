package com.cashion.dog.dogservices.persistence.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TRAINABILITY")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Trainability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOG_ID")
    private DogBreed dogId;

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

package com.cashion.dog.dogservices.persistence.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PHYSICAL_NEEDS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PhysicalNeeds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOG_ID")
    private DogBreed dogId;

    @Max(value = 5)
    @Column(name = "ENERGY_LEVEL")
    private Long energyLevel;

    @Max(value = 5)
    @Column(name = "INTENSITY")
    private Long intensity;

    @Max(value = 5)
    @Column(name = "EXERCISE_NEEDS")
    private Long exerciseNeeds;

    @Max(value = 5)
    @Column(name = "POTENTIAL_FOR_PLAYFULNESS")
    private Long potentialForPlayfulness;

    @Column(name = "CREATE_DATE")
    private Date createDate;
}

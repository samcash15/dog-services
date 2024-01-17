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

package com.cashion.dog.dogservices.persistence.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ADAPTABILITY")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Adaptability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOG_ID")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private DogBreed dogId;

    @Max(value = 5)
    @Column(name = "ADPTS_WELL_TO_APRTMNT_LVNG")
    private Long adaptsWellToApartmentLiving;

    @Max(value = 5)
    @Column(name = "GOOD_FOR_NOVICE_OWNRS")
    private Long goodForNoviceOwners;

    @Max(value = 5)
    @Column(name = "SENSITIVITY_LVL")
    private Long sensitivityLevel;

    @Max(value = 5)
    @Column(name = "TOL_BEING_ALONE")
    private Long toleratesBeingAlone;

    @Max(value = 5)
    @Column(name = "TOL_COLD_WEATHER")
    private Long toleratesColdWeather;

    @Max(value = 5)
    @Column(name = "TOL_HOT_WEATHER")
    private Long toleratesHotWeather;

    @Column(name = "CREATE_DATE")
    private Date createDate;

}

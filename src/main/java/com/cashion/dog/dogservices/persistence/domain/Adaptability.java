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
@Table(name = "ADAPTABILITY")
@Inheritance(strategy = InheritanceType.JOINED)
public class Adaptability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOG_ID", referencedColumnName = "DOG_ID")
    private DogBreed dogBreed;

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

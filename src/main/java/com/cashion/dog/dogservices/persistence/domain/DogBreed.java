package com.cashion.dog.dogservices.persistence.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
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
@Table(name = "DOG_BREED")
@Inheritance(strategy = InheritanceType.JOINED)
public class DogBreed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DOG_ID", nullable = false, updatable = false)
    private Long dogId;

    @Size(max = 50)
    @Column(name = "BREED", nullable = false)
    private String breed;

    @Size(max = 15)
    @Column(name = "APPROX_WEIGHT", nullable = false)
    private String approximateWeight;

    @Size(max = 10)
    @Column(name = "SIZE", nullable = false)
    private String size;

    @Max(value = 5)
    @Column(name = "ADAPT_RATING")
    private Long adaptabilityRating;

    @Max(value = 5)
    @Column(name = "FRIENDLINESS_RATING")
    private Long friendlinessRating;

    @Max(value = 5)
    @Column(name = "GROOM_RATING")
    private Long groomRating;

    @Max(value = 5)
    @Column(name = "TRAIN_RATING")
    private Long trainRating;

    @Max(value = 5)
    @Column(name = "PHYS_NEED_RATING")
    private Long physicalNeedRating;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "UPDATE_DATE")
    private Date updateDate;

//    @OneToOne(mappedBy = "dogBreed", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Adaptability adaptability;
//
//    @OneToOne(mappedBy = "dogBreed", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Friendliness friendliness;
//
//    @OneToOne(mappedBy = "dogBreed", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private HealthAndGroomingNeeds healthAndGroomingNeeds;
//
//    @OneToOne(mappedBy = "dogBreed", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private PhysicalNeeds physicalNeeds;
//
//    @OneToOne(mappedBy = "dogBreed", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Trainability trainability;

}

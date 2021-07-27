package com.cashion.dog.dogservices.persistence.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "DOG_BREED")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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

    @OneToOne(mappedBy = "dogId", cascade = CascadeType.ALL)
    private Adaptability adaptability;

    @OneToOne(mappedBy = "dogId", cascade = CascadeType.ALL)
    private Friendliness friendliness;

    @OneToOne(mappedBy = "dogId", cascade = CascadeType.ALL)
    private HealthAndGroomingNeeds healthAndGroomingNeeds;

    @OneToOne(mappedBy = "dogId", cascade = CascadeType.ALL)
    private PhysicalNeeds physicalNeeds;

    @OneToOne(mappedBy = "dogId", cascade = CascadeType.ALL)
    private Trainability trainability;

}

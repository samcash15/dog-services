package com.cashion.dog.dogservices.persistence.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "FRIENDLINESS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Friendliness {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOG_ID")
    private DogBreed dogId;

    @Max(value = 5)
    @Column(name = "AFFECTIONATE_WITH_FAM")
    private Long affectionateWithFamily;

    @Max(value = 5)
    @Column(name = "KID_FRIENDLY")
    private Long kidFriendly;

    @Max(value = 5)
    @Column(name = "DOG_FRIENDLY")
    private Long dogFriendly;

    @Max(value = 5)
    @Column(name = "FRIENDLY_TOWARD_STRANGERS")
    private Long friendlyTowardStrangers;

    @Column(name = "CREATE_DATE")
    private Date createDate;
}

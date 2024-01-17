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

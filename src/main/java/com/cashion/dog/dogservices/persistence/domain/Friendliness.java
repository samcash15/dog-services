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
@Table(name = "FRIENDLINESS")
@Inheritance(strategy = InheritanceType.JOINED)
public class Friendliness {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOG_ID", referencedColumnName = "DOG_ID")
    private DogBreed dogBreed;

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

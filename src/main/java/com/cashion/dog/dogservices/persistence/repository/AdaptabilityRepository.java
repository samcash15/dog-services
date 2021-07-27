package com.cashion.dog.dogservices.persistence.repository;

import com.cashion.dog.dogservices.persistence.domain.Adaptability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdaptabilityRepository extends JpaRepository<Adaptability, Long> {

}

package com.cashion.dog.dogservices.persistence.repository;

import com.cashion.dog.dogservices.persistence.domain.Trainability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainabilityRepository extends JpaRepository<Trainability, Long> {
}

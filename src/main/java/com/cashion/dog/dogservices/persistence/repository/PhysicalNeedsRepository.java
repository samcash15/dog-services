package com.cashion.dog.dogservices.persistence.repository;

import com.cashion.dog.dogservices.persistence.domain.PhysicalNeeds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysicalNeedsRepository extends JpaRepository<PhysicalNeeds, Long> {
}

package com.cashion.dog.dogservices.persistence.repository;

import com.cashion.dog.dogservices.persistence.domain.HealthAndGroomingNeeds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthAndGroomingNeedsRepository extends JpaRepository<HealthAndGroomingNeeds, Long> {
}

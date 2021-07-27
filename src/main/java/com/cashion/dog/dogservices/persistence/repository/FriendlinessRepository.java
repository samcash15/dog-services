package com.cashion.dog.dogservices.persistence.repository;

import com.cashion.dog.dogservices.persistence.domain.Friendliness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendlinessRepository extends JpaRepository<Friendliness, Long> {
}

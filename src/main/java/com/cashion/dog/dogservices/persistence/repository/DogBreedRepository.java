package com.cashion.dog.dogservices.persistence.repository;


import com.cashion.dog.dogservices.persistence.domain.DogBreed;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DogBreedRepository extends JpaRepository<DogBreed, Long> {

    DogBreed findByBreed(String breed);

    @Query("select d.breed from DogBreed d")
    List<String> getAllBreeds();

    boolean existsByBreed(String breed);
}

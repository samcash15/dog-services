package com.cashion.dog.dogservices;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DogServicesApplicationTests {

	@PersistenceContext
	private EntityManager entityManager;

	@Test
	void contextLoads() {
	}

}

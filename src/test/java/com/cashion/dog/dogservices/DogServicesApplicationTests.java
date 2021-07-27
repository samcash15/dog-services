package com.cashion.dog.dogservices;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
class DogServicesApplicationTests {

	@PersistenceContext
	private EntityManager entityManager;

	@Test
	void contextLoads() {
	}

}

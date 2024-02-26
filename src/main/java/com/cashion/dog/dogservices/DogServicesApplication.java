package com.cashion.dog.dogservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
        SecurityAutoConfiguration.class,
        UserDetailsServiceAutoConfiguration.class})
@EntityScan("com.cashion.dog.dogservices.persistence.domain")
@EnableJpaRepositories(value = "com.cashion.dog.dogservices.persistence.repository")
@EnableAutoConfiguration
public class DogServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(DogServicesApplication.class, args);

    }

}

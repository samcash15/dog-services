package com.cashion.dog.dogservices.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.jdbc.username}")
    private String username;

    @Value("${spring.datasource.jdbc.password}")
    private String password;

    @Value("${spring.datasource.jdbc.url}")
    private String url;

    @Bean
    public DataSource buildDataSource() {
        return DataSourceBuilder.create()
                .url(url)
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .username(username)
                .password(password)
                .build();
    }
}

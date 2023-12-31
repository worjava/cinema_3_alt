package com.kata.cinema.base.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan({"com.kata.cinema.base"})
@EntityScan(basePackages = {"com.kata.cinema.base.models", "com.kata.cinema.base.security.token"})
@EnableCaching
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.kata.cinema.base"})
public class CinemaBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaBaseApplication.class, args);
    }
}
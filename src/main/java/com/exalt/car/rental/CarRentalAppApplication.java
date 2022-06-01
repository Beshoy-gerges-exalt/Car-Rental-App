package com.exalt.car.rental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableJpaRepositories("com.exalt.car.rental.repository.sql")
public class CarRentalAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarRentalAppApplication.class, args);
    }

}

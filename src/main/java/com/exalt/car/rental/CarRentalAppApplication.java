package com.exalt.car.rental;

import com.exalt.car.rental.repository.es.CarEsRepository;
import com.exalt.car.rental.repository.es.CustomerEsRepository;
import com.exalt.car.rental.repository.sql.CarRepository;
import com.exalt.car.rental.repository.sql.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@RequiredArgsConstructor
@EnableScheduling
@SpringBootApplication
@EnableJpaRepositories("com.exalt.car.rental.repository.sql")
public class CarRentalAppApplication implements CommandLineRunner {

    private final CarRepository carRepository;
    private final CarEsRepository carEsRepository;
    private final CustomerRepository customerRepository;
    private final CustomerEsRepository customerEsRepository;

    public static void main(String[] args) {
        SpringApplication.run(CarRentalAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        syncCarData();

        syncCustomerData();
    }

    private void syncCustomerData() {
        log.info("start syncing customers data");
        customerEsRepository.saveAll(customerRepository.findAll());
        log.info("finish syncing customers data");
    }

    private void syncCarData() {
        log.info("start syncing cars data");
        carEsRepository.saveAll(carRepository.findAll());
        log.info("finish syncing cars data");
    }
}

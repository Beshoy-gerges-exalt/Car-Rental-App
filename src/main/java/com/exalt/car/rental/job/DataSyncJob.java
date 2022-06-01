package com.exalt.car.rental.job;

import com.exalt.car.rental.aop.LogElapsedTime;
import com.exalt.car.rental.model.Car;
import com.exalt.car.rental.repository.es.CarEsRepository;
import com.exalt.car.rental.repository.sql.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class DataSyncJob {

    private final CarRepository carRepository;
    private final CarEsRepository carEsRepository;

    @Scheduled(cron = "0 */2 * * * *")
    @Transactional
    @LogElapsedTime
    public void sync() {
        syncCars();
    }

    private void syncCars() {

        List<Car> carList;

        if (carEsRepository.count() == 0) {
            carList = carRepository.findAll();
        } else {
            carList = carRepository.findAllByUpdatedAtBetween(LocalDateTime.now(), LocalDateTime.now().minusMinutes(3));
        }

        carEsRepository.saveAll(carList);

    }
}

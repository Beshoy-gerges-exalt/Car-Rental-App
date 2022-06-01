package com.exalt.car.rental.repository.sql;

import com.exalt.car.rental.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Override
    Optional<Car> findById(Integer integer);

    List<Car> findAllByRentEndDate(LocalDate localDate);

    List<Car> findAllByUpdatedAtBetween(LocalDateTime start, LocalDateTime end);
}

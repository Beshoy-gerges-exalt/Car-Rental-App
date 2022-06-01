package com.exalt.car.rental.repository.es;

import com.exalt.car.rental.model.Car;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDate;
import java.util.List;

public interface CarEsRepository extends ElasticsearchRepository<Car, Integer> {
    List<Car> findAllByRentEndDate(LocalDate localDate);
}

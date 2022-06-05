package com.exalt.car.rental.repository.es;

import com.exalt.car.rental.model.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerEsRepository extends ElasticsearchRepository<Customer, Integer> {
    List<Customer> findAllByNameContainingIgnoreCase(String name);

    Optional<Customer> findByEmail(String email);
}

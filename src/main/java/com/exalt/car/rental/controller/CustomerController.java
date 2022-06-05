package com.exalt.car.rental.controller;

import com.exalt.car.rental.dto.CustomerDto;
import com.exalt.car.rental.repository.es.CustomerEsRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerEsRepository customerEsRepository;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<CustomerDto> findCustomerByName(@RequestParam String name) {
        return customerEsRepository.findAllByNameContainingIgnoreCase(name)
                .stream()
                .map(customer -> modelMapper.map(customer, CustomerDto.class))
                .collect(Collectors.toList());
    }
}

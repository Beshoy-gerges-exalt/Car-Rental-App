package com.exalt.car.rental.service.impl;

import com.exalt.car.rental.aop.LogElapsedTime;
import com.exalt.car.rental.dto.CarDto;
import com.exalt.car.rental.dto.RentCarRequest;
import com.exalt.car.rental.model.Car;
import com.exalt.car.rental.model.Customer;
import com.exalt.car.rental.repository.es.CarEsRepository;
import com.exalt.car.rental.repository.es.CustomerEsRepository;
import com.exalt.car.rental.repository.sql.CarRepository;
import com.exalt.car.rental.repository.sql.CustomerRepository;
import com.exalt.car.rental.service.CarService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarEsRepository carEsRepository;
    private final CustomerRepository customerRepository;

    private final CustomerEsRepository customerEsRepository;
    private final ModelMapper modelMapper;

    @LogElapsedTime
    @Transactional
    @Override
    public CarDto rentCar(final RentCarRequest request, Authentication authentication) {
        Car car = carRepository.findById(request.getCarId()).orElseThrow(() -> new RuntimeException("Car not exist"));

        if (Objects.nonNull(car.getRentEndDate())
                && (car.getRentEndDate().isEqual(LocalDate.now())
                || car.getRentEndDate().isAfter(LocalDate.now())))
            throw new RuntimeException("Car is already rented");

        if (request.getRentEndDate().isBefore(LocalDate.now()))
            throw new RuntimeException("Rent end date should be today or any future date");

        Customer customer = getLoggedInCustomer(authentication);

        car.setCustomer(customer);

        car.setRentEndDate(request.getRentEndDate());

        carRepository.save(car);

        carEsRepository.save(car);

        if (customerEsRepository.findByEmail(customer.getEmail()).isPresent())
            customerEsRepository.save(customer);

        return modelMapper.map(car, CarDto.class);
    }

    private Customer getLoggedInCustomer(Authentication authentication) {
        if (!(authentication.getPrincipal() instanceof Jwt))
            throw new RuntimeException("Can't get user data");
        Jwt jwt = (Jwt) authentication.getPrincipal();
        String email = (String) jwt.getClaims().get("email");
        return customerRepository.findByEmail(email).orElseGet(() -> {
            Customer cutomer = new Customer();
            cutomer.setEmail(email);
            cutomer.setName((String) jwt.getClaims().get("name"));
            return customerRepository.save(cutomer);
        });

    }

    @LogElapsedTime
    @Override
    public List<CarDto> getAvailableCars() {
        return carEsRepository.findAllByRentEndDate(null).stream().map(car -> modelMapper.map(car, CarDto.class)).collect(Collectors.toList());
    }
}

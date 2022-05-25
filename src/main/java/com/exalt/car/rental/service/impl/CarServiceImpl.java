package com.exalt.car.rental.service.impl;

import com.exalt.car.rental.aop.LogElapsedTime;
import com.exalt.car.rental.dto.CarDto;
import com.exalt.car.rental.dto.RentCarRequest;
import com.exalt.car.rental.model.Car;
import com.exalt.car.rental.repository.CarRepository;
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

        car.setCustomerName(getLoggedInUsername(authentication));

        car.setRentEndDate(request.getRentEndDate());

        carRepository.save(car);

        return modelMapper.map(car, CarDto.class);
    }

    private String getLoggedInUsername(Authentication authentication) {
        if (!(authentication.getPrincipal() instanceof Jwt))
            throw new RuntimeException("Can't get user data");
        Jwt jwt = (Jwt) authentication.getPrincipal();
        return (String) jwt.getClaims().get("email");
    }

    @LogElapsedTime
    @Override
    public List<CarDto> getAvailableCars() {
        return carRepository.findAllByRentEndDate(null).stream().map(car -> modelMapper.map(car, CarDto.class)).collect(Collectors.toList());
    }
}

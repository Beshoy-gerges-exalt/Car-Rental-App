package com.exalt.car.rental.service;

import com.exalt.car.rental.dto.CarDto;
import com.exalt.car.rental.dto.RentCarRequest;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface CarService {

    CarDto rentCar(RentCarRequest request, Authentication authentication);

    List<CarDto> getAvailableCars();
}

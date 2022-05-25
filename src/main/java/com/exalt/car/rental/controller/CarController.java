package com.exalt.car.rental.controller;

import com.exalt.car.rental.dto.CarDto;
import com.exalt.car.rental.dto.RentCarRequest;
import com.exalt.car.rental.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    private final CarService carService;

    @GetMapping
    public List<CarDto> getAvailableCars(Authentication authentication) {
        return carService.getAvailableCars();
    }

    @PostMapping("/rent")
    public CarDto rentCar(@Valid @RequestBody final RentCarRequest request, Authentication authentication) {
        return carService.rentCar(request, authentication);
    }
}

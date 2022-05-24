package com.exalt.car.rental.controller;

import com.exalt.car.rental.dto.CarDto;
import com.exalt.car.rental.dto.RentCarRequest;
import com.exalt.car.rental.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    private final CarService carService;

    @GetMapping
    public List<CarDto> getAvailableCars() {
        return carService.getAvailableCars();
    }

    @PostMapping("/rent")
    public CarDto rentCar(@Valid @RequestBody final RentCarRequest request) {
        return carService.rentCar(request);
    }
}

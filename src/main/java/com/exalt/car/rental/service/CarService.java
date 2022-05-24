package com.exalt.car.rental.service;

import com.exalt.car.rental.dto.CarDto;
import com.exalt.car.rental.dto.RentCarRequest;

import java.util.List;

public interface CarService {

    CarDto rentCar(RentCarRequest request);

    List<CarDto> getAvailableCars();
}

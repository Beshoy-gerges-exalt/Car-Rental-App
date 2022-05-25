package com.exalt.car.rental.endpoint;

import com.exalt.car.rental.dto.CarDto;
import com.exalt.car.rental.service.CarService;
import com.exalt.car.rental.util.DateUtil;
import com.exalt.car.rental.xml.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Endpoint
public class CarEndpoint {

    private static final String NAMESPACE_URI = "http://www.rental.car.exalt.com/xml";
    private final CarService carService;
    private final ModelMapper modelMapper;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RentCarRequest")
    @ResponsePayload
    public RentCarResponse rentCar(@RequestPayload RentCarRequest request) throws DatatypeConfigurationException {
        RentCarResponse response = new RentCarResponse();

        CarDto carDto = carService.rentCar(com.exalt.car.rental.dto.RentCarRequest.builder()
                .carId(request.getCarId())
                .rentEndDate(DateUtil.convert(request.getRentEndDate())).build(), SecurityContextHolder.getContext().getAuthentication());

        response.setId(carDto.getId());
        response.setCustomerName(carDto.getCustomerName());
        response.setRentEndDate(DateUtil.convert(carDto.getRentEndDate()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAvailableCarsRequest")
    @ResponsePayload
    public GetAvailableCarsResponse getAvailableCars(@RequestPayload GetAvailableCarsRequest request) {
        GetAvailableCarsResponse response = new GetAvailableCarsResponse();

        List<Car> cars = carService.getAvailableCars().stream().map(carDto -> modelMapper.map(carDto, Car.class)).collect(Collectors.toList());

        response.setCar(cars);

        return response;
    }
}

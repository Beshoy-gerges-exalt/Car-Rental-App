package com.exalt.car.rental.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CarDto {
    private Integer id;
    private String name;
    private String customerName;
    private LocalDate rentEndDate;
}

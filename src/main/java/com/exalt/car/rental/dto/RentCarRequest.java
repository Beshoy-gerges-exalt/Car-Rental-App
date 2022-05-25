package com.exalt.car.rental.dto;

import lombok.*;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentCarRequest {
    @NotNull
    private Integer carId;
    @FutureOrPresent
    @NotNull
    private LocalDate rentEndDate;
}

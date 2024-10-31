package com.mitigia.server.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MileageRequestDTO {
    private String licencePlate;
    private LocalDate date;
    private Integer mileage;
}

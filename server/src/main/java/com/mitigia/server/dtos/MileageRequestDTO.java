package com.mitigia.server.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MileageRequestDTO {
    @JsonAlias("licence_plate")
    @NotBlank(message = "Licence plate is required!")
    private String licencePlate;

    @JsonAlias("date")
    @NotNull(message = "Date is required!")
    private LocalDate date;

    @JsonAlias("mileage")
    @NotNull(message = "Mileage is required!")
    private Integer mileage;
}

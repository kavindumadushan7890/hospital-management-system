package com.example.hospital_management_system.pharmacy.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateManufacturerRequest {

    @NotBlank(message = "Manufacturer name cannot be empty")
    private String name;

    @NotBlank(message = "Registration number cannot be empty")
    private String registrationNumber;

    @NotBlank(message = "Country of origin cannot be empty")
    private String countryOfOrigin;

}

package com.example.hospital_management_system.doctor.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateProfessionalDetailsRequest {

    @NotBlank(message = "First name cannot be empty")
    private String licenseNumber;

    @NotNull(message = "Experience years cannot be empty")
    private Integer experienceYears;

}

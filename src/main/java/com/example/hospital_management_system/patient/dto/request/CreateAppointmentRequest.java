package com.example.hospital_management_system.patient.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateAppointmentRequest {

    @NotNull(message = "Doctor id is required")
    private Long doctorId;

    @NotNull(message = "Doctor id is required")
    private Long patientId;

    @NotNull(message = "Doctor id is required")
    private Long slotId;

}

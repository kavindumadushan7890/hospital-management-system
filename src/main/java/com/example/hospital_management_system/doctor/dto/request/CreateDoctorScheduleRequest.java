package com.example.hospital_management_system.doctor.dto.request;

import com.example.hospital_management_system.doctor.model.DoctorAvailable;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateDoctorScheduleRequest {

    @NotNull(message = "Day of week required")
    private DayOfWeek dayOfWeek;

    @NotNull(message = "Start time is required")
    private LocalTime startTime;

    @NotNull(message = "End time is required")
    private LocalTime endTime;

    private Integer slotDuration;
    private DoctorAvailable doctorAvailable;

}

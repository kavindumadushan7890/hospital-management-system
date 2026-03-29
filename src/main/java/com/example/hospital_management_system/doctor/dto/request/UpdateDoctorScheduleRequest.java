package com.example.hospital_management_system.doctor.dto.request;

import com.example.hospital_management_system.doctor.model.DoctorAvailable;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UpdateDoctorScheduleRequest {

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer slotDuration;
    private DoctorAvailable doctorAvailable;

}

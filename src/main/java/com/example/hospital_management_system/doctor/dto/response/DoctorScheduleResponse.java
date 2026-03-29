package com.example.hospital_management_system.doctor.dto.response;

import com.example.hospital_management_system.doctor.model.DoctorAvailable;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
@Builder
public class DoctorScheduleResponse {

    private String fullName;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer slotDuration;
    private DoctorAvailable doctorAvailable;

}

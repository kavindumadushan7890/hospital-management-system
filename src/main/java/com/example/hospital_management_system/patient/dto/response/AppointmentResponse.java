package com.example.hospital_management_system.patient.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@Data
public class AppointmentResponse {

    private String patientName;
    private String doctorName;
    private LocalDate date;
    private LocalTime time;

}

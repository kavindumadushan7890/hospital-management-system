package com.example.hospital_management_system.patient.dto.response;

import com.example.hospital_management_system.doctor.model.Gender;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PatientResponse {

    private String fullName;
    private Gender gender;
    private LocalDate dob;
    private String email;
    private String phone;
}

package com.example.hospital_management_system.doctor.dto.response;

import com.example.hospital_management_system.doctor.model.DoctorStatus;
import com.example.hospital_management_system.doctor.model.Gender;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DoctorResponse {

    private String fullName;
    private List<String> specialization;
    private Gender gender;
    private String email;
    private String phone;
    private DoctorStatus status;

}

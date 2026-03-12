package com.example.hospital_management_system.doctor.dto.request;

import com.example.hospital_management_system.doctor.model.DoctorStatus;
import com.example.hospital_management_system.doctor.model.Gender;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateDoctorRequest {

    @NotBlank(message = "First name cannot be empty")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    private String lastName;

    private Gender gender;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(
            regexp = "^(\\+94|0)?7[0-9]{8}",
            message = "Invalid Sri Lankan phone number"
    )
    private String phone;

    private DoctorStatus doctorStatus;

}

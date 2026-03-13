package com.example.hospital_management_system.patient.mapper;

import com.example.hospital_management_system.patient.dto.request.CreatePatientRequest;
import com.example.hospital_management_system.patient.dto.request.UpdatePatientDetailsRequest;
import com.example.hospital_management_system.patient.dto.response.PatientResponse;
import com.example.hospital_management_system.patient.model.Patient;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient toEntity(CreatePatientRequest request);

    default PatientResponse toResponse(Patient patient){
        return PatientResponse.builder()
                .fullName(patient.getFirstName() + " " + patient.getLastName())
                .gender(patient.getGender())
                .dob(patient.getDob())
                .email(patient.getEmail())
                .phone(patient.getPhone())
                .build();
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "firstName" , ignore = true)
    @Mapping(target = "lastName" , ignore = true)
    @Mapping(target = "gender" , ignore = true)
    @Mapping(target = "dob" , ignore = true)
    void updatePatient(UpdatePatientDetailsRequest request , @MappingTarget Patient patient);


}

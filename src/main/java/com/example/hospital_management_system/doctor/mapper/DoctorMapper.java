package com.example.hospital_management_system.doctor.mapper;

import com.example.hospital_management_system.doctor.dto.request.CreateDoctorRequest;
import com.example.hospital_management_system.doctor.dto.request.UpdateDoctorDetailsRequest;
import com.example.hospital_management_system.doctor.dto.response.DoctorResponse;
import com.example.hospital_management_system.doctor.model.Doctor;
import com.example.hospital_management_system.doctor.model.Specialization;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    Doctor toEntity(CreateDoctorRequest request);

    default DoctorResponse toResponse(Doctor doctor){
        return DoctorResponse.builder()
                .fullName(doctor.getFirstName() + " " + doctor.getLastName())
                .specialization(
                        doctor.getSpecializations()
                                .stream()
                                .map(Specialization::getName)
                                .toList()
                )
                .gender(doctor.getGender())
                .email(doctor.getEmail())
                .phone(doctor.getPhone())
                .status(doctor.getStatus())
                .build();
    }


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Mapping(target = "firstName" , ignore = true)
//    @Mapping(target = "lastName" , ignore = true)
//    @Mapping(target = "gender" , ignore = true)
    @Mapping(target = "specializations" , ignore = true)
    void updateDoctor(UpdateDoctorDetailsRequest request , @MappingTarget Doctor doctor);

}

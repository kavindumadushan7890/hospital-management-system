package com.example.hospital_management_system.doctor.mapper;

import com.example.hospital_management_system.doctor.dto.request.CreateProfessionalDetailsRequest;
import com.example.hospital_management_system.doctor.dto.response.ProfessionalDetailsResponse;
import com.example.hospital_management_system.doctor.model.ProfessionalDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel ="spring")
public interface ProfessionalDetailsMapper {

    ProfessionalDetails toEntity(CreateProfessionalDetailsRequest request);

    ProfessionalDetailsResponse toResponse(ProfessionalDetails professionalDetails);

}

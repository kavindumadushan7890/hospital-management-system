package com.example.hospital_management_system.doctor.mapper;

import com.example.hospital_management_system.doctor.dto.response.SpecializationResponse;
import org.mapstruct.Mapper;
import com.example.hospital_management_system.doctor.dto.request.CreateSpecializationRequest;
import com.example.hospital_management_system.doctor.model.Specialization;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SpecializationMapper {

    Specialization toEntity(CreateSpecializationRequest request);

    SpecializationResponse toResponse(Specialization specialization);

}

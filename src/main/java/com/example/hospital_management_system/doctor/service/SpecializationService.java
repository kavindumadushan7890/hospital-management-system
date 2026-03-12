package com.example.hospital_management_system.doctor.service;

import com.example.hospital_management_system.doctor.dto.request.CreateSpecializationRequest;
import com.example.hospital_management_system.doctor.dto.response.SpecializationResponse;

public interface SpecializationService {

    SpecializationResponse create(CreateSpecializationRequest request);

}

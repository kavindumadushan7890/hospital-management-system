package com.example.hospital_management_system.doctor.service;

import com.example.hospital_management_system.doctor.dto.request.CreateProfessionalDetailsRequest;
import com.example.hospital_management_system.doctor.exceptions.NotFoundException;
import com.example.hospital_management_system.doctor.model.ProfessionalDetails;

public interface ProfessionalDetailsService {

    void create(Long id , CreateProfessionalDetailsRequest request) throws NotFoundException;
}

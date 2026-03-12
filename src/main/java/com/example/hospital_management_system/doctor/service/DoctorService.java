package com.example.hospital_management_system.doctor.service;

import com.example.hospital_management_system.doctor.dto.request.CreateDoctorRequest;
import com.example.hospital_management_system.doctor.dto.request.UpdateDoctorDetailsRequest;
import com.example.hospital_management_system.doctor.dto.response.DoctorResponse;
import com.example.hospital_management_system.doctor.exceptions.NotFoundException;

import java.util.List;

public interface DoctorService {

    void create(Long id , CreateDoctorRequest request) throws NotFoundException;

    List<DoctorResponse> getAllDoctors();

    void updateDoctor(Long id , UpdateDoctorDetailsRequest request) throws NotFoundException;

    void delete(Long id) throws NotFoundException;

}

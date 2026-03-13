package com.example.hospital_management_system.patient.service;

import com.example.hospital_management_system.doctor.exceptions.NotFoundException;
import com.example.hospital_management_system.patient.dto.request.CreatePatientRequest;
import com.example.hospital_management_system.patient.dto.request.UpdatePatientDetailsRequest;
import com.example.hospital_management_system.patient.dto.response.PatientResponse;

import java.util.List;

public interface PatientService {

    void create(CreatePatientRequest request);

    List<PatientResponse>getAllPatient();

    void updatePatient(Long id , UpdatePatientDetailsRequest request) throws NotFoundException;

    void deleteById(Long id) throws NotFoundException;
}

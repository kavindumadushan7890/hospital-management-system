package com.example.hospital_management_system.patient.service.impl;

import com.example.hospital_management_system.doctor.exceptions.NotFoundException;
import com.example.hospital_management_system.patient.dto.request.CreatePatientRequest;
import com.example.hospital_management_system.patient.dto.request.UpdatePatientDetailsRequest;
import com.example.hospital_management_system.patient.dto.response.PatientResponse;
import com.example.hospital_management_system.patient.mapper.PatientMapper;
import com.example.hospital_management_system.patient.model.Patient;
import com.example.hospital_management_system.patient.repository.PatientRepository;
import com.example.hospital_management_system.patient.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientServiceImpl(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    @Override
    public void create(CreatePatientRequest request) {

        Patient entity = patientMapper.toEntity(request);
        Patient patient = patientRepository.save(entity);

    }

    @Override
    public List<PatientResponse>getAllPatient(){

        List<Patient>patientList = patientRepository.findAll();
        return patientList.stream()
                .map(patientMapper :: toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void updatePatient(Long id , UpdatePatientDetailsRequest request) throws NotFoundException{

        Patient patient = patientRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Not found patient given id")
        );

        patientMapper.updatePatient(request , patient);
        Patient updatePatient = patientRepository.save(patient);
    }

    @Override
    public void deleteById(Long id) throws NotFoundException{

        Patient patient = patientRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Not found patient give id")
        );
        patientRepository.deleteById(id);
    }
}

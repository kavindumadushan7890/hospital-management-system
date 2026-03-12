package com.example.hospital_management_system.doctor.service.impl;

import com.example.hospital_management_system.doctor.dto.request.CreateDoctorRequest;
import com.example.hospital_management_system.doctor.dto.request.UpdateDoctorDetailsRequest;
import com.example.hospital_management_system.doctor.dto.response.DoctorResponse;
import com.example.hospital_management_system.doctor.exceptions.NotFoundException;
import com.example.hospital_management_system.doctor.mapper.DoctorMapper;
import com.example.hospital_management_system.doctor.model.Doctor;
import com.example.hospital_management_system.doctor.model.DoctorStatus;
import com.example.hospital_management_system.doctor.model.Specialization;
import com.example.hospital_management_system.doctor.repository.DoctorRepository;
import com.example.hospital_management_system.doctor.repository.SpecializationRepository;
import com.example.hospital_management_system.doctor.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;
    private final SpecializationRepository specializationRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository , DoctorMapper doctorMapper , SpecializationRepository specializationRepository){
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
        this.specializationRepository = specializationRepository;
    }


    @Override
    public void create(Long id , CreateDoctorRequest request ) throws NotFoundException{

        Specialization specialization = specializationRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Not found specialization")
        );

        Doctor entity = doctorMapper.toEntity(request);
        entity.setSpecializations(Set.of(specialization));
        Doctor saved = doctorRepository.save(entity);
    }

    @Override
    public List<DoctorResponse> getAllDoctors() {

        List<Doctor>doctorList = doctorRepository.findAll();
        return doctorList.stream()
                .map(doctorMapper :: toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void updateDoctor(Long id , UpdateDoctorDetailsRequest request) throws NotFoundException{

        Doctor doctor = doctorRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Not found doctors by id")
        );

        doctorMapper.updateDoctor(request , doctor);
        Doctor updateDoctor= doctorRepository.save(doctor);

    }

    @Override
    public void delete(Long id) throws NotFoundException{

        Doctor doctor = doctorRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Not foud doctor by id")
        );

        doctor.setStatus(DoctorStatus.INACTIVE);
        doctorRepository.save(doctor);
    }

}

package com.example.hospital_management_system.doctor.service.impl;

import com.example.hospital_management_system.doctor.dto.request.CreateProfessionalDetailsRequest;
import com.example.hospital_management_system.doctor.exceptions.NotFoundException;
import com.example.hospital_management_system.doctor.mapper.ProfessionalDetailsMapper;
import com.example.hospital_management_system.doctor.model.Doctor;
import com.example.hospital_management_system.doctor.model.ProfessionalDetails;
import com.example.hospital_management_system.doctor.repository.DoctorRepository;
import com.example.hospital_management_system.doctor.repository.ProfessionalDetailsRepository;
import com.example.hospital_management_system.doctor.service.ProfessionalDetailsService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProfessionalDetailsServiceImpl implements ProfessionalDetailsService {

    private final DoctorRepository doctorRepository;
    private final ProfessionalDetailsRepository professionalDetailsRepository;
    private final ProfessionalDetailsMapper professionalDetailsMapper;

    public ProfessionalDetailsServiceImpl(DoctorRepository doctorRepository , ProfessionalDetailsRepository professionalDetailsRepository , ProfessionalDetailsMapper professionalDetailsMapper){
        this.doctorRepository = doctorRepository;
        this.professionalDetailsRepository = professionalDetailsRepository;
        this.professionalDetailsMapper = professionalDetailsMapper;
    }

    public void create(Long id , CreateProfessionalDetailsRequest request)throws NotFoundException{

        Doctor doctor = doctorRepository.findById(id).orElseThrow(
                ()->new NotFoundException("Not found doctor")
        );

        ProfessionalDetails entity = professionalDetailsMapper.toEntity(request);
        entity.setDoctor(doctor);
        ProfessionalDetails saved = professionalDetailsRepository.save(entity);

    }
}

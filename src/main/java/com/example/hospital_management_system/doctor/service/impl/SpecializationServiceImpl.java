package com.example.hospital_management_system.doctor.service.impl;

import com.example.hospital_management_system.doctor.dto.request.CreateSpecializationRequest;
import com.example.hospital_management_system.doctor.dto.response.SpecializationResponse;
import com.example.hospital_management_system.doctor.mapper.SpecializationMapper;
import com.example.hospital_management_system.doctor.model.Specialization;
import com.example.hospital_management_system.doctor.repository.SpecializationRepository;
import com.example.hospital_management_system.doctor.service.SpecializationService;
import org.springframework.stereotype.Service;

@Service
public class SpecializationServiceImpl implements SpecializationService {

    private final SpecializationRepository specializationRepository;
    private final SpecializationMapper specializationMapper;

    public SpecializationServiceImpl(SpecializationRepository specializationRepository , SpecializationMapper specializationMapper){
        this.specializationRepository = specializationRepository;
        this.specializationMapper = specializationMapper;
    }

    @Override
    public SpecializationResponse create(CreateSpecializationRequest request){
       Specialization entity = specializationMapper.toEntity(request);
       Specialization saved = specializationRepository.save(entity);

       return specializationMapper.toResponse(saved);

    }
}

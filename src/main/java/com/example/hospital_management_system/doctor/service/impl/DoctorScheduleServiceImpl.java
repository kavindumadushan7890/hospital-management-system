package com.example.hospital_management_system.doctor.service.impl;

import com.example.hospital_management_system.doctor.dto.request.CreateDoctorScheduleRequest;
import com.example.hospital_management_system.doctor.dto.request.UpdateDoctorScheduleRequest;
import com.example.hospital_management_system.doctor.dto.response.DoctorScheduleResponse;
import com.example.hospital_management_system.doctor.exceptions.NotFoundException;
import com.example.hospital_management_system.doctor.mapper.DoctorScheduleMapper;
import com.example.hospital_management_system.doctor.model.Doctor;
import com.example.hospital_management_system.doctor.model.DoctorAvailable;
import com.example.hospital_management_system.doctor.model.DoctorSchedule;
import com.example.hospital_management_system.doctor.repository.DoctorRepository;
import com.example.hospital_management_system.doctor.repository.DoctorScheduleRepository;
import com.example.hospital_management_system.doctor.service.DoctorScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorScheduleServiceImpl implements DoctorScheduleService {

    private final DoctorRepository doctorRepository;
    private final DoctorScheduleRepository doctorScheduleRepository;
    private final DoctorScheduleMapper doctorScheduleMapper;

    public DoctorScheduleServiceImpl(DoctorRepository doctorRepository , DoctorScheduleRepository doctorScheduleRepository , DoctorScheduleMapper doctorScheduleMapper){
        this.doctorRepository = doctorRepository;
        this.doctorScheduleRepository = doctorScheduleRepository;
        this.doctorScheduleMapper = doctorScheduleMapper;
    }


    @Override
    public void create(Long id, CreateDoctorScheduleRequest request) throws NotFoundException {

        Doctor doctor = doctorRepository.findById(id).orElseThrow(
                ()->new NotFoundException("Not found doctor given id")
        );

        DoctorSchedule entity = doctorScheduleMapper.toEntity(request);
        entity.setDoctor(doctor);
        DoctorSchedule saved = doctorScheduleRepository.save(entity);

    }


    @Override
    public List<DoctorScheduleResponse> getSchedule() {

        List<DoctorSchedule>doctorScheduleList = doctorScheduleRepository.findAll();
        return doctorScheduleList.stream()
                .map(doctorScheduleMapper :: toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void updateSchedule(Long id, UpdateDoctorScheduleRequest request) throws NotFoundException {

        DoctorSchedule doctorSchedule = doctorScheduleRepository.findById(id).orElseThrow(
                ()->new NotFoundException("Not found schedule given id")
        );

        doctorScheduleMapper.doctorScheduleUpdate(request , doctorSchedule);
        doctorScheduleRepository.save(doctorSchedule);
    }

    @Override
    public void deleteSchedule(Long id) throws NotFoundException {

        DoctorSchedule doctorSchedule = doctorScheduleRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Not found schedule given id")
        );

        doctorSchedule.setIsDeleted(true);
        doctorScheduleRepository.save(doctorSchedule);

    }
}

package com.example.hospital_management_system.doctor.service;

import com.example.hospital_management_system.doctor.dto.request.CreateDoctorScheduleRequest;
import com.example.hospital_management_system.doctor.dto.request.UpdateDoctorScheduleRequest;
import com.example.hospital_management_system.doctor.dto.response.DoctorScheduleResponse;
import com.example.hospital_management_system.doctor.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DoctorScheduleService {

    void create(Long id , CreateDoctorScheduleRequest request) throws NotFoundException;

    List<DoctorScheduleResponse>getSchedule();

    void updateSchedule(Long id , UpdateDoctorScheduleRequest request) throws NotFoundException;

    void deleteSchedule(Long id ) throws NotFoundException;
}

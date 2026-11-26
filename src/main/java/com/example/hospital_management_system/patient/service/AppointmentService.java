package com.example.hospital_management_system.patient.service;

import com.example.hospital_management_system.doctor.exceptions.NotFoundException;
import com.example.hospital_management_system.patient.dto.request.CreateAppointmentRequest;
import com.example.hospital_management_system.patient.dto.response.AppointmentResponse;

import java.util.List;

public interface AppointmentService {

    void create(CreateAppointmentRequest request) throws NotFoundException;

    List<AppointmentResponse> getAllAppointment();
}

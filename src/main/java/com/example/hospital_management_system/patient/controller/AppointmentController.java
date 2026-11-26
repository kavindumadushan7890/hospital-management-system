package com.example.hospital_management_system.patient.controller;

import com.example.hospital_management_system.doctor.exceptions.NotFoundException;
import com.example.hospital_management_system.patient.dto.request.CreateAppointmentRequest;
import com.example.hospital_management_system.patient.dto.response.AppointmentResponse;
import com.example.hospital_management_system.patient.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    @PostMapping(value = "/appointments")
    public void createAppointment(@RequestBody @Valid CreateAppointmentRequest request) throws NotFoundException {
        appointmentService.create(request);
    }

    @GetMapping(value = "/appointments")
    public List<AppointmentResponse>getAllAppointment(){

        return appointmentService.getAllAppointment();
    }
}

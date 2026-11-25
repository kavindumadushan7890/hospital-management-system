package com.example.hospital_management_system.patient.controller;

import com.example.hospital_management_system.patient.dto.response.AppointmentSlotResponse;
import com.example.hospital_management_system.patient.exceptions.NotFoundException;
import com.example.hospital_management_system.patient.mapper.AppointmentSlotMapper;
import com.example.hospital_management_system.patient.service.AppointmentSlotService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class AppointmentSlotController {

    private final AppointmentSlotService appointmentSlotService;

    public AppointmentSlotController(AppointmentSlotService appointmentSlotService , AppointmentSlotMapper appointmentSlotMapper){
        this.appointmentSlotService = appointmentSlotService;
    }

    @GetMapping(value = "/doctors/{doctorId}/slots")
    public List<AppointmentSlotResponse>getAppointmentSlot(@PathVariable ("doctorId") Long id ,
                                                           @RequestParam ("date") LocalDate date)throws NotFoundException{

        return appointmentSlotService.getSlots(id, date);

    }
}

package com.example.hospital_management_system.patient.service;

import com.example.hospital_management_system.patient.dto.response.AppointmentSlotResponse;
import com.example.hospital_management_system.patient.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentSlotService {

    void generateSlot(Long id , LocalDate date)throws NotFoundException;

    void generateSlotsForNext30Days() throws NotFoundException;

    List<AppointmentSlotResponse>getSlots(Long id , LocalDate date) throws NotFoundException;
}

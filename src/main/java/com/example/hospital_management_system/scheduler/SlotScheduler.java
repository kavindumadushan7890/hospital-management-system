package com.example.hospital_management_system.scheduler;

import com.example.hospital_management_system.patient.exceptions.NotFoundException;
import com.example.hospital_management_system.patient.service.AppointmentSlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SlotScheduler {

    private final AppointmentSlotService appointmentSlotService;

    public SlotScheduler(AppointmentSlotService appointmentSlotService){
        this.appointmentSlotService = appointmentSlotService;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void generateFutureSlots() throws NotFoundException {
        appointmentSlotService.generateSlotsForNext30Days();
    }
}

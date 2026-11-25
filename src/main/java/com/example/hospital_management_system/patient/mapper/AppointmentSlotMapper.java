package com.example.hospital_management_system.patient.mapper;

import com.example.hospital_management_system.doctor.model.Doctor;
import com.example.hospital_management_system.doctor.model.DoctorSchedule;
import com.example.hospital_management_system.patient.dto.response.AppointmentSlotResponse;
import com.example.hospital_management_system.patient.model.AppointmentSlot;
import com.example.hospital_management_system.patient.model.SlotStatus;
import org.mapstruct.Mapper;

import java.time.LocalDate;
import java.time.LocalTime;

@Mapper(componentModel = "spring")
public interface AppointmentSlotMapper {


    public default AppointmentSlot toEntity(Doctor doctor,
                                    DoctorSchedule doctorSchedule,
                                    LocalDate date,
                                    LocalTime startTime,
                                    LocalTime endTime){
        return AppointmentSlot.builder()
                .doctor(doctor)
                .doctorSchedule(doctorSchedule)
                .date(date)
                .startTime(startTime)
                .endTime(endTime)
                .status(SlotStatus.AVAILABLE)
                .build();
    }

    public default AppointmentSlotResponse toResponse(AppointmentSlot slot){

        return AppointmentSlotResponse.builder()
                .id(slot.getId())
                .date(slot.getDate())
                .startTime(slot.getStartTime())
                .endTime(slot.getEndTime())
                .roomNumber(slot.getRoomNumber())
                .status(slot.getStatus())
                .build();
    }
}

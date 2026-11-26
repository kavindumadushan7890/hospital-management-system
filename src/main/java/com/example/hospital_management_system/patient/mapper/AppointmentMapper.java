package com.example.hospital_management_system.patient.mapper;

import com.example.hospital_management_system.patient.dto.request.CreateAppointmentRequest;
import com.example.hospital_management_system.patient.dto.response.AppointmentResponse;
import com.example.hospital_management_system.patient.model.Appointment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    Appointment toEntity(CreateAppointmentRequest request);

    default AppointmentResponse toResponse(Appointment appointment){
        return AppointmentResponse.builder()
                .doctorName(appointment.getDoctor().getFirstName() + " " + appointment.getDoctor().getLastName())
                .patientName(appointment.getPatient().getFirstName() + " " + appointment.getPatient().getLastName())
                .date(appointment.getDate())
                .time(appointment.getStartTime())
                .build();
    }
}


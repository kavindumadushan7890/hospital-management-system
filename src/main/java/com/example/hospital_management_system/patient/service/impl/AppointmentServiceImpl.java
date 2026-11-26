package com.example.hospital_management_system.patient.service.impl;

import com.example.hospital_management_system.doctor.exceptions.NotFoundException;
import com.example.hospital_management_system.doctor.model.Doctor;
import com.example.hospital_management_system.doctor.repository.DoctorRepository;
import com.example.hospital_management_system.patient.dto.request.CreateAppointmentRequest;
import com.example.hospital_management_system.patient.dto.response.AppointmentResponse;
import com.example.hospital_management_system.patient.dto.response.AppointmentSlotResponse;
import com.example.hospital_management_system.patient.mapper.AppointmentMapper;
import com.example.hospital_management_system.patient.model.*;
import com.example.hospital_management_system.patient.repository.AppointmentRepository;
import com.example.hospital_management_system.patient.repository.AppointmentSlotRepository;
import com.example.hospital_management_system.patient.repository.PatientRepository;
import com.example.hospital_management_system.patient.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final AppointmentSlotRepository appointmentSlotRepository;
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    public AppointmentServiceImpl (DoctorRepository doctorRepository , PatientRepository patientRepository , AppointmentSlotRepository appointmentSlotRepository , AppointmentRepository appointmentRepository , AppointmentMapper appointmentMapper){
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.appointmentSlotRepository = appointmentSlotRepository;
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
    }

    @Override
    public void create(CreateAppointmentRequest request) throws NotFoundException {

        Appointment entity = appointmentMapper.toEntity(request);

        Doctor doctor = doctorRepository.findById(request.getDoctorId()).orElseThrow(
                ()->new NotFoundException("Not found doctor given id")
        );

        Patient patient = patientRepository.findById(request.getPatientId()).orElseThrow(
                ()->new NotFoundException("Not found patient given id")
        );

        AppointmentSlot appointmentSlot = appointmentSlotRepository.findById(request.getSlotId()).orElseThrow(
                ()->new NotFoundException("Not found appointment slot given id")
        );

//        if (!appointmentSlot.getDoctor().getId().equals(doctor.getId())){
//            throw new RuntimeException("Appointment slot does not belong to this doctor");
//        }

        if(appointmentSlot.getStatus() != SlotStatus.AVAILABLE){
            throw new RuntimeException("Appointment slot is not available");
        }

        entity.setDoctor(doctor);
        entity.setPatient(patient);
        entity.setAppointmentSlot(appointmentSlot);

        entity.setDate(appointmentSlot.getDate());
        entity.setStartTime(appointmentSlot.getStartTime());
        entity.setEndTime(appointmentSlot.getEndTime());
        entity.setStatus(AppointmentStatus.SCHEDULED);

        Appointment appointment = appointmentRepository.save(entity);

        appointmentSlot.setStatus(SlotStatus.BOOKED);
        appointmentSlotRepository.save(appointmentSlot);
    }

    public List<AppointmentResponse> getAllAppointment(){
        List<Appointment>appointmentList = appointmentRepository.findAll();
        return appointmentList.stream()
                .map(appointmentMapper ::toResponse)
                .collect(Collectors.toList());
    }


}

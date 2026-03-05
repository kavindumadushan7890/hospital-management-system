package com.example.hospital_management_system.patient.model;

import com.example.hospital_management_system.doctor.model.Doctor;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    @ManyToOne
    @JoinColumn(name = "doctor_id" , nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false )
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "appointmentsolt_id" , nullable = false)
    private AppointmentSlot appointmentSlot;

}

package com.example.hospital_management_system.patient.model;

import com.example.hospital_management_system.doctor.model.Doctor;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class AppointmentSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;

    @Enumerated(EnumType.STRING)
    private SlotStatus status;

    @ManyToOne
    @JoinColumn(name = "doctor_id" , nullable = false)
    private Doctor doctor;

    @OneToMany(mappedBy = "appointmentSlot")
    private List<Appointment>appointments;

}

package com.example.hospital_management_system.doctor.model;

import com.example.hospital_management_system.patient.model.Appointment;
import com.example.hospital_management_system.patient.model.AppointmentSlot;
import com.example.hospital_management_system.prescription.model.Prescription;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String email;
    private String phone;

    @OneToOne
    @JoinColumn(name = "professional_details_id" , nullable = false)
    private ProfessionalDetails professionalDetails;

    @OneToMany(mappedBy = "doctor")
    private List<Specialization> specializations;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment>appointments;

    @OneToMany(mappedBy = "doctor")
    private List<Prescription>prescriptions;

    @OneToMany(mappedBy = "doctor")
    private List<AppointmentSlot>appointmentSlots;

}

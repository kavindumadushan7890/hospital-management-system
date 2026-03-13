package com.example.hospital_management_system.patient.model;

import com.example.hospital_management_system.doctor.model.Gender;
import com.example.hospital_management_system.invoice.model.Invoice;
import com.example.hospital_management_system.prescription.model.Prescription;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate dob;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "patient")
    private List<Appointment>appointments;

    @OneToMany(mappedBy = "patient")
    private List<Prescription>prescriptions;

    @OneToMany(mappedBy = "patient")
    private List<Invoice>invoices;

}

package com.example.hospital_management_system.doctor.model;

import jakarta.persistence.*;

@Entity
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "doctor_id" , nullable = false)
    private Doctor doctor;

}

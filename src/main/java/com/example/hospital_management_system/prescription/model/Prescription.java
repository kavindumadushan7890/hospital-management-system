package com.example.hospital_management_system.prescription.model;

import com.example.hospital_management_system.doctor.model.Doctor;
import com.example.hospital_management_system.patient.model.Patient;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private String createdBy;
    private String notes;

    @Enumerated(EnumType.STRING)
    private PrescriptionStatus status;

    @Timestamp
    private LocalDateTime prescriptionDate;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;


    @OneToMany(mappedBy = "prescription")
    private List<PrescriptionItem>prescriptionItems;

}

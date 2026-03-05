package com.example.hospital_management_system.prescription.model;

import com.example.hospital_management_system.pharmacy.model.Drug;
import com.example.hospital_management_system.pharmacy.model.UnitType;
import jakarta.persistence.*;

@Entity
public class PrescriptionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer doseAmount;

    @Enumerated(EnumType.STRING)
    private UnitType unitType;

    @Enumerated(EnumType.STRING)
    private FrequencyPerDay frequencyPerDay;

    private Integer durationDays;
    private Integer quantity;
    private String instructions;

    @ManyToOne
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;

    @ManyToOne
    @JoinColumn(name = "drug_id")
    private Drug drug;

}



package com.example.hospital_management_system.patient.repository;

import com.example.hospital_management_system.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient , Long> { }

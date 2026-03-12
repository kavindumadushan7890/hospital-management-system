package com.example.hospital_management_system.doctor.repository;

import com.example.hospital_management_system.doctor.model.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> { }

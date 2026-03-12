package com.example.hospital_management_system.doctor.repository;

import com.example.hospital_management_system.doctor.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long > { }

package com.example.hospital_management_system.doctor.repository;

import com.example.hospital_management_system.doctor.model.DoctorSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorScheduleRepository extends JpaRepository<DoctorSchedule , Long> { }

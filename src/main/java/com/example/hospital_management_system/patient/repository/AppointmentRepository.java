package com.example.hospital_management_system.patient.repository;

import com.example.hospital_management_system.patient.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment , Long> {
}

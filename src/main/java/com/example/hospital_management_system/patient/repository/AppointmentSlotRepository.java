package com.example.hospital_management_system.patient.repository;

import com.example.hospital_management_system.doctor.model.Doctor;
import com.example.hospital_management_system.doctor.model.DoctorSchedule;
import com.example.hospital_management_system.patient.model.AppointmentSlot;
import com.example.hospital_management_system.patient.model.SlotStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentSlotRepository extends JpaRepository<AppointmentSlot, Long> {

    boolean existsByDoctorScheduleAndDate(DoctorSchedule doctorSchedule , LocalDate date);

    List<AppointmentSlot> findByDoctorIdAndDateAndStatusOrderByStartTimeAsc(Long doctorId, LocalDate date, SlotStatus status);
}

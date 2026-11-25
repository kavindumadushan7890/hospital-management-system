package com.example.hospital_management_system.doctor.repository;

import com.example.hospital_management_system.doctor.model.DoctorSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorScheduleRepository extends JpaRepository<DoctorSchedule , Long> {

    List<DoctorSchedule> findByDoctorId(Long id);

    boolean existsByDoctorIdAndDayOfWeek(Long id , java.time.DayOfWeek dayOfWeek);
}

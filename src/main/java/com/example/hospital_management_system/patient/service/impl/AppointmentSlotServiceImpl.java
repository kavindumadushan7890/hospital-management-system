package com.example.hospital_management_system.patient.service.impl;

import com.example.hospital_management_system.doctor.model.Doctor;
import com.example.hospital_management_system.doctor.model.DoctorSchedule;
import com.example.hospital_management_system.doctor.repository.DoctorScheduleRepository;
import com.example.hospital_management_system.patient.dto.response.AppointmentSlotResponse;
import com.example.hospital_management_system.patient.exceptions.NotFoundException;
import com.example.hospital_management_system.patient.mapper.AppointmentSlotMapper;
import com.example.hospital_management_system.patient.model.AppointmentSlot;
import com.example.hospital_management_system.patient.model.SlotStatus;
import com.example.hospital_management_system.patient.repository.AppointmentSlotRepository;
import com.example.hospital_management_system.patient.service.AppointmentSlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentSlotServiceImpl implements AppointmentSlotService {

    private final AppointmentSlotRepository appointmentSlotRepository;
    private final DoctorScheduleRepository doctorScheduleRepository;
    private final AppointmentSlotMapper appointmentSlotMapper;

    public AppointmentSlotServiceImpl(AppointmentSlotRepository appointmentSlotRepository , DoctorScheduleRepository doctorScheduleRepository , AppointmentSlotMapper appointmentSlotMapper){
        this.appointmentSlotRepository = appointmentSlotRepository;
        this.doctorScheduleRepository = doctorScheduleRepository;
        this.appointmentSlotMapper = appointmentSlotMapper;
    }

    public void generateSlot(Long id , LocalDate date) throws NotFoundException {

        DoctorSchedule doctorSchedule = doctorScheduleRepository.findById(id).orElseThrow(
                ()->new NotFoundException("Not found doctor schedule given id")
        );

        if (!date.getDayOfWeek().equals(doctorSchedule.getDayOfWeek())){
            return;
        }

        Doctor doctor = doctorSchedule.getDoctor();

        if(appointmentSlotRepository.existsByDoctorScheduleAndDate(doctorSchedule , date)){
            return;
        }

        LocalTime start  = doctorSchedule.getStartTime();
        LocalTime end = doctorSchedule.getEndTime();
        int duration = doctorSchedule.getSlotDuration();

        List<AppointmentSlot>appointmentSlots = new ArrayList<>();
        LocalTime current = start;

        while(!current.plusMinutes(duration).isAfter(end)){
            AppointmentSlot appointmentSlot = appointmentSlotMapper.toEntity(doctor,
                    doctorSchedule,
                    date,
                    current,
                    current.plusMinutes(duration)
            );

            appointmentSlots.add(appointmentSlot);
            current = current.plusMinutes(duration);

        }

        appointmentSlotRepository.saveAll(appointmentSlots);
    }

    public void generateSlotsForNext30Days() throws NotFoundException {

        List<DoctorSchedule>doctorSchedules = doctorScheduleRepository.findAll();

        for(DoctorSchedule doctorSchedule : doctorSchedules){
            for(int i=0 ; i<30 ; i++){
                LocalDate date = LocalDate.now().plusDays(i);
                generateSlot(doctorSchedule.getId()  , date);
            }
        }
    }

    @Override
    public List<AppointmentSlotResponse> getSlots(Long Id, LocalDate date)
            throws NotFoundException {

        List<DoctorSchedule> doctorSchedules =
                doctorScheduleRepository.findByDoctorId(Id);

        for (DoctorSchedule schedule : doctorSchedules) {

            if (schedule.getDayOfWeek().equals(date.getDayOfWeek())) {

                generateSlot(schedule.getId(), date);
            }
        }

        List<AppointmentSlot> appointmentSlots =
                appointmentSlotRepository
                        .findByDoctorIdAndDateAndStatusOrderByStartTimeAsc(
                                Id,
                                date,
                                SlotStatus.AVAILABLE
                        );

        return appointmentSlots.stream()
                .map(appointmentSlotMapper::toResponse)
                .toList();
    }
}

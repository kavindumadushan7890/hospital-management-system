package com.example.hospital_management_system.doctor.controller;

import com.example.hospital_management_system.doctor.dto.request.CreateDoctorScheduleRequest;
import com.example.hospital_management_system.doctor.dto.request.UpdateDoctorScheduleRequest;
import com.example.hospital_management_system.doctor.dto.response.DoctorScheduleResponse;
import com.example.hospital_management_system.doctor.exceptions.NotFoundException;
import com.example.hospital_management_system.doctor.service.DoctorScheduleService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class DoctorScheduleController {

    private final DoctorScheduleService doctorScheduleService;

    public DoctorScheduleController(DoctorScheduleService doctorScheduleService){
        this.doctorScheduleService = doctorScheduleService;
    }


    @PostMapping(value = "/doctor/{doctorId}/schedules")
    public void createDoctorSchedule(@PathVariable("doctorId") Long id ,
                                     @RequestBody @Valid CreateDoctorScheduleRequest request) throws NotFoundException {

        doctorScheduleService.create(id, request);
    }


    @GetMapping(value = "/schedules")
    public List<DoctorScheduleResponse>getAllSchedule(){

        return doctorScheduleService.getSchedule();

    }

    @PatchMapping(value = "/schedule/{scheduleId}")
    public void updateSchedule(@PathVariable("scheduleId") Long id,
                               @RequestBody UpdateDoctorScheduleRequest request)throws NotFoundException{

        doctorScheduleService.updateSchedule(id , request);
    }


    @DeleteMapping(value = "/schedule/{scheduleId}")
    public void deleteSchedule(@PathVariable("scheduleId") Long id) throws NotFoundException{

        doctorScheduleService.deleteSchedule(id);
    }
}
           
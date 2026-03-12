package com.example.hospital_management_system.doctor.controller;

import com.example.hospital_management_system.doctor.dto.request.CreateDoctorRequest;
import com.example.hospital_management_system.doctor.dto.request.UpdateDoctorDetailsRequest;
import com.example.hospital_management_system.doctor.dto.response.DoctorResponse;
import com.example.hospital_management_system.doctor.exceptions.NotFoundException;
import com.example.hospital_management_system.doctor.service.DoctorService;
import com.example.hospital_management_system.doctor.service.impl.DoctorServiceImpl;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }


    @PostMapping(value = "specialization/{specializationId}/doctors")
    public void createDoctor(@PathVariable("specializationId") Long id ,
                             @RequestBody @Valid  CreateDoctorRequest request) throws NotFoundException {

        doctorService.create(id , request);
    }


    @GetMapping(value = "/doctors")
    public List<DoctorResponse>getAllDoctors(){

        return doctorService.getAllDoctors();
    }


    @PatchMapping(value = "/doctors/{doctorId}")
    public void updateDoctor(@PathVariable("doctorId") Long id ,
                             @RequestBody @Valid UpdateDoctorDetailsRequest request) throws NotFoundException{

        doctorService.updateDoctor(id , request);

    }


    @DeleteMapping(value = "/doctors/{doctorId}")
    public void deleteDoctor(@PathVariable("doctorId") Long id) throws NotFoundException{

        doctorService.delete(id);
    }

}

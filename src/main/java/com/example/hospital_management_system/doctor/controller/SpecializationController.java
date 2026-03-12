package com.example.hospital_management_system.doctor.controller;

import com.example.hospital_management_system.doctor.dto.request.CreateSpecializationRequest;
import com.example.hospital_management_system.doctor.dto.response.SpecializationResponse;
import com.example.hospital_management_system.doctor.service.SpecializationService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class SpecializationController {

    private final SpecializationService specializationService;

    public SpecializationController(SpecializationService specializationService){
        this.specializationService = specializationService;
    }

    @PostMapping(value = "/specializations")
    public SpecializationResponse createSpecialization(@Valid @RequestBody CreateSpecializationRequest request){

        return specializationService.create(request);
    }
}

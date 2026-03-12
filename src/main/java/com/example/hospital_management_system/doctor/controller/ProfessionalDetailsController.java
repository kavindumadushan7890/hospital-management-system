package com.example.hospital_management_system.doctor.controller;

import com.example.hospital_management_system.doctor.dto.request.CreateProfessionalDetailsRequest;
import com.example.hospital_management_system.doctor.exceptions.NotFoundException;
import com.example.hospital_management_system.doctor.service.ProfessionalDetailsService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class ProfessionalDetailsController {

    private final ProfessionalDetailsService professionalDetailsService;

    public ProfessionalDetailsController(ProfessionalDetailsService professionalDetailsService){
        this.professionalDetailsService = professionalDetailsService;
    }

    @PostMapping(value = "/doctor/{id}/professionaldetails")
    public void createProfessionalDetails(@PathVariable Long id,
                                          @RequestBody @Valid CreateProfessionalDetailsRequest request) throws NotFoundException{

        professionalDetailsService.create(id , request);

    }
}

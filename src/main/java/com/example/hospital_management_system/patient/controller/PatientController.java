package com.example.hospital_management_system.patient.controller;

import com.example.hospital_management_system.doctor.exceptions.NotFoundException;
import com.example.hospital_management_system.patient.dto.request.CreatePatientRequest;
import com.example.hospital_management_system.patient.dto.request.UpdatePatientDetailsRequest;
import com.example.hospital_management_system.patient.dto.response.PatientResponse;
import com.example.hospital_management_system.patient.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @PostMapping(value = "/patients")
    public void createPatient(@RequestBody @Valid CreatePatientRequest request){

        patientService.create(request);
    }

    @GetMapping(value = "/patients")
    public List<PatientResponse>getAllPatient(){

       return patientService.getAllPatient();
    }

    @PatchMapping("/patients/{patientId}")
    public void updatePatient(@PathVariable("patientId") Long id ,  @RequestBody @Valid  UpdatePatientDetailsRequest request) throws NotFoundException{

        patientService.updatePatient(id , request);

    }

    @DeleteMapping(value = "/patients/{patientId}")
    public void deletePatient(@PathVariable("patientId") Long id) throws NotFoundException{

        patientService.deleteById(id);
    }

}

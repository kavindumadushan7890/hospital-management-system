package com.example.hospital_management_system.pharmacy.controller;

import com.example.hospital_management_system.pharmacy.dto.request.CreateManufacturerRequest;
import com.example.hospital_management_system.pharmacy.service.ManufacturerService;
import com.example.hospital_management_system.pharmacy.service.impl.ManufacturerServiceImpl;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService){
        this.manufacturerService = manufacturerService;
    }

    @PostMapping(value = "/manufacturers")
    public void createManufacturer(@RequestBody @Valid CreateManufacturerRequest request){
        manufacturerService.create(request);
    }

}

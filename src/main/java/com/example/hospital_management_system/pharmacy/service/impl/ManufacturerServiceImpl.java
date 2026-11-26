package com.example.hospital_management_system.pharmacy.service.impl;

import com.example.hospital_management_system.pharmacy.dto.request.CreateManufacturerRequest;
import com.example.hospital_management_system.pharmacy.mapper.ManufacturerMapper;
import com.example.hospital_management_system.pharmacy.model.Manufacturer;
import com.example.hospital_management_system.pharmacy.repository.ManufacturerRepository;
import com.example.hospital_management_system.pharmacy.service.ManufacturerService;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerMapper manufacturerMapper;
    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerMapper manufacturerMapper , ManufacturerRepository manufacturerRepository){
        this.manufacturerMapper = manufacturerMapper;
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public void create(CreateManufacturerRequest request) {

        Manufacturer entity = manufacturerMapper.toEntity(request);
        Manufacturer manufacturer = manufacturerRepository.save(entity);

    }
}

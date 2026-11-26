package com.example.hospital_management_system.pharmacy.mapper;

import com.example.hospital_management_system.pharmacy.dto.request.CreateManufacturerRequest;
import com.example.hospital_management_system.pharmacy.model.Manufacturer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManufacturerMapper {

    Manufacturer toEntity(CreateManufacturerRequest request);

}

package com.example.hospital_management_system.pharmacy.repository;

import com.example.hospital_management_system.pharmacy.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
}

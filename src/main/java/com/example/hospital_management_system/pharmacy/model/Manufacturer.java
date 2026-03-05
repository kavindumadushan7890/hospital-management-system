package com.example.hospital_management_system.pharmacy.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String registrationNumber;
    private String countryOfOrigin;

    @OneToMany(mappedBy = "manufacturer")
    private List<Drug>drugs;


}

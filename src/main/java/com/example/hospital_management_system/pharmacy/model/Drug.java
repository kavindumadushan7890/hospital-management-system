package com.example.hospital_management_system.pharmacy.model;

import com.example.hospital_management_system.invoice.model.InvoiceItem;
import com.example.hospital_management_system.prescription.model.PrescriptionItem;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String genericName;
    private String brandName;
    private Double strength;

    @Enumerated(EnumType.STRING)
    private UnitType unitType;

    @Enumerated(EnumType.STRING)
    private DrugForm form;

    @OneToMany(mappedBy = "drug")
    private List<PrescriptionItem>prescriptionItems;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id" , nullable = false)
    private Manufacturer manufacturer;

    @OneToMany(mappedBy = "drug")
    private List<Inventory>inventories;

    @OneToMany(mappedBy = "drug")
    private List<InvoiceItem>invoiceItems;

}

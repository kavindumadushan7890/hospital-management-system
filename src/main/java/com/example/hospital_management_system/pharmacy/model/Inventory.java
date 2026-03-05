package com.example.hospital_management_system.pharmacy.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String batchNumber;
    private LocalDate expiryDate;
    private Double purchasePrice;
    private Double sellingPrice;
    private Integer quantity;
    private Integer minimumStockLevel;

    @Enumerated(EnumType.STRING)
    private StockStatus stockStatus;

    @ManyToOne
    @JoinColumn(name = "drug_id" , nullable = false)
    private Drug drug;


}

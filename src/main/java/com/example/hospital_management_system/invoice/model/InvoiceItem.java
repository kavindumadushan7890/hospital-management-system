package com.example.hospital_management_system.invoice.model;

import com.example.hospital_management_system.pharmacy.model.Drug;
import jakarta.persistence.*;

@Entity
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double unitPrice;
    private Integer quantity;
    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "drug_id" , nullable = false)
    private Drug drug;

    @ManyToOne
    @JoinColumn(name = "invoice_id" , nullable = false)
    private Invoice invoice;

}

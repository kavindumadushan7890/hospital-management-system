package com.example.hospital_management_system.invoice.model;

import com.example.hospital_management_system.patient.model.Patient;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;


@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String invoiceNumber;
    private Double subtotalAmount;
    private Double discountAmount;
    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @CreationTimestamp
    private LocalDateTime issuedDate;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceItem>invoiceItems;

    @OneToMany(mappedBy = "invoice")
    private List<Payment>payments;

}

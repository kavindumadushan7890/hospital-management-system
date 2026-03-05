package com.example.hospital_management_system.invoice.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @CreationTimestamp
    private LocalDateTime paymentDate;

    private Double amountPaid;

    @ManyToOne
    @JoinColumn(name = "invoice_id" , nullable = false)
    private Invoice invoice;

}

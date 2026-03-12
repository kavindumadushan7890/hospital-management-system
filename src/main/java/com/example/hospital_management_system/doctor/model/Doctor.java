package com.example.hospital_management_system.doctor.model;

import com.example.hospital_management_system.patient.model.Appointment;
import com.example.hospital_management_system.patient.model.AppointmentSlot;
import com.example.hospital_management_system.prescription.model.Prescription;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String email;
    private String phone;


    @ManyToMany
    @JoinTable(
            name = "doctor_specialization",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "specialization_id" )
    )
    private Set<Specialization> specializations;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment>appointments;

    @OneToMany(mappedBy = "doctor")
    private List<Prescription>prescriptions;

    @OneToMany(mappedBy = "doctor")
    private List<AppointmentSlot>appointmentSlots;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private DoctorStatus status = DoctorStatus.ACTIVE;

}



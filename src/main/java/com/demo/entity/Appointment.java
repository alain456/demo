package com.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String patientName;
    private String patientEmail;
    private String patientPhone;

    @ManyToOne
    @JoinColumn(name = "slot_id")
    private Slot slot;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    public void confirm(boolean isAccepted) {
        this.status = isAccepted ? Status.CONFIRMED : Status.REJECTED;
        this.slot.setAvailable(false);
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
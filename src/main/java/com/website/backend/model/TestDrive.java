package com.website.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime; // For timestamp

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "test_drives") // Define the table name
public class TestDrive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrementing ID
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String emailAddress;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String carModel;

    @Column(nullable = false)
    private Boolean agreeTerms;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt; // Timestamp for when the request was created

    public TestDrive(String fullName, String phoneNumber, String emailAddress, String brand, String carModel, Boolean agreeTerms) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.brand = brand;
        this.carModel = carModel;
        this.agreeTerms = agreeTerms;
    }

    // Lifecycle callback for setting creation timestamp
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }



}

package com.website.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime; // For timestamp

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

    // Constructors
    public TestDrive() {
    }

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

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Boolean getAgreeTerms() {
        return agreeTerms;
    }

    public void setAgreeTerms(Boolean agreeTerms) {
        this.agreeTerms = agreeTerms;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "TestDrive{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", brand='" + brand + '\'' +
                ", carModel='" + carModel + '\'' +
                ", agreeTerms=" + agreeTerms +
                ", createdAt=" + createdAt +
                '}';
    }
}

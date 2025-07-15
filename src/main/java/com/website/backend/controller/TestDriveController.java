package com.website.backend.controller;

import com.website.backend.model.TestDrive; // Import the new TestDrive entity
import com.website.backend.payload.request.TestDriveRequest;
import com.website.backend.payload.response.MessageResponse;
import com.website.backend.repositories.TestDriveRepository; // Import the new repository
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test-drive")
public class TestDriveController {

    @Autowired
    private TestDriveRepository testDriveRepository; // Inject the repository

    @PostMapping("/schedule")
    public ResponseEntity<?> scheduleTestDrive(@Valid @RequestBody TestDriveRequest testDriveRequest) {
        // Convert DTO to Entity
        TestDrive testDrive = new TestDrive(
                testDriveRequest.getFullName(),
                testDriveRequest.getPhoneNumber(),
                testDriveRequest.getEmailAddress(),
                testDriveRequest.getBrand(),
                testDriveRequest.getCarModel(),
                testDriveRequest.getAgreeTerms()
        );

        // Save to database
        testDriveRepository.save(testDrive);

        System.out.println("Test Drive Request Saved: " + testDrive.toString());

        return ResponseEntity.ok(new MessageResponse("Test drive scheduled successfully!"));
    }
}

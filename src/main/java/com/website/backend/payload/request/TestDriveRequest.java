package com.website.backend.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestDriveRequest {

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Invalid phone number format")
    private String phoneNumber;

    @NotBlank(message = "Email address is required")
    @Email(message = "Invalid email address format")
    private String emailAddress;

    @NotBlank(message = "Brand selection is required")
    private String brand;

    @NotBlank(message = "Car selection is required")
    private String carModel;

    @NotNull(message = "Terms and conditions must be accepted")
    private Boolean agreeTerms;

}

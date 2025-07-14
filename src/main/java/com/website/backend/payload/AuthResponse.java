package com.website.backend.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private String tokenType = "Bearer";
    private String fullName;
    private String email;
    private List<String> roles;

    public AuthResponse(String token, String fullName, String email, List<String> roles) {
        this.token = token;
        this.fullName = fullName;
        this.email = email;
        this.roles = roles;
    }
}

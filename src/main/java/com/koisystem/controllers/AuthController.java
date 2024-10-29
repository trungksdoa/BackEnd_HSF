package com.koisystem.controllers;

import com.koisystem.config.JwtConfig;
import com.koisystem.dto.ApiResponse;
import com.koisystem.dto.LoginRequest;
import com.koisystem.dto.LoginResponse;
import com.koisystem.models.UserInfo;
import com.koisystem.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "APIs for authentication")
public class AuthController {
    
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtConfig jwtConfig;

    @PostMapping("/login")
    @Operation(summary = "Login to get authentication token")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest request) {
        UserInfo user = userService.getUserByUsername(request.getUsername());
        
        if (user != null && passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            String token = jwtConfig.generateToken(user.getUsername());
            LoginResponse loginResponse = LoginResponse.builder()
                    .user(user)
                    .token("Bearer " + token)
                    .build();
            return ResponseEntity.ok(ApiResponse.success("Login successful", loginResponse));
        }
        
        return ResponseEntity.badRequest().body(ApiResponse.builder()
                .message("Invalid credentials")
                .data(null)
                .build());
    }

    @PostMapping("/register")
    @Operation(summary = "Register new user account")
    public ResponseEntity<ApiResponse> register(@RequestBody UserInfo user) {
        return ResponseEntity.ok(ApiResponse.success("User registered successfully", 
            userService.createUser(user)));
    }

    @PostMapping("/logout")
    @Operation(summary = "Logout current user")
    public ResponseEntity<ApiResponse> logout() {
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok(ApiResponse.success("Logged out successfully", null));
    }
}

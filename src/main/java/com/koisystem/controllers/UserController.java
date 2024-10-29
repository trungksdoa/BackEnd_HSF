package com.koisystem.controllers;

import com.koisystem.dto.ApiResponse;
import com.koisystem.models.UserInfo;
import com.koisystem.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "User Management", description = "APIs for managing users")
public class UserController {
    private final UserService userService;

    @GetMapping
    @Operation(summary = "Get all users")
    public ResponseEntity<ApiResponse> getAllUsers() {
        return ResponseEntity.ok(ApiResponse.success("Users retrieved successfully", 
            userService.getAllUsers()));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success("User retrieved successfully", 
            userService.getUserById(id)));
    }

    @GetMapping("/username/{username}")
    @Operation(summary = "Get user by username")
    public ResponseEntity<ApiResponse> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(ApiResponse.success("User retrieved successfully", 
            userService.getUserByUsername(username)));
    }

    @PostMapping("/register")
    @Operation(summary = "Register new user")
    public ResponseEntity<ApiResponse> registerUser(@RequestBody UserInfo user) {
        return ResponseEntity.ok(ApiResponse.success("User registered successfully", 
            userService.createUser(user)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update user")
    public ResponseEntity<ApiResponse> updateUser(@PathVariable Long id, @RequestBody UserInfo user) {
        user.setId(id);
        return ResponseEntity.ok(ApiResponse.success("User updated successfully", 
            userService.updateUser(user)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(ApiResponse.success("User deleted successfully", null));
    }

    @PostMapping("/change-password")
    @Operation(summary = "Change user password")
    public ResponseEntity<ApiResponse> changePassword(
            @RequestParam String username,
            @RequestParam String oldPassword,
            @RequestParam String newPassword) {
        userService.changePassword(username, oldPassword, newPassword);
        return ResponseEntity.ok(ApiResponse.success("Password changed successfully", null));
    }

    @GetMapping("/check-username")
    @Operation(summary = "Check if username exists")
    public ResponseEntity<ApiResponse> checkUsernameExists(@RequestParam String username) {
        return ResponseEntity.ok(ApiResponse.success("Username check completed", 
            userService.existsByUsername(username)));
    }

    @GetMapping("/check-email")
    @Operation(summary = "Check if email exists") 
    public ResponseEntity<ApiResponse> checkEmailExists(@RequestParam String email) {
        return ResponseEntity.ok(ApiResponse.success("Email check completed", 
            userService.existsByEmail(email)));
    }
}

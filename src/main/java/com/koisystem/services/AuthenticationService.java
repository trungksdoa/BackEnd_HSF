package com.koisystem.services;

import com.koisystem.dto.ServiceResponse;
import com.koisystem.models.UserInfo;
import com.koisystem.utils.PasswordUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;

    public ServiceResponse<UserInfo> login(String username, String password) {
        try {
            UserInfo user = userService.getUserByUsername(username);
            if (user != null && PasswordUtils.matches(password, user.getPassword())) {
                return ServiceResponse.success("Login successful", user);
            }
            return ServiceResponse.error("Invalid credentials");
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }

    public ServiceResponse<UserInfo> register(UserInfo user) {
        try {
            user.setPassword(PasswordUtils.encode(user.getPassword()));
            UserInfo savedUser = userService.createUser(user);
            return ServiceResponse.success("User registered successfully", savedUser);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }

    public ServiceResponse<Void> logout() {
        try {
            return ServiceResponse.success("Logged out successfully", null);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }
} 
package com.koisystem.services;

import com.koisystem.dto.ServiceResponse;
import com.koisystem.models.UserInfo;
import com.koisystem.utils.PasswordUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserManagementService {
    private final UserService userService;

    public ServiceResponse<UserInfo> getUserById(Long id) {
        try {
            UserInfo user = userService.getUserById(id);
            return ServiceResponse.success("User retrieved successfully", user);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }

    public ServiceResponse<UserInfo> getUserByUsername(String username) {
        try {
            UserInfo user = userService.getUserByUsername(username);
            return ServiceResponse.success("User retrieved successfully", user);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }

    public ServiceResponse<UserInfo> createUser(UserInfo user) {
        try {
            user.setPassword(PasswordUtils.encode(user.getPassword()));
            UserInfo savedUser = userService.createUser(user);
            return ServiceResponse.success("User created successfully", savedUser);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }

    public ServiceResponse<UserInfo> updateUser(Long id, UserInfo user) {
        try {
            user.setId(id);
            if (user.getPassword() != null && !user.getPassword().isEmpty()) {
                user.setPassword(PasswordUtils.encode(user.getPassword()));
            }
            UserInfo updatedUser = userService.updateUser(user);
            return ServiceResponse.success("User updated successfully", updatedUser);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }

    public ServiceResponse<Void> deleteUser(Long id) {
        try {
            userService.deleteUser(id);
            return ServiceResponse.success("User deleted successfully", null);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }

    public ServiceResponse<Void> changePassword(String username, String oldPassword, String newPassword) {
        try {
            UserInfo user = userService.getUserByUsername(username);
            if (user != null && PasswordUtils.matches(oldPassword, user.getPassword())) {
                user.setPassword(PasswordUtils.encode(newPassword));
                userService.updateUser(user);
                return ServiceResponse.success("Password changed successfully", null);
            }
            return ServiceResponse.error("Invalid old password");
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }
} 
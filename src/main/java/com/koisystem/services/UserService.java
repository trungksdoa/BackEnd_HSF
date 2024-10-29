package com.koisystem.services;

import com.koisystem.models.UserInfo;
import com.koisystem.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    public List<UserInfo> getAllUsers() {
        return userRepository.findAll();
    }
    
    public UserInfo getUserById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserInfo getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserInfo createUser(UserInfo user) {
        if (existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        if (existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        
        // Encode password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    
    public UserInfo updateUser(UserInfo user) {
        UserInfo existingUser = getUserById(user.getId());
            
        // Update user information
        existingUser.setEmail(user.getEmail());
        existingUser.setFullName(user.getFullName());
        existingUser.setPhone(user.getPhone());
        existingUser.setAddress(user.getAddress());
        existingUser.setRole(user.getRole());
        
        return userRepository.save(existingUser);
    }
    
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    public void changePassword(String username, String oldPassword, String newPassword) {
        UserInfo user = getUserByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        
        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new RuntimeException("Invalid old password");
        }
        
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }
    
    public boolean verifyPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}

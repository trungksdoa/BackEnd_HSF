package com.koisystem.services;

import com.koisystem.models.UserInfo;
import com.koisystem.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsService {
    private final UserRepository userRepository;

    public UserInfo loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

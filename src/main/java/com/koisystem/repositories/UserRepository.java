package com.koisystem.repositories;

import com.koisystem.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findByUsername(String username);
    UserInfo findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}

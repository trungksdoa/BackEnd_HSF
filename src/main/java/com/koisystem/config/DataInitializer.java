package com.koisystem.config;

import com.koisystem.models.UserInfo;
import com.koisystem.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // Kiểm tra nếu admin chưa tồn tại thì tạo mới
        if (!userRepository.existsByUsername("admin")) {
            UserInfo admin = new UserInfo();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123")); // Mật khẩu mặc định: admin123
            admin.setEmail("admin@koisystem.com");
            admin.setFullName("System Administrator");
            admin.setRole("ADMIN");
            admin.setPhone("0123456789");
            admin.setAddress("System Address");
            
            userRepository.save(admin);
        }

        // Tạo thêm một số tài khoản test nếu cần
        if (!userRepository.existsByUsername("sales")) {
            UserInfo sales = new UserInfo();
            sales.setUsername("sales");
            sales.setPassword(passwordEncoder.encode("sales123"));
            sales.setEmail("sales@koisystem.com");
            sales.setFullName("Sales Staff");
            sales.setRole("SALES");
            sales.setPhone("0987654321");
            sales.setAddress("Sales Address");
            
            userRepository.save(sales);
        }

        if (!userRepository.existsByUsername("consultant")) {
            UserInfo consultant = new UserInfo();
            consultant.setUsername("consultant");
            consultant.setPassword(passwordEncoder.encode("consultant123"));
            consultant.setEmail("consultant@koisystem.com");
            consultant.setFullName("Consultant Staff");
            consultant.setRole("CONSULTANT");
            consultant.setPhone("0123498765");
            consultant.setAddress("Consultant Address");
            
            userRepository.save(consultant);
        }
    }
}

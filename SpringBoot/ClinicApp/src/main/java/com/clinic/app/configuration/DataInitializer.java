package com.clinic.app.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.clinic.app.entities.Role;
import com.clinic.app.entities.User;
import com.clinic.app.repos.UserRepository;

import jakarta.annotation.PostConstruct;

@Configuration
public class DataInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        if (userRepository.findByEmail("admin@gmail.com").isEmpty()) {
            User admin = new User();
            admin.setName("Admin");
            admin.setEmail("admin@gmail.com");
            admin.setRole(Role.ROLE_ADMIN);
            admin.setPassword(passwordEncoder.encode("admin123")); 
            userRepository.save(admin);
            //System.out.println("✅ Auto Admin Created!");
        }
    }
}

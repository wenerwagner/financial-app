package com.wenercastro.projects.financial_app.config;

import com.wenercastro.projects.financial_app.model.Role;
import com.wenercastro.projects.financial_app.model.User;
import com.wenercastro.projects.financial_app.repository.UserRepository;

import lombok.AllArgsConstructor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class AdminConfig {

    private UserRepository userRepository;

    private static final String ADMIN_NAME = "Admin User";
    private static final String ADMIN_EMAIL = "admin@admin.com";
    private static final String ADMIN_PASSWORD = "Teste@123";


    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            if (userRepository.findByEmail(ADMIN_EMAIL).isEmpty()) {
                User user = User.builder()
                        .email(ADMIN_EMAIL)
                        .name(ADMIN_NAME)
                        .password(ADMIN_PASSWORD)
                        .role(Role.ADMIN)
                        .build();
                userRepository.save(user);
            }
        };
    }
}

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
public class InitialDatabaseDataConfig {

    private UserRepository userRepository;

    private static final String ADMIN_NAME = "Admin User";
    private static final String ADMIN_EMAIL = "admin";
    private static final String ADMIN_PASSWORD = "admin";


    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            createAdminUser();
            createUsers();
        };
    }

    private void createAdminUser() {
        if (userRepository.findByEmail(ADMIN_EMAIL).isEmpty()) {
            User user = User.builder()
                    .email(ADMIN_EMAIL)
                    .name(ADMIN_NAME)
                    .password(ADMIN_PASSWORD)
                    .role(Role.ADMIN)
                    .build();
            userRepository.save(user);
        }
    }

    // TODO: Remove all the code below for the v1

    private void createUsers() {
        User user = User.builder()
                .email("wenerwagner@gmail.com")
                .name("Wener Castro")
                .password("Teste@123")
                .role(Role.USER)
                .build();
        userRepository.save(user);
    }
}

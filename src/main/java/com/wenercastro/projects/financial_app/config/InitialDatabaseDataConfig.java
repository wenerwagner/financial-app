package com.wenercastro.projects.financial_app.config;

import com.wenercastro.projects.financial_app.model.Role;
import com.wenercastro.projects.financial_app.model.Spreadsheet;
import com.wenercastro.projects.financial_app.model.User;
import com.wenercastro.projects.financial_app.repository.SpreadsheetRepository;
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
            // TODO: Remove all the methods call below for the v1
            System.out.println("INFO: Creating testing data.");
            createUsers();
            createSpreadsheets();
        };
    }

    private void createAdminUser() {
        System.out.println("INFO: Admin user created.");
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

    private SpreadsheetRepository spreadsheetRepository;

    private void createUsers() {
        User myUser = User.builder()
                .email("wenerwagner@gmail.com")
                .name("Wener Castro")
                .password("Teste@123")
                .role(Role.USER)
                .build();

        userRepository.save(myUser);
        System.out.println("INFO: Users created.");
    }

    private void createSpreadsheets() {
        User myUser = userRepository.findByEmail("wenerwagner@gmail.com").get();

        Spreadsheet spreadsheet1 = Spreadsheet.builder()
                .name("Casa")
                .owner(myUser)
                .build();

        Spreadsheet spreadsheet2 = Spreadsheet.builder()
                .name("Pessoal")
                .owner(myUser)
                .build();

        spreadsheetRepository.save(spreadsheet1);
        spreadsheetRepository.save(spreadsheet2);
        System.out.println("INFO: Spreadsheets created.");
    }
}

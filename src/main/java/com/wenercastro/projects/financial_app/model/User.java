package com.wenercastro.projects.financial_app.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "users")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String password;
    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;
}

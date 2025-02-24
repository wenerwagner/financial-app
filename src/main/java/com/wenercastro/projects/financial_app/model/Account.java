package com.wenercastro.projects.financial_app.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.*;

@Table(name = "accounts")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long amount;

    @ManyToOne
    private Spreadsheet spreadsheet;
}

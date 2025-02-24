package com.wenercastro.projects.financial_app.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Set;

@Table(name = "spreadsheets")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Spreadsheet {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    private User owner;

    @OneToMany(mappedBy="spreadsheetr")
    private Set<MoneyAccount> accounts;
}

package com.wenercastro.projects.financial_app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;
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
    @JsonIgnore
    private User owner;

    @OneToMany(mappedBy = "spreadsheet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Budget> budgets;

}

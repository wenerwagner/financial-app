package com.wenercastro.projects.financial_app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Table(name = "budgets")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Budget {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private BigDecimal amount;
    private BigDecimal spent;

    @ManyToOne
    @JsonIgnore
    private Spreadsheet spreadsheet;
}

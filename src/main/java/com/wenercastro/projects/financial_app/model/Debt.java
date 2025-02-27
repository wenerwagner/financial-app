package com.wenercastro.projects.financial_app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Table(name = "debts")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Debt {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private BigDecimal amount;
    private BigDecimal paid;

    @ManyToOne
    @JsonIgnore
    private Spreadsheet spreadsheet;
}

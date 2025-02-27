package com.wenercastro.projects.financial_app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "credit_cards")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreditCard {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JsonIgnore
    private User owner;
}

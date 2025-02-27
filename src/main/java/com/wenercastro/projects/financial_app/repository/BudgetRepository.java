package com.wenercastro.projects.financial_app.repository;

import com.wenercastro.projects.financial_app.model.Budget;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BudgetRepository extends CrudRepository<Budget, Long> {
    List<Budget> findBySpreadsheetId(Long spreadsheetId);
    Optional<Budget> findByOwnerIdAndId(Long ownerId, Long id);
}
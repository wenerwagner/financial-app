package com.wenercastro.projects.financial_app.repository;

import com.wenercastro.projects.financial_app.model.Budget;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BudgetRepository extends CrudRepository<Budget, Long> {
    List<Budget> findBySpreadsheetId(Long spreadsheetId);
}
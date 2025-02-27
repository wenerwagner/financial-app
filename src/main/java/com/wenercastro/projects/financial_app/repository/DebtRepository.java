package com.wenercastro.projects.financial_app.repository;

import com.wenercastro.projects.financial_app.model.Debt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DebtRepository extends CrudRepository<Debt, Long> {
    List<Debt> findBySpreadsheetId(Long spreadsheetId);
}
package com.wenercastro.projects.financial_app.controller;

import com.wenercastro.projects.financial_app.model.Budget;
import com.wenercastro.projects.financial_app.model.Spreadsheet;
import com.wenercastro.projects.financial_app.repository.BudgetRepository;
import com.wenercastro.projects.financial_app.repository.SpreadsheetRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spreadsheets/{spreadsheetId}/budgets")
@AllArgsConstructor
public class BudgetController {

    private SpreadsheetRepository spreadsheetRepository;
    private BudgetRepository budgetRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void createBudget(@PathVariable Long spreadsheetId, @RequestBody Budget budget, HttpServletRequest request) {
        Spreadsheet spreadsheet = spreadsheetRepository.findById(spreadsheetId).get();
        budget.setSpreadsheet(spreadsheet);
        budgetRepository.save(budget);
    }

    @GetMapping("")
    List<Budget> getBudgets(@PathVariable Long spreadsheetId, HttpServletRequest request) {
        return budgetRepository.findBySpreadsheetId(spreadsheetId);
    }

    @GetMapping("/{id}")
    Budget getBudget(@PathVariable Long id) {
        return budgetRepository.findById(id).get();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteBudget(@PathVariable Long id, HttpServletRequest request) {
        budgetRepository.deleteById(id);
    }

}

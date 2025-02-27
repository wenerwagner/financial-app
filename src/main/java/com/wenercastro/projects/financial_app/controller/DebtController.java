package com.wenercastro.projects.financial_app.controller;

import com.wenercastro.projects.financial_app.model.Debt;
import com.wenercastro.projects.financial_app.model.Spreadsheet;
import com.wenercastro.projects.financial_app.repository.DebtRepository;
import com.wenercastro.projects.financial_app.repository.SpreadsheetRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spreadsheets/{spreadsheetId}/debts")
@AllArgsConstructor
public class DebtController {

    private SpreadsheetRepository spreadsheetRepository;
    private DebtRepository debtRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void createDebt(@PathVariable Long spreadsheetId, @RequestBody Debt debt, HttpServletRequest request) {
        Spreadsheet spreadsheet = spreadsheetRepository.findById(spreadsheetId).get();
        debt.setSpreadsheet(spreadsheet);
        debtRepository.save(debt);
    }

    @GetMapping("")
    List<Debt> getDebts(@PathVariable Long spreadsheetId, HttpServletRequest request) {
        return debtRepository.findBySpreadsheetId(spreadsheetId);
    }

    @GetMapping("/{id}")
    Debt getDebt(@PathVariable Long id) {
        return debtRepository.findById(id).get();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteDebt(@PathVariable Long id) {
        debtRepository.deleteById(id);
    }

}


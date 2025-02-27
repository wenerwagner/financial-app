package com.wenercastro.projects.financial_app.controller;

import com.wenercastro.projects.financial_app.model.Spreadsheet;
import com.wenercastro.projects.financial_app.model.User;
import com.wenercastro.projects.financial_app.repository.SpreadsheetRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.wenercastro.projects.financial_app.interceptor.AuthInterceptor.LOGGED_USER;

@RestController
@RequestMapping("/spreadsheets")
@AllArgsConstructor
public class SpreadsheetController {

    private SpreadsheetRepository spreadsheetRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void createSpreadsheet(@RequestBody Spreadsheet spreadsheet, HttpServletRequest request) {
        User owner = (User) request.getAttribute(LOGGED_USER);
        spreadsheet.setOwner(owner);
        spreadsheetRepository.save(spreadsheet);
    }

    @GetMapping("")
    List<Spreadsheet> getSpreadsheets(HttpServletRequest request) {
        User owner = (User) request.getAttribute(LOGGED_USER);
        return spreadsheetRepository.findByOwnerId(owner.getId());
    }

    @GetMapping("/{id}")
    Spreadsheet getSpreadsheet(@PathVariable Long id) {
        return spreadsheetRepository.findById(id).get();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteSpreadsheet(@PathVariable Long id, HttpServletRequest request) {
        spreadsheetRepository.deleteById(id);
    }
}

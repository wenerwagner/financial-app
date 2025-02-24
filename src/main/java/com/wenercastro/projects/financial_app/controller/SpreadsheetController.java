package com.wenercastro.projects.financial_app.controller;

import com.wenercastro.projects.financial_app.dto.CreateUpdateSpreadsheet;
import com.wenercastro.projects.financial_app.dto.SpreadsheetDTO;
import com.wenercastro.projects.financial_app.service.SpreadsheetService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.wenercastro.projects.financial_app.controller.UserController.validateUserId;

@RestController
@RequestMapping("/users/{userId}/spreadsheets")
@AllArgsConstructor
public class SpreadsheetController {

    private SpreadsheetService spreadsheetService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void createSpreadsheet(@PathVariable Long userId, @RequestBody CreateUpdateSpreadsheet spreadsheetData, HttpServletRequest request) {
        validateUserId(userId, request);
        spreadsheetService.createSpreadsheet(spreadsheetData);
    }

    @GetMapping("")
    List<SpreadsheetDTO> getSpreadsheets(@PathVariable Long userId, HttpServletRequest request) {
        validateUserId(userId, request);
        return spreadsheetService.findSpreadsheets(userId);
    }

    @GetMapping("/{id}")
    SpreadsheetDTO getSpreadsheet(@PathVariable Long userId, @PathVariable Long id, HttpServletRequest request) {
        validateUserId(userId, request);
        return spreadsheetService.getSpreadsheet(userId, id);
    }

    @PutMapping("/{id}")
    SpreadsheetDTO updateSpreadsheet(@PathVariable Long userId, @PathVariable Long id, @RequestBody CreateUpdateSpreadsheet spreadsheetData, HttpServletRequest request) {
        validateUserId(userId, request);
        return spreadsheetService.updateSpreadsheet(userId, id, spreadsheetData);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteSpreadsheet(@PathVariable Long userId, @PathVariable Long id, HttpServletRequest request) throws Exception {
        validateUserId(id, request);
        spreadsheetService.deleteSpreadsheet(userId, id);
    }
}

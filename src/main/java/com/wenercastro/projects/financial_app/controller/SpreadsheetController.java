package com.wenercastro.projects.financial_app.controller;

import com.wenercastro.projects.financial_app.dto.CreateSpreadsheet;
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
    void create(@PathVariable Long userId, @RequestBody CreateSpreadsheet spreadsheetData, HttpServletRequest request) {
        validateUserId(userId, request);
        spreadsheetService.createSpreadsheet(spreadsheetData);
    }

    @GetMapping("")
    List<SpreadsheetDTO> getSpreadsheets(@PathVariable Long userId, HttpServletRequest request) {
        validateUserId(userId, request);
        return spreadsheetService.findSpreadsheets(userId);
    }

    @GetMapping("/{id}")
    SpreadsheetDTO getSpreadsheets(@PathVariable Long userId, @PathVariable Long id, HttpServletRequest request) throws Exception {
        validateUserId(userId, request);
        return spreadsheetService.getSpreadsheetByOwnerIdAndId(userId, id);
    }
}

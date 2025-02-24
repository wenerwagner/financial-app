package com.wenercastro.projects.financial_app.controller;

import com.wenercastro.projects.financial_app.dto.CreateSpreadsheet;
import com.wenercastro.projects.financial_app.service.SpreadsheetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spreadsheets")
@AllArgsConstructor
public class SpreadsheetController {

    private SpreadsheetService spreadsheetService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@RequestBody CreateSpreadsheet spreadsheetData) {
        spreadsheetService.createSpreadsheet(spreadsheetData);
    }
}

package com.wenercastro.projects.financial_app.service;

import com.wenercastro.projects.financial_app.dto.CreateSpreadsheet;
import com.wenercastro.projects.financial_app.model.Role;
import com.wenercastro.projects.financial_app.model.Spreadsheet;
import com.wenercastro.projects.financial_app.model.User;
import com.wenercastro.projects.financial_app.repository.SpreadsheetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SpreadsheetService {

    private SpreadsheetRepository spreadsheetRepository;

    public void createSpreadsheet(CreateSpreadsheet spreadsheetData) {
        Spreadsheet spreadsheet = Spreadsheet.builder()
                .name(spreadsheetData.name())
                .build();
        spreadsheetRepository.save(spreadsheet);
    }
}

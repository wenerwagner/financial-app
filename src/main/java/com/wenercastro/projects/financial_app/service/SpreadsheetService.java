package com.wenercastro.projects.financial_app.service;

import com.wenercastro.projects.financial_app.dto.CreateSpreadsheet;
import com.wenercastro.projects.financial_app.dto.SpreadsheetDTO;
import com.wenercastro.projects.financial_app.dto.UserDTO;
import com.wenercastro.projects.financial_app.model.Role;
import com.wenercastro.projects.financial_app.model.Spreadsheet;
import com.wenercastro.projects.financial_app.model.User;
import com.wenercastro.projects.financial_app.repository.SpreadsheetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    public List<SpreadsheetDTO> getSpreadsheets() {
        List<Spreadsheet> spreadsheets = new ArrayList<>((Collection) spreadsheetRepository.findAll());
        return spreadsheets.stream().map(spreadsheet -> new SpreadsheetDTO(spreadsheet.getId(), spreadsheet.getName())).toList();
    }
}

package com.wenercastro.projects.financial_app.exception;

public class SpreadsheetNotFoundException extends RuntimeException {
    public SpreadsheetNotFoundException(String message) {
        super(message);
    }
}

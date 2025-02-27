package com.wenercastro.projects.financial_app.repository;

import com.wenercastro.projects.financial_app.model.Spreadsheet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpreadsheetRepository extends CrudRepository<Spreadsheet, Long> {
    List<Spreadsheet> findByOwnerId(Long ownerId);
    Optional<Spreadsheet> findByOwnerIdAndId(Long ownerId, Long id);
}

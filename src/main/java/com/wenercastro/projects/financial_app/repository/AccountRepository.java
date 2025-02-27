package com.wenercastro.projects.financial_app.repository;

import com.wenercastro.projects.financial_app.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {
    List<Account> findByOwnerId(Long ownerId);
    Optional<Account> findByOwnerIdAndId(Long ownerId, Long id);
}

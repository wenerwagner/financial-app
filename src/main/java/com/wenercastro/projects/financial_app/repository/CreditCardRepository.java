package com.wenercastro.projects.financial_app.repository;

import com.wenercastro.projects.financial_app.model.CreditCard;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CreditCardRepository extends CrudRepository<CreditCard, Long> {
    List<CreditCard> findByOwnerId(Long ownerId);
    Optional<CreditCard> findByOwnerIdAndId(Long ownerId, Long id);
}

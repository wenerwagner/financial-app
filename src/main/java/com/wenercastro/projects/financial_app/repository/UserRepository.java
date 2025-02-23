package com.wenercastro.projects.financial_app.repository;

import com.wenercastro.projects.financial_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}

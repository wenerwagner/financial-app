package com.wenercastro.projects.financial_app.controller;

import com.wenercastro.projects.financial_app.model.Account;
import com.wenercastro.projects.financial_app.model.User;
import com.wenercastro.projects.financial_app.repository.AccountRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.wenercastro.projects.financial_app.interceptor.AuthInterceptor.LOGGED_USER;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {

    private AccountRepository accountRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void createAccount(@RequestBody Account account, HttpServletRequest request) {
        User owner = (User) request.getAttribute(LOGGED_USER);
        account.setOwner(owner);
        accountRepository.save(account);
    }

    @GetMapping("")
    List<Account> getAccounts(HttpServletRequest request) {
        User owner = (User) request.getAttribute(LOGGED_USER);
        return accountRepository.findByOwnerId(owner.getId());
    }

    @GetMapping("/{id}")
    Account getAccount(@PathVariable Long id) {
        return accountRepository.findById(id).get();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteAccount(@PathVariable Long id, HttpServletRequest request) {
        accountRepository.deleteById(id);
    }
}

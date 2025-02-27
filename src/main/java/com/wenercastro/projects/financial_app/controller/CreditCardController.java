package com.wenercastro.projects.financial_app.controller;

import com.wenercastro.projects.financial_app.model.CreditCard;
import com.wenercastro.projects.financial_app.model.User;
import com.wenercastro.projects.financial_app.repository.CreditCardRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.wenercastro.projects.financial_app.interceptor.AuthInterceptor.LOGGED_USER;

@RestController
@RequestMapping("/credit-cards")
@AllArgsConstructor
public class CreditCardController {

    private CreditCardRepository creditCardRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void createCreditCard(@RequestBody CreditCard creditCard, HttpServletRequest request) {
        User owner = (User) request.getAttribute(LOGGED_USER);
        creditCard.setOwner(owner);
        creditCardRepository.save(creditCard);
    }

    @GetMapping("")
    List<CreditCard> getCreditCards(HttpServletRequest request) {
        User owner = (User) request.getAttribute(LOGGED_USER);
        return creditCardRepository.findByOwnerId(owner.getId());
    }

    @GetMapping("/{id}")
    CreditCard getCreditCard(@PathVariable Long id) {
        return creditCardRepository.findById(id).get();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteCreditCard(@PathVariable Long id, HttpServletRequest request) {
        creditCardRepository.deleteById(id);
    }
}

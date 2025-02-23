package com.wenercastro.projects.financial_app.controller;

import com.wenercastro.projects.financial_app.dto.AccessToken;
import com.wenercastro.projects.financial_app.dto.LoginData;
import com.wenercastro.projects.financial_app.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private AuthService authService;

    @PostMapping
    AccessToken login(@RequestBody LoginData loginData) throws Exception {
        return authService.login(loginData.email(), loginData.password());
    }
}

package com.wenercastro.projects.financial_app.service;

import com.wenercastro.projects.financial_app.dto.AccessToken;
import com.wenercastro.projects.financial_app.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private UserService userService;
    private JwtService jwtService;

    public AccessToken login(String email, String password) throws Exception {
        User user = userService.getUserByEmail(email);
        if (!user.getPassword().equals(password)) {
            throw new Exception("Wrong password");
        }
        return new AccessToken(jwtService.generateToken(email));
    }
}

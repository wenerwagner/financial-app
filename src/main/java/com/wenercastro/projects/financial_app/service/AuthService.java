package com.wenercastro.projects.financial_app.service;

import com.wenercastro.projects.financial_app.dto.AccessToken;
import com.wenercastro.projects.financial_app.model.User;
import com.wenercastro.projects.financial_app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private UserRepository userRepository;
    private JwtService jwtService;

    public AccessToken login(String email, String password) throws Exception {
        User user = userRepository.findByEmail(email).get();
        if (!user.getPassword().equals(password)) {
            throw new Exception("Wrong password");
        }
        return new AccessToken(jwtService.generateToken(email, user.getRole().name()));
    }
}

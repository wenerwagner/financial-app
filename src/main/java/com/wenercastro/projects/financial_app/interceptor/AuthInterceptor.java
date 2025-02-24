package com.wenercastro.projects.financial_app.interceptor;

import com.wenercastro.projects.financial_app.exception.UserNotFoundException;
import com.wenercastro.projects.financial_app.model.User;
import com.wenercastro.projects.financial_app.service.JwtService;
import com.wenercastro.projects.financial_app.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@AllArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private static final String AUTH_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";

    public static final String LOGGED_USER = "loggedUser";

    private JwtService jwtService;
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorizationHeader = request.getHeader(AUTH_HEADER);
        if (authorizationHeader != null && authorizationHeader.startsWith(BEARER_PREFIX)) {
            String token = authorizationHeader.substring(BEARER_PREFIX.length());
            if (jwtService.isTokenValid(token)) {
                String userEmail = jwtService.getEmailFromToken(token);
                try {
                    User user = userService.getUserByEmail(userEmail);
                    request.setAttribute(LOGGED_USER, user);
                } catch (UserNotFoundException ex) {
                    System.out.println("ERRO: email não encontrado");
                }

            }
        }
        return true;
    }
}



package com.wenercastro.projects.financial_app.interceptor;

import com.wenercastro.projects.financial_app.annotations.RequireAuth;
import com.wenercastro.projects.financial_app.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Arrays;

@Component
@AllArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private static final String AUTH_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";

    private JwtService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("PreHandle: Intercepting request...");
        System.out.println("Request URI: " + request.getRequestURI());

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            RequireAuth requireAuth = handlerMethod.getMethodAnnotation(RequireAuth.class);

            if (requireAuth != null) {
                System.out.println("Roles: " + Arrays.toString(requireAuth.value()));
            }
        }

        String authorizationHeader = request.getHeader(AUTH_HEADER);

        if (authorizationHeader != null && authorizationHeader.startsWith(BEARER_PREFIX)) {
            String token = authorizationHeader.substring(BEARER_PREFIX.length());

            if (jwtService.isTokenValid(token)) {
                System.out.println("VALID TOKEN");
                System.out.println("LOGGED AS " + jwtService.getUsernameFromToken(token));
            }

//            if (claims != null) {
//                // Supondo que você queira adicionar as informações do usuário na requisição
//                request.setAttribute("user", claims.getSubject()); // Exemplo de adicionar o usuário
//                request.setAttribute("permissions", claims.get("permissions", Collections.class)); // Exemplo de permissões
//            } else {
//                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                response.getWriter().write("Token inválido.");
//                return;
//            }
        }

        return true; // Continue processing the request
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, org.springframework.web.servlet.ModelAndView modelAndView) throws Exception {
        System.out.println("PostHandle: Processing request completed.");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("AfterCompletion: Request processing completed.");
    }
}



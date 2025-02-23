package com.wenercastro.projects.financial_app.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    private String secretKey = "minhaChaveSecretaasdsadsadsadasdasfsadasfasdsascadsdfasfsa";

    public String generateToken(String email, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        claims.put("email", email);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean isTokenValid(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody(); // Extrai os "claims" do token

            return !claims.getExpiration().before(new Date()); // Verifica se o token expirou
        } catch (Exception e) {
            return false; // Em caso de erro, o token é inválido
        }
    }

    public String getEmailFromToken(String token) {
        Jws<Claims> claimsJws = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token);

        return claimsJws.getBody().get("email", String.class);
    }

    public String getRoleFromToken(String token) {
        Jws<Claims> claimsJws = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token);

        return claimsJws.getBody().get("role", String.class);
    }
}

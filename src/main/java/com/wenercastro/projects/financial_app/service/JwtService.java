package com.wenercastro.projects.financial_app.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private String secretKey = "minhaChaveSecretaasdsadsadsadasdasfsadasfasdsascadsdfasfsa";

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
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

    public String getUsernameFromToken(String token) {
        Jws<Claims> claimsJws = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token);

        return claimsJws.getBody().getSubject(); // Retorna o "username" do token
    }
}

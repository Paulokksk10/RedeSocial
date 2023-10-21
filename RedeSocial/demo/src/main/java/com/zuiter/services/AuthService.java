package com.zuiter.services;

import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import java.util.Date;


@Service
public class AuthService {

    // Método para gerar um token de autenticação com base no nome de usuário
    public String gerarTokenDeAutenticacao(String email) {
        long tempoDeValidade = 24 * 60 * 60 * 1000; // Token expira em 24 horas
        
        String token = Jwts.builder()
                .subject(email) // Defina o assunto do JWT
                .issuedAt(new Date()) // Data de emissão do token
                .expiration(new Date(System.currentTimeMillis() + tempoDeValidade)) // Define a data de expiração do JWT// Data de expiração do token
                .compact();
        return token;
    }

    // Outros métodos para autenticar usuários, verificar credenciais, etc.
}

package com.zuiter.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthService {

    private static final String SECRET_KEY = "seu_segredo_secreto"; // Substitua isso por uma chave secreta real.

    public String gerarTokenDeAutenticacao(String username) {
        Date dataAtual = new Date();
        Date dataExpiracao = new Date(dataAtual.getTime() + 86400000); // Token expira em 24 horas

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(dataAtual)
                .setExpiration(dataExpiracao)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();

        return token;
    }
}

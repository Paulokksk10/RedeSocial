package com.zuiter.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zuiter.services.AuthService;
import com.zuiter.services.UsuarioService;
import com.zuiter.services.dto.LoginRequest;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthService authService;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        if (UsuarioService.validarCredenciais(loginRequest.getUsername(), loginRequest.getPassword())) {
            // Gere um token de autenticação (JWT) e retorne-o
            String token = authService.gerarTokenDeAutenticacao(loginRequest.getUsername());
            return ResponseEntity.ok("Token: " + token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
    }
}

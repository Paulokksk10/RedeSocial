package com.zuiter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zuiter.model.Postagem;
import com.zuiter.model.Usuario;
import com.zuiter.services.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Endpoint para criar um novo usuário
    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.criarUsuario(usuario);
    }

    // Endpoint para buscar um usuário pelo ID
    @GetMapping("/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.buscarUsuarioPorId(id);
    }

    // Endpoint para listar todos os amigos de um usuário
    @GetMapping("/{id}/amigos")
    public List<Usuario> listarAmigosDeUsuario(@PathVariable Long id) {
        return usuarioService.listarAmigosDeUsuario(id);
    }

    // Endpoint para listar todas as postagens de um usuário
    @GetMapping("/{id}/postagens")
    public List<Postagem> listarPostagensDeUsuario(@PathVariable Long id) {
        return usuarioService.listarPostagensDeUsuario(id);
    }
}


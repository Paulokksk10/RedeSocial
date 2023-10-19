package com.zuiter.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zuiter.model.Amizade;
import com.zuiter.model.Postagem;
import com.zuiter.model.RedeSocial;
import com.zuiter.model.Usuario;
import com.zuiter.services.RedeSocialService;

import java.util.List;

@RestController
@RequestMapping("/redesocial")
public class RedeSocialController {

    @Autowired
    private RedeSocialService redeSocialService;

    // Endpoint para criar uma nova rede social
    @PostMapping
    public RedeSocial criarRedeSocial(@RequestBody RedeSocial redeSocial) {
        return redeSocialService.criarRedeSocial(redeSocial);
    }

    // Endpoint para buscar uma rede social pelo ID
    @GetMapping("/{id}")
    public RedeSocial buscarRedeSocialPorId(@PathVariable Long id) {
        return redeSocialService.buscarRedeSocialPorId(id);
    }

    // Endpoint para listar todos os usuários de uma rede social
    @GetMapping("/{id}/usuarios")
    public List<Usuario> listarUsuariosDaRedeSocial(@PathVariable Long id) {
        return redeSocialService.listarUsuariosDaRedeSocial(id);
    }

    // Endpoint para listar todas as postagens de uma rede social
    @GetMapping("/{id}/postagens")
    public List<Postagem> listarPostagensDaRedeSocial(@PathVariable Long id) {
        return redeSocialService.listarPostagensDaRedeSocial(id);
    }

    // Endpoint para listar todas as amizades de uma rede social
    @GetMapping("/{id}/amizades")
    public List<Amizade> listarAmizadesDaRedeSocial(@PathVariable Long id) {
        return redeSocialService.listarAmizadesDaRedeSocial(id);
    }
}

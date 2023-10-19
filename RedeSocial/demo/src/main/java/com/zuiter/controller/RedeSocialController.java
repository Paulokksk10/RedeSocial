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
    @PostMapping
    public RedeSocial criarRedeSocial(@RequestBody RedeSocial redeSocial) {
        return redeSocialService.criarRedeSocial(redeSocial);
    }
    @GetMapping("/{id}")
    public RedeSocial buscarRedeSocialPorId(@PathVariable Long id) {
        return redeSocialService.buscarRedeSocialPorId(id);
    }
    @GetMapping("/{id}/usuarios")
    public List<Usuario> listarUsuariosDaRedeSocial(@PathVariable Long id) {
        return redeSocialService.listarUsuariosDaRedeSocial(id);
    }
    @GetMapping("/{id}/postagens")
    public List<Postagem> listarPostagensDaRedeSocial(@PathVariable Long id) {
        return redeSocialService.listarPostagensDaRedeSocial(id);
    }
    @GetMapping("/{id}/amizades")
    public List<Amizade> listarAmizadesDaRedeSocial(@PathVariable Long id) {
        return redeSocialService.listarAmizadesDaRedeSocial(id);
    }
}

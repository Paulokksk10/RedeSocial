package com.zuiter.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zuiter.model.Curtida;
import com.zuiter.model.Postagem;
import com.zuiter.services.PostagemService;

import java.util.List;

@RestController
@RequestMapping("/postagem")
public class PostagemController {

    @Autowired
    private PostagemService postagemService;
    @PostMapping
    public Postagem criarPostagem(@RequestBody Postagem postagem) {
        return postagemService.criarPostagem(postagem);
    }
    @GetMapping("/{id}")
    public Postagem buscarPostagemPorId(@PathVariable Long id) {
        return postagemService.buscarPostagemPorId(id);
    }
    @GetMapping("/{id}/curtidas")
    public List<Curtida> listarCurtidasDaPostagem(@PathVariable Long id) {
        return postagemService.listarCurtidasDaPostagem(id);
    }
}


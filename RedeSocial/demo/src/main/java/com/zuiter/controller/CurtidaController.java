package com.zuiter.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zuiter.model.Curtida;
import com.zuiter.services.CurtidaService;
import java.util.List;

@RestController
@RequestMapping("/curtida")
public class CurtidaController {

    @Autowired
    private CurtidaService curtidaService;

    // Endpoint para criar uma nova curtida
    @PostMapping
    public Curtida criarCurtida(@RequestBody Curtida curtida) {
        return curtidaService.criarCurtida(curtida);
    }

    // Endpoint para buscar uma curtida pelo ID
    @GetMapping("/{id}")
    public Curtida buscarCurtidaPorId(@PathVariable Long id){
        return curtidaService.buscarCurtidaPorId(id);
    }

    // Endpoint para listar todas as curtidas dadas por um usuário
    @GetMapping("/usuario/{id}")
    public List<Curtida> listarCurtidasDeUsuario(@PathVariable Long id) {
        return curtidaService.listarCurtidasDeUsuario(id);
    }

    // Endpoint para listar todas as curtidas em uma publicação
    @GetMapping("/publicacao/{id}")
    public List<Curtida> listarCurtidasEmPublicacao(@PathVariable Long id) {
        return curtidaService.listarCurtidasEmPublicacao(id);
    }
}

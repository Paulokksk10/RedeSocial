package com.zuiter.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zuiter.model.Amizade;
import com.zuiter.services.AmizadeService;

import java.util.List;

@RestController
@RequestMapping("/amizade")
public class AmizadeController {

    @Autowired
    private AmizadeService amizadeService;

    // Endpoint para criar uma nova amizade
    @PostMapping
    public Amizade criarAmizade(@RequestBody Amizade amizade) {
        return amizadeService.criarAmizade(amizade);
    }

    // Endpoint para buscar uma amizade pelo ID
    @GetMapping("/{id}")
    public Amizade buscarAmizadePorId(@PathVariable Long id) {
        return amizadeService.buscarAmizadePorId(id);
    }

    // Endpoint para listar todas as amizades de um usuário
    @GetMapping("/usuario/{id}")
    public List<Amizade> listarAmizadesDeUsuario(@PathVariable Long id) {
        return amizadeService.listarAmizadesDeUsuario(id);
    }
}

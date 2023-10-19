package com.zuiter.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuiter.model.Amizade;
import com.zuiter.repository.AmizadeRepository;
import com.zuiter.services.exception.AmizadeNaoEncontradaException;

@Service
public class AmizadeService {
    private final AmizadeRepository amizadeRepository;
    @Autowired
    public AmizadeService(AmizadeRepository amizadeRepository){
        this.amizadeRepository = amizadeRepository;
    }

    public Amizade criarAmizade(Amizade amizade){
        return amizadeRepository.save(amizade);
    }

    public Amizade buscarAmizadePorId(Long id) {
        Optional<Amizade> amizade = amizadeRepository.findById(id);
        if (amizade.isPresent()) {
            return amizade.get();
        } else {
            // Trate o caso em que a amizade não foi encontrada, por exemplo, lançando uma exceção.
            throw new AmizadeNaoEncontradaException("Amizade não encontrada com ID: " + id);
        }
    }

    public List<Amizade> listarAmizadesDeUsuario(Long idUsuario) {
        return amizadeRepository.findByUsuario1IdOrUsuario2Id(idUsuario, idUsuario);
    }
}

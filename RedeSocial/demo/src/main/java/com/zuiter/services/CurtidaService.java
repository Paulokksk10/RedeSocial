package com.zuiter.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuiter.model.Curtida;
import com.zuiter.repository.CurtidaRepository;
import com.zuiter.services.exception.CurtidaNaoEncontradaException;

import java.util.List;
import java.util.Optional;

@Service
public class CurtidaService {

    private final CurtidaRepository curtidaRepository;

    @Autowired
    public CurtidaService(CurtidaRepository curtidaRepository) {
        this.curtidaRepository = curtidaRepository;
    }

    public Curtida criarCurtida(Curtida curtida) {
        // Adicione qualquer lógica de validação ou pré-processamento aqui, se necessário.
        return curtidaRepository.save(curtida);
    }

    public Curtida buscarCurtidaPorId(Long id){
        Optional<Curtida> curtida = curtidaRepository.findById(id);
        if (curtida.isPresent()) {
            return curtida.get();
        } else {
            // Trate o caso em que a curtida não foi encontrada, por exemplo, lançando uma exceção.
            throw new CurtidaNaoEncontradaException("Curtida não encontrada com ID: " + id);
        }
    }

    public List<Curtida> listarCurtidasDeUsuario(Long idUsuario) {
        return curtidaRepository.findByUsuarioId(idUsuario);
    }

    public List<Curtida> listarCurtidasEmPublicacao(Long idPublicacao) {
        return curtidaRepository.findByPublicacaoId(idPublicacao);
    }
}

package com.zuiter.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuiter.model.Amizade;
import com.zuiter.model.Postagem;
import com.zuiter.model.RedeSocial;
import com.zuiter.model.Usuario;
import com.zuiter.repository.RedeSocialRepository;
import com.zuiter.services.exception.RedeSocialNaoEncontradaException;

import java.util.List;
import java.util.Optional;

@Service
public class RedeSocialService {

    private final RedeSocialRepository redeSocialRepository;

    @Autowired
    public RedeSocialService(RedeSocialRepository redeSocialRepository) {
        this.redeSocialRepository = redeSocialRepository;
    }

    public RedeSocial criarRedeSocial(RedeSocial redeSocial) {
        return redeSocialRepository.save(redeSocial);
    }

    public RedeSocial buscarRedeSocialPorId(Long id) {
        Optional<RedeSocial> redeSocial = redeSocialRepository.findById(id);
        if (redeSocial.isPresent()) {
            return redeSocial.get();
        } else {
            throw new RedeSocialNaoEncontradaException("Rede Social não encontrada com ID: " + id);
        }
    }

    public List<Usuario> listarUsuariosDaRedeSocial(Long id) {
        RedeSocial redeSocial = buscarRedeSocialPorId(id);
        return redeSocial.getUsuarios();
    }

    public List<Postagem> listarPostagensDaRedeSocial(Long id) {
        RedeSocial redeSocial = buscarRedeSocialPorId(id);
        return redeSocial.getPostagems();
    }

    public List<Amizade> listarAmizadesDaRedeSocial(Long id) {
        RedeSocial redeSocial = buscarRedeSocialPorId(id);
        return redeSocial.getAmizades();
    }
}

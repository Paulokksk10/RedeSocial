package com.zuiter.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuiter.model.Curtida;
import com.zuiter.model.Postagem;
import com.zuiter.repository.PostagemRepository;
import com.zuiter.services.exception.PostagemNaoEncontradaException;;

@Service
public class PostagemService {

    private final PostagemRepository postagemRepository;

    @Autowired
    public PostagemService(PostagemRepository postagemRepository) {
        this.postagemRepository = postagemRepository;
    }

    public Postagem criarPostagem(Postagem postagem) {
        // Adicione qualquer lógica de validação ou pré-processamento aqui, se necessário.
        return postagemRepository.save(postagem);
    }

    public Postagem buscarPostagemPorId(Long id) {
        Optional<Postagem> postagem = postagemRepository.findById(id);
        if (postagem.isPresent()) {
            return postagem.get();
        } else {
            // Trate o caso em que a postagem não foi encontrada, por exemplo, lançando uma exceção.
            throw new PostagemNaoEncontradaException("Postagem não encontrada com ID: " + id);
        }
    }

    public List<Curtida> listarCurtidasDaPostagem(Long id) {
        Postagem postagem = buscarPostagemPorId(id);
        return postagem.getListaCurtidas();
    }
}

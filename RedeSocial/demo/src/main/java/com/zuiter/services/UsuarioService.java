package com.zuiter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuiter.model.Postagem;
import com.zuiter.model.Usuario;
import com.zuiter.repository.UsuarioRepository;
import com.zuiter.services.exception.UsuarioNaoEncontradoException;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;   
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criarUsuario(Usuario usuario) {
        // Adicione qualquer lógica de validação ou pré-processamento aqui, se necessário.
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarUsuarioPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return usuario.get();
        } else {
            // Trate o caso em que o usuário não foi encontrado, por exemplo, lançando uma exceção.
            throw new UsuarioNaoEncontradoException("Usuário não encontrado com ID: " + id);
        }
    }

    public List<Usuario> listarAmigosDeUsuario(Long idUsuario) {
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        List<Usuario> amigos = usuario.getAmizades();
        amigos.remove(usuario); // Remove o próprio usuário da lista de amigos
        return amigos;
    }

    public List<Postagem> listarPostagensDeUsuario(Long idUsuario) {
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        return usuario.getPostagens();
    }

    public boolean validarCredenciais(String email, String password) {
        // Primeiro, busque o usuário pelo email no banco de dados
        Usuario usuario = usuarioRepository.getUsuarioByEmail(email);

        // Verifique se o usuário com o email fornecido foi encontrado
        if (usuario == null) {
            return false; // Usuário não encontrado
        }

        // Agora, verifique se a senha fornecida corresponde à senha armazenada no banco de dados.
        // Este é um exemplo simples, recomenda-se usar uma solução de criptografia adequada para senhas.
        if (usuario.getPassword().equals(password)) {
            return true; // Senha válida
        }

        return false; // Senha incorreta
    }
}



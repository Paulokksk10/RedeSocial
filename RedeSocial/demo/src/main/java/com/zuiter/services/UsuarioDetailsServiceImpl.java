package com.zuiter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.zuiter.model.UserDetailsImpl;
import com.zuiter.model.Usuario;
import com.zuiter.repository.UsuarioRepository;

public class UsuarioDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepo.getUsuarioByEmail(email);
        if (usuario == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        return new UserDetailsImpl(usuario);
    }
}

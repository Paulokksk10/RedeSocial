package com.zuiter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zuiter.model.Curtida;

public interface CurtidaRepository extends JpaRepository<Curtida, Long>{

    List<Curtida> findByPublicacaoId(Long idPublicacao);
    List<Curtida> findByUsuarioId(Long idUsuario);
}

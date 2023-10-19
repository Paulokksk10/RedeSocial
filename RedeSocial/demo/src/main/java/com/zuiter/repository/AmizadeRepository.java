package com.zuiter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zuiter.model.Amizade;

public interface AmizadeRepository extends JpaRepository<Amizade, Long>{

    List<Amizade> findByUsuario1IdOrUsuario2Id(Long idUsuario, Long idUsuario2);
}

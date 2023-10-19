package com.zuiter.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zuiter.model.RedeSocial;

@Repository
public interface RedeSocialRepository extends JpaRepository<RedeSocial, Long> {
}


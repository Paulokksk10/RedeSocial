package com.zuiter.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Amizade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataPublicacao;
    private List<Usuario> usuario1;
    private List<Usuario> usuario2;
    public Amizade() {
    }
    public Amizade(Date dataPublicacao, List<Usuario> usuario1, List<Usuario> usuario2) {
        this.dataPublicacao = dataPublicacao;
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getDataPublicacao() {
        return dataPublicacao;
    }
    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
    public List<Usuario> getUsuario1() {
        return usuario1;
    }
    public void setUsuario1(List<Usuario> usuario1) {
        this.usuario1 = usuario1;
    }
    public List<Usuario> getUsuario2() {
        return usuario2;
    }
    public void setUsuario2(List<Usuario> usuario2) {
        this.usuario2 = usuario2;
    }
    @Override
    public String toString() {
        return "Amizade [id=" + id + ", dataPublicacao=" + dataPublicacao + ", usuario1=" + usuario1 + ", usuario2="
                + usuario2 + "]";
    }

    
}

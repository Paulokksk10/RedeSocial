package com.zuiter.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Postagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String conteudoPublicacao;
    private Date dataPublicacao;
    private String localizacao;

    private List<Usuario> autorPublicacao;
    private List<Curtida> listaCurtidas;
    public Postagem() {
    }
    public Postagem(String conteudoPublicacao, Date dataPublicacao, String localizacao, List<Usuario> autorPublicacao,
            List<Curtida> listaCurtidas) {
        this.conteudoPublicacao = conteudoPublicacao;
        this.dataPublicacao = dataPublicacao;
        this.localizacao = localizacao;
        this.autorPublicacao = autorPublicacao;
        this.listaCurtidas = listaCurtidas;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getConteudoPublicacao() {
        return conteudoPublicacao;
    }
    public void setConteudoPublicacao(String conteudoPublicacao) {
        this.conteudoPublicacao = conteudoPublicacao;
    }
    public Date getDataPublicacao() {
        return dataPublicacao;
    }
    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    public List<Usuario> getAutorPublicacao() {
        return autorPublicacao;
    }
    public void setAutorPublicacao(List<Usuario> autorPublicacao) {
        this.autorPublicacao = autorPublicacao;
    }
    public List<Curtida> getListaCurtidas() {
        return listaCurtidas;
    }
    public void setListaCurtidas(List<Curtida> listaCurtidas) {
        this.listaCurtidas = listaCurtidas;
    }
    @Override
    public String toString() {
        return "Postagem [id=" + id + ", conteudoPublicacao=" + conteudoPublicacao + ", dataPublicacao="
                + dataPublicacao + ", localizacao=" + localizacao + ", autorPublicacao=" + autorPublicacao
                + ", listaCurtidas=" + listaCurtidas  + "]";
    }
    
    
    
}

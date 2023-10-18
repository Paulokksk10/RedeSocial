package com.zuiter.model;


import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Curtida {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataCurtida;

    private List<Usuario> usuarioCurtida;
    private List<Postagem> publicacaoCurtida;
    public Curtida() {
    }
    public Curtida(Date dataCurtida, List<Usuario> usuarioCurtida, List<Postagem> publicacaoCurtida) {
        this.dataCurtida = dataCurtida;
        this.usuarioCurtida = usuarioCurtida;
        this.publicacaoCurtida = publicacaoCurtida;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getDataCurtida() {
        return dataCurtida;
    }
    public void setDataCurtida(Date dataCurtida) {
        this.dataCurtida = dataCurtida;
    }
    public List<Usuario> getUsuarioCurtida() {
        return usuarioCurtida;
    }
    public void setUsuarioCurtida(List<Usuario> usuarioCurtida) {
        this.usuarioCurtida = usuarioCurtida;
    }
    public List<Postagem> getPublicacaoCurtida() {
        return publicacaoCurtida;
    }
    public void setPublicacaoCurtida(List<Postagem> publicacaoCurtida) {
        this.publicacaoCurtida = publicacaoCurtida;
    }
    @Override
    public String toString() {
        return "Curtida [id=" + id + ", dataCurtida=" + dataCurtida + ", usuarioCurtida=" + usuarioCurtida
                + ", publicacaoCurtida=" + publicacaoCurtida + "]";
    }
    
        
}

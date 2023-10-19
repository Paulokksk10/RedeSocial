package com.zuiter.model;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
/* import jakarta.persistence.Table; */

@Entity
/* @Table(name="atleta") */
public class RedeSocial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private List<Usuario> usuarios;
    private List<Postagem> postagems;
    private List<Amizade> amizades;
    
    
    public RedeSocial(String nome, List<Usuario> usuarios, List<Postagem> postagems, List<Amizade> amizades) {
        this.nome = nome;
        this.usuarios = usuarios;
        this.postagems = postagems;
        this.amizades = amizades;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public List<Usuario> getUsuarios() {
        return usuarios;
    }


    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }


    public List<Postagem> getPostagems() {
        return postagems;
    }


    public void setPostagems(List<Postagem> postagems) {
        this.postagems = postagems;
    }


    public List<Amizade> getAmizades() {
        return amizades;
    }


    public void setAmizades(List<Amizade> amizades) {
        this.amizades = amizades;
    }


    @Override
    public String toString() {
        return "RedeSocial [id=" + id + ", nome=" + nome + ", usuarios=" + usuarios + ", postagems=" + postagems
                + ", amizades=" + amizades + "]";
    }

    
/*     public void atualizaRedeSocial(RedeSocialUpdateDados dados){
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.peso = dados.peso();
        this.altura = dados.altura();
    } */


}
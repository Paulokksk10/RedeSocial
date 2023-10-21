package com.zuiter.model;

import java.util.List;

import javax.xml.crypto.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private Data dataNascimento;
    private String fotoPerfilUrl;
    private String biografia;
    private String password;
    private String role;
    
    @OneToMany(mappedBy = "usuario")
    private List<Usuario> amizades;

    @OneToMany(mappedBy = "autor")
    private List<Postagem> postagens;
    
    public Usuario() {
    }

    public Usuario(Long id, String nome, String email, Data dataNascimento, String fotoPerfilUrl, String biografia, String password, String role) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.fotoPerfilUrl = fotoPerfilUrl;
        this.biografia = biografia;
        this.password = password;
        this.role = role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getFotoPerfilUrl() {
        return fotoPerfilUrl;
    }

    public void setFotoPerfilUrl(String fotoPerfilUrl) {
        this.fotoPerfilUrl = fotoPerfilUrl;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Usuario> getAmizades() {
        return amizades;
    }

    public void setAmizades(List<Usuario> amizades) {
        this.amizades = amizades;
    }

    public List<Postagem> getPostagens() {
        return postagens;
    }

    public void setPostagens(List<Postagem> postagens) {
        this.postagens = postagens;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", fotoPerfil='" + fotoPerfilUrl + '\'' +
                ", biografia='" + biografia + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    
}


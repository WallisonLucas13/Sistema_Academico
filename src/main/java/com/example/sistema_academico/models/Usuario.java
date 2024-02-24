package com.example.sistema_academico.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @JsonIgnore
    @Column
    private String password;

    @OneToOne
    private Matricula matricula;

    @Column
    private String email;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPassword() {
        return password;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public static class UsuarioBuilder{
        Usuario usuario = new Usuario();

        public static UsuarioBuilder builder(){
            return new UsuarioBuilder();
        }

        public UsuarioBuilder nome(String nome){
            usuario.nome = nome;
            return this;
        }

        public UsuarioBuilder password(String password){
            usuario.password = password;
            return this;
        }

        public UsuarioBuilder email(String email){
            usuario.email = email;
            return this;
        }

        public Usuario build(){
            return usuario;
        }
    }
}

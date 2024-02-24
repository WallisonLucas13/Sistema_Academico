package com.example.sistema_academico.models;

import com.example.sistema_academico.enums.TipoAcademico;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String formacao;

    @ManyToMany
    private List<Turma> turmas;

    @OneToOne
    private Pessoa pessoa;

    @JsonIgnore
    @OneToOne
    private Usuario usuario;

    @OneToOne
    private Matricula matricula;

    public Long getId() {
        return id;
    }

    public String getFormacao() {
        return formacao;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public static class ProfessorBuilder{

        private Professor professor = new Professor();

        public static ProfessorBuilder builder(){
            return new ProfessorBuilder();
        }

        public ProfessorBuilder formacao(String formacao){
            professor.formacao = formacao;
            return this;
        }

        public ProfessorBuilder turmas(List<Turma> turmas){
            professor.turmas = turmas;
            return this;
        }

        public ProfessorBuilder usuario(Usuario usuario){
            professor.usuario = usuario;
            return this;
        }

        public ProfessorBuilder pessoa(Pessoa pessoa){
            professor.pessoa = pessoa;
            return this;
        }

        public Professor build(){
            professor.matricula = Matricula.MatriculaBuilder.builder()
                    .tipoAcademico(TipoAcademico.PROFESSOR)
                    .build();

            return professor;
        }
    }
}

package com.example.sistema_academico.models;

import com.example.sistema_academico.enums.TipoCurso;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    private String nome;

    @Column
    @OneToMany(cascade = CascadeType.ALL)
    private List<Turma> turmas;

    @Column
    @OneToMany
    private List<Materia> materias;

    @Enumerated(EnumType.STRING)
    @NotNull
    private TipoCurso tipo;

    @Column
    private String duracao;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public TipoCurso getTipo() {
        return tipo;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public void setTipo(TipoCurso tipo) {
        this.tipo = tipo;
    }

    public static class CursoBuilder{

        private Curso curso = new Curso();

        public static CursoBuilder builder(){
            return new CursoBuilder();
        }

        public CursoBuilder nome(String nome){
             curso.nome = nome;
             return this;
        }

        public CursoBuilder turmas(List<Turma> turmas){
            curso.turmas = turmas;
            return this;
        }

        public CursoBuilder materias(List<Materia> materias){
            curso.materias = materias;
            return this;
        }

        public CursoBuilder tipo(TipoCurso tipo){
            curso.tipo = tipo;
            return this;
        }

        public Curso build(){
            switch (curso.tipo){
                case TECNOLOGO: curso.duracao = "2,5 anos";break;
                default: curso.duracao = "5 anos";
            }
            return curso;
        }

    }
}

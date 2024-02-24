package com.example.sistema_academico.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @ManyToMany
    private List<Curso> cursos;

    @Column
    @OneToMany(cascade = CascadeType.ALL)
    private List<Aula> aulas;

    @Column
    @ManyToMany
    private List<Professor> professores;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public static class MateriaBuilder{

        private Materia materia = new Materia();

        public static MateriaBuilder builder(){
            return new MateriaBuilder();
        }

        public MateriaBuilder nome(String nome){
            materia.nome = nome;
            return this;
        }

        public MateriaBuilder cursos(List<Curso> cursos){
            materia.cursos = cursos;
            return this;
        }

        public MateriaBuilder aulas(List<Aula> aulas){
            materia.aulas = aulas;
            return this;
        }

        public MateriaBuilder professores(List<Professor> professores){
            materia.professores = professores;
            return this;
        }

        public Materia build(){
            return materia;
        }

    }
}

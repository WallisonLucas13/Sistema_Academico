package com.example.sistema_academico.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String sigla;

    @ManyToOne
    private Curso curso;

    @ManyToMany
    private List<Professor> professores;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Aluno> alunos;

    @OneToOne(cascade = CascadeType.ALL)
    private Aluno alunoRepresentante;

    public Long getId() {
        return id;
    }

    public String getSigla() {
        return sigla;
    }

    public Curso getCurso() {
        return curso;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public Aluno getAlunoRepresentante() {
        return alunoRepresentante;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void setAlunoRepresentante(Aluno alunoRepresentante) {
        this.alunoRepresentante = alunoRepresentante;
    }

    public static class TurmaBuilder{

        private Turma turma = new Turma();

        public static TurmaBuilder builder(){
            return new TurmaBuilder();
        }

        public TurmaBuilder sigla(String sigla){
            turma.sigla = sigla;
            return this;
        }

        public TurmaBuilder curso(Curso curso){
            turma.curso = curso;
            return this;
        }

        public TurmaBuilder professores(List<Professor> professores){
            turma.professores = professores;
            return this;
        }

        public TurmaBuilder alunos(List<Aluno> alunos){
            turma.alunos = alunos;
            return this;
        }

        public TurmaBuilder alunoRepresentante(Aluno aluno){
            turma.alunoRepresentante = aluno;
            return this;
        }

        public Turma build(){
            return turma;
        }

    }
}

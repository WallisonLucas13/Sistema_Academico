package com.example.sistema_academico.models;

import jakarta.persistence.*;

@Entity
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long nAula;

    @ManyToOne
    private Materia materia;

    @OneToOne
    private Professor professor;

    public Long getId() {
        return id;
    }

    public Long getnAula() {
        return nAula;
    }

    public Materia getMateria() {
        return materia;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setnAula(Long nAula) {
        this.nAula = nAula;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public static class AulaBuilder{
        private Aula aula = new Aula();

        public static AulaBuilder builder(){
            return new AulaBuilder();
        }

        public AulaBuilder nAula(Long nAula){
            aula.nAula = nAula;
            return this;
        }

        public AulaBuilder materia(Materia materia){
            aula.materia = materia;
            return this;
        }

        public AulaBuilder professor(Professor professor){
            aula.professor = professor;
            return this;
        }

        public Aula build(){
            return aula;
        }
    }
}

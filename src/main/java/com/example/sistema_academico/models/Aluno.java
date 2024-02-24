package com.example.sistema_academico.models;

import com.example.sistema_academico.enums.TipoAcademico;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Matricula matricula;

    @ManyToOne
    private Turma turma;

    @OneToOne
    private Pessoa pessoa;

    @JsonIgnore
    @OneToOne
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public Turma getTurma() {
        return turma;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public static class AlunoBuilder{
        private Aluno aluno = new Aluno();

        public static AlunoBuilder builder(){
            return new AlunoBuilder();
        }

        public AlunoBuilder turma(Turma turma){
            aluno.turma = turma;
            return this;
        }

        public AlunoBuilder pessoa(Pessoa pessoa){
            aluno.pessoa = pessoa;
            return this;
        }

        public AlunoBuilder usuario(Usuario usuario){
            aluno.usuario = usuario;
            return this;
        }

        public Aluno build(){
            aluno.matricula = Matricula.MatriculaBuilder.builder()
                    .tipoAcademico(TipoAcademico.ALUNO)
                    .build();

            return aluno;
        }
    }
}

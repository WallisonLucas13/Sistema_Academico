package com.example.sistema_academico.models;

import com.example.sistema_academico.enums.TipoAcademico;
import com.example.sistema_academico.services.GeradorMatriculaService;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

@Entity
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoAcademico tipoAcademico;

    @Column
    private String matricula;

    public TipoAcademico getTipoAcademico() {
        return tipoAcademico;
    }

    public String getMatricula() {
        return matricula;
    }

    public static class MatriculaBuilder{

        private final GeradorMatriculaService geradorMatriculaService = new GeradorMatriculaService();

        private Matricula matricula = new Matricula();

        public static MatriculaBuilder builder(){
            return new MatriculaBuilder();
        }

        public MatriculaBuilder tipoAcademico(TipoAcademico tipoAcademico){
            matricula.tipoAcademico = tipoAcademico;
            return this;
        }

        public Matricula build(){
            matricula.matricula = geradorMatriculaService.gerarMatricula(matricula.tipoAcademico);
            return matricula;
        }

    }
}

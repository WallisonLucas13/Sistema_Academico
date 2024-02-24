package com.example.sistema_academico.models;

import com.example.sistema_academico.enums.TipoAcademico;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Random;

@Entity
public class Matricula {

    @Enumerated(EnumType.STRING)
    private TipoAcademico tipoAcademico;

    @Column
    private String matricula;

    public static class MatriculaBuilder{

        private Matricula matricula = new Matricula();

        public static MatriculaBuilder builder(){
            return new MatriculaBuilder();
        }

        public MatriculaBuilder tipoAcademico(TipoAcademico tipoAcademico){
            matricula.tipoAcademico = tipoAcademico;
            return this;
        }

        public Matricula build(){
            matricula.matricula = builder().GerarMatricula(matricula.tipoAcademico);
            return matricula;
        }

        //FUNÇÃO RESPONSÁVEL POR GERAR UMA MATRICULA ALEATÓRIA DE 8 DÍGITOS
        private String GerarMatricula(TipoAcademico tipoAcademico){

            int size = 8;
            Random random = new Random();
            String matricula = "";

            for (int i = 0; i <= size; i++) {
                matricula += String.valueOf(random.nextInt(10));
            }

            if(tipoAcademico.name().equals("ALUNO")){
                matricula += "AL";
                return matricula;
            }

            matricula += "PR";
            return matricula;

        }
    }
}

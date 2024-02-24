package com.example.sistema_academico.services;

import com.example.sistema_academico.enums.TipoAcademico;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GeradorMatriculaService {

    private final int size = 8;

    private Random random = new Random();

    //FUNÇÃO RESPONSÁVEL POR GERAR UMA MATRICULA ALEATÓRIA DE 8 DÍGITOS
    public String gerarMatricula(TipoAcademico tipoAcademico){

        String matricula = "";

        for (int i = 0; i < size; i++) {
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

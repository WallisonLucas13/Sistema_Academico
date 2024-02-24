package com.example.sistema_academico.services;

import com.example.sistema_academico.enums.TipoAcademico;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GeradorMatriculaServiceTest {

    @InjectMocks
    private GeradorMatriculaService geradorMatriculaService;

    @Test
    public void deveGerarMatriculaDeAluno(){
        //Acao
        String matricula = geradorMatriculaService.gerarMatricula(TipoAcademico.ALUNO);

        //Verification
        Assert.assertEquals(matricula.length(), 10);
        Assert.assertTrue(matricula.contains("AL"));
    }

    @Test
    public void deveGerarMatriculaDeProfessor(){
        //Acao
        String matricula = geradorMatriculaService.gerarMatricula(TipoAcademico.PROFESSOR);

        //Verification
        Assert.assertEquals(matricula.length(), 10);
        Assert.assertTrue(matricula.contains("PR"));
    }
}

package com.example.sistema_academico.services;

import com.example.sistema_academico.enums.TipoAcademico;
import com.example.sistema_academico.models.Matricula;
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
        Matricula matricula = Matricula.MatriculaBuilder.builder()
                .tipoAcademico(TipoAcademico.ALUNO)
                .build();

        //Verification
        Assert.assertEquals(10, matricula.getMatricula().length());
        Assert.assertEquals(TipoAcademico.ALUNO, matricula.getTipoAcademico());
        Assert.assertTrue(matricula.getMatricula().contains("AL"));
    }

    @Test
    public void deveGerarMatriculaDeProfessor(){
        //Acao
        Matricula matricula = Matricula.MatriculaBuilder.builder()
                .tipoAcademico(TipoAcademico.PROFESSOR)
                .build();

        //Verification
        Assert.assertEquals(10, matricula.getMatricula().length());
        Assert.assertEquals(TipoAcademico.PROFESSOR, matricula.getTipoAcademico());
        Assert.assertTrue(matricula.getMatricula().contains("PR"));
    }
}

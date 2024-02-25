package com.example.sistema_academico.services;

import com.example.sistema_academico.enums.TipoCurso;
import com.example.sistema_academico.models.Curso;
import com.example.sistema_academico.repositories.CursoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

//Melhor para testes em Camadas de Service etc... Quando o acesso a função testada é interno
//Sem que haja a interação com protocolos HTTP
@RunWith(MockitoJUnitRunner.class)
public class CursoServiceTest {

    //Mock mocka apenas o Repository
    @Mock
    private CursoRepository repository;

    //InjectMocks injeta os mocks na classe alvo de teste
    @InjectMocks
    private CursoService cursoService;

    @Test
    public void deveSalvarUmCurso(){

        //Cenario
        Curso curso = Curso.CursoBuilder.builder()
                .nome("Análise e Desenvolvimento de Sistemas")
                .tipo(TipoCurso.TECNOLOGO)
                .build();

        //Mocking
        Mockito.when(repository.save(any())).thenReturn(curso);

        //Acao
        boolean result = cursoService.save(curso);

        //Verification
        Assert.assertTrue(result);
        Mockito.verify(repository, Mockito.times(1)).save(any());

    }

    @Test
    public void deveRetornarErroAoSalvarUmCursoQueJaExiste(){

        //Cenario
        Curso curso = Curso.CursoBuilder.builder()
                .nome("Análise e Desenvolvimento de Sistemas")
                .tipo(TipoCurso.TECNOLOGO)
                .build();

        //Mocking
        Mockito.when(repository.findByNome(any())).thenReturn(Optional.of(curso));

        //Acao
        boolean result = cursoService.save(curso);

        //Verification
        Assert.assertFalse(result);
        Mockito.verify(repository, Mockito.times(0)).save(any());
        Mockito.verify(repository, Mockito.times(1)).findByNome(any());

    }
}

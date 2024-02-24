package com.example.sistema_academico.controllers;

import com.example.sistema_academico.enums.TipoCurso;
import com.example.sistema_academico.models.Curso;
import com.example.sistema_academico.repositories.CursoRepository;
import com.example.sistema_academico.services.CursoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CursoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CursoService cursoService;

    @Mock
    private CursoRepository cursoRepository;

    @InjectMocks
    private CursoController cursoController;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void deveRetornarStatusOKSalvarCurso() throws Exception {

        //Cenario
        Curso curso = Curso.CursoBuilder.builder()
                .nome("Análise e Desenvolvimento de Sistemas")
                .tipo(TipoCurso.TECNOLOGO)
                .build();

        //Mocking
        Mockito.when(cursoRepository.save(any(Curso.class))).thenReturn(curso);
        Mockito.when(cursoService.save(any(Curso.class))).thenReturn(true);

        //Acao
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/admin/curso/cadastro")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(curso)));

        //Verification
        result.andExpect(MockMvcResultMatchers.status().isOk());
        Assert.assertTrue(result.andReturn().getResponse().getContentAsString().contains("Sucesso!"));

    }

    @Test
    public void deveRetornarStatusNOTFOUNDSalvarCurso() throws Exception {

        //Cenario
        Curso curso = Curso.CursoBuilder.builder()
                .nome("Análise e Desenvolvimento de Sistemas")
                .tipo(TipoCurso.TECNOLOGO)
                .build();

        //Mocking
        Mockito.when(cursoService.save(any())).thenReturn(false);

        //Acao
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/admin/curso/cadastro")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(curso)));

        //Verification
        result.andExpect(MockMvcResultMatchers.status().isNotFound());
        Assert.assertFalse(result.andReturn().getResponse().getContentAsString().contains("Sucesso!"));

    }
}

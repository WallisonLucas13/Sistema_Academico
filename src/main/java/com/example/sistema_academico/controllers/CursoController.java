package com.example.sistema_academico.controllers;

import com.example.sistema_academico.models.Curso;
import com.example.sistema_academico.services.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/curso")
@CrossOrigin("*")
public class CursoController {

    @Autowired
    private CursoService service;

    @PostMapping("/cadastro")
    public ResponseEntity<String> save(@RequestBody @Valid Curso curso){
        boolean result = service.save(curso);

        if(result){
            return ResponseEntity.ok("Curso Cadastrado com Sucesso!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Atenção!! Esse Curso já existe!");
    }
}

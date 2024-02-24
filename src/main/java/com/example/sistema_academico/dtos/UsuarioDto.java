package com.example.sistema_academico.dtos;

import com.example.sistema_academico.models.Usuario;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDto(@NotBlank String nome, @NotBlank String password, @NotBlank String email) {

    public Usuario convertToUsuario(){
        return Usuario.UsuarioBuilder.builder()
                .nome(nome)
                .password(password)
                .email(email)
                .build();
    }
}

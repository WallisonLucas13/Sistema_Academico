package com.example.sistema_academico.exceptions;

public class NotFoundException extends RuntimeException{

    public String getMessage() {
        return "Objeto Inexistente";
    }
}

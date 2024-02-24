package com.example.sistema_academico.repositories;

import com.example.sistema_academico.models.Matricula;
import com.example.sistema_academico.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByMatricula(Matricula matricula);
}

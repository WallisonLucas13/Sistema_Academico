package com.example.sistema_academico.repositories;

import com.example.sistema_academico.models.Aluno;
import com.example.sistema_academico.models.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByMatricula(Matricula matricula);
}

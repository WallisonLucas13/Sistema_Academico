package com.example.sistema_academico.repositories;

import com.example.sistema_academico.models.Matricula;
import com.example.sistema_academico.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    Optional<Professor> findByMatricula(Matricula matricula);
}

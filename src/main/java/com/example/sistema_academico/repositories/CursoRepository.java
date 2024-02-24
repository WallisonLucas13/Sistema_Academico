package com.example.sistema_academico.repositories;

import com.example.sistema_academico.enums.TipoAcademico;
import com.example.sistema_academico.enums.TipoCurso;
import com.example.sistema_academico.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    Optional<Curso> findByNome(String nome);

    List<Curso> findAllByTipo(TipoCurso tipoCurso);
}

package com.example.sistema_academico.services;

import com.example.sistema_academico.enums.TipoCurso;
import com.example.sistema_academico.exceptions.NotFoundException;
import com.example.sistema_academico.models.Curso;
import com.example.sistema_academico.repositories.CursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    @Transactional
    public boolean save(Curso curso){
        curso.setNome(curso.getNome().toUpperCase());

        boolean exists = repository.findByNome(curso.getNome()).isEmpty();

        if(exists){
            repository.save(curso);
            repository.flush();
            return exists;
        }

        return exists;
    }

    @Transactional
    public Curso getByNome(String nome) throws NotFoundException{
        return repository.findByNome(nome).orElseThrow(
                NotFoundException::new
        );
    }

    @Transactional
    public Curso getById(Long id) throws NotFoundException{
        return repository.findById(id).orElseThrow(
                NotFoundException::new
        );
    }

    @Transactional
    public List<Curso> getAll(){
        return repository.findAll();
    }

    @Transactional
    public List<Curso> getAllByTipo(TipoCurso tipoCurso){
        return repository.findAllByTipo(tipoCurso);
    }
}

package com.aluracursos.forohub.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoBs implements CursoService {

    @Autowired
    CursoRepository cursoRepository;

    @Override
    public Curso create(Curso curso) {
        return cursoRepository.findByNombreAndCategoria(curso.getNombre(), curso.getCategoria())
                .orElse(cursoRepository.save(curso));
    }

}

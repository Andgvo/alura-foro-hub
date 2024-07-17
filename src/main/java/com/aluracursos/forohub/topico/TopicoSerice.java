package com.aluracursos.forohub.topico;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TopicoSerice {

    void create(Topico topicoDto);
    Page<Topico> list(Pageable pageable);
    void update(Topico topico);
    Topico get(Long id);
}

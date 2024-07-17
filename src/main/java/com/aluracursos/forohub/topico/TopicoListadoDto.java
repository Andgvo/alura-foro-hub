package com.aluracursos.forohub.topico;

import com.aluracursos.forohub.curso.CursoDto;

import java.time.LocalDate;

public record TopicoListadoDto(
        Long id,
        String titulo,
        String mensaje,
        LocalDate fechaCreacion,
        String autor,
        String status,
        CursoDto curso
) {
    public TopicoListadoDto(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getAutor(),
                topico.getStatus(),
                new CursoDto(topico.getCurso())
        );
    }
}

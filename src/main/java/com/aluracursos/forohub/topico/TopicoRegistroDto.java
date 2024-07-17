package com.aluracursos.forohub.topico;

import com.aluracursos.forohub.curso.CursoDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record TopicoRegistroDto(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        LocalDate fechaCreacion,
        @NotBlank
        String autor,
        String status,
        @Valid
        CursoDto curso
) {
}

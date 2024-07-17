package com.aluracursos.forohub.curso;

import jakarta.validation.constraints.NotBlank;

public record CursoDto(
        Long id,
        @NotBlank
        String nombre,
        @NotBlank
        CategoriaEnum categoria
) {
    public CursoDto(Curso curso) {
        this(curso.getId(), curso.getNombre(), curso.getCategoria());
    }
}

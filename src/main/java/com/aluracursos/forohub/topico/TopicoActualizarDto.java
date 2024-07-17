package com.aluracursos.forohub.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicoActualizarDto(
        @NotNull
        Long id,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        String status
) {
}

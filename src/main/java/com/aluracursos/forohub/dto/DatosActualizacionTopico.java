package com.aluracursos.forohub.dto;

import jakarta.validation.constraints.NotNull;

public record DatosActualizacionTopico(
        @NotNull Long id,
        String titulo,
        String mensaje,
        String idAutor,
        String curso
) {
}

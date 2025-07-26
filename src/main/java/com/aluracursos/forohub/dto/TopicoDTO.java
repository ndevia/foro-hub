package com.aluracursos.forohub.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record TopicoDTO(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotBlank LocalDate fechaDeCreacion,
        @NotBlank String status, //  estado del tópico
        @NotBlank String idAutor,
        @NotBlank String curso
) {
}

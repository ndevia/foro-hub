package com.aluracursos.forohub.dto;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroUsuario(
        @NotBlank String login,
        @NotBlank String contrasena
) {
}

package com.aluracursos.forohub.dto;

import com.aluracursos.forohub.entity.Usuario;

public record DatosDetalleUsuario(
        Long id,
        String login,
        String contrasena
) {
    public DatosDetalleUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getLogin(), usuario.getContrasena());
    }
}

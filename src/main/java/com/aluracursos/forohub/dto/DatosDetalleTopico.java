package com.aluracursos.forohub.dto;

import com.aluracursos.forohub.entity.Topico;

import java.time.LocalDate;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDate fechaDeCreacion,
        String status,
        String idAutor,
        String curso
) {
    public DatosDetalleTopico(Topico topico) {
        this(
            topico.getId(),
            topico.getTitulo(),
            topico.getMensaje(),
            topico.getFechaDeCreacion(),
            topico.getStatus(),
            topico.getIdAutor(),
            topico.getCurso()
        );
    }

}

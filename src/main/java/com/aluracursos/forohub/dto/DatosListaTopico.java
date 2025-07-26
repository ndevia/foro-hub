package com.aluracursos.forohub.dto;

import com.aluracursos.forohub.entity.Topico;

import java.time.LocalDate;

public record DatosListaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDate fechaDeCreacion
) {
    public DatosListaTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaDeCreacion());
    }
}

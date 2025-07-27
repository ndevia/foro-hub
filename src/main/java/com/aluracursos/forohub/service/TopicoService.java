package com.aluracursos.forohub.service;

import com.aluracursos.forohub.dto.DatosActualizacionTopico;
import com.aluracursos.forohub.entity.Topico;
import com.aluracursos.forohub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository repository;

    @Transactional
    public void actualizarTopico(Long id, DatosActualizacionTopico datos) {
        Optional<Topico> topico = repository.findById(id);

        if (topico.isPresent()) {
            topico.get().actualizar(datos);
        }
    }
}

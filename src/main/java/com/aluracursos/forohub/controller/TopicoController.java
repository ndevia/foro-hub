package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.dto.DatosActualizacionTopico;
import com.aluracursos.forohub.dto.DatosDetalleTopico;
import com.aluracursos.forohub.dto.DatosListaTopico;
import com.aluracursos.forohub.dto.DatosRegistroTopico;
import com.aluracursos.forohub.entity.Topico;
import com.aluracursos.forohub.repository.TopicoRepository;
import com.aluracursos.forohub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoService service;

    @Autowired
    private TopicoRepository repository;

    @Transactional
    @PostMapping
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datos) {
        repository.save(new Topico(datos));
    }

    @GetMapping
    public Page<DatosListaTopico> listarTopicos(Pageable paginacion) {
        return repository.findAll(paginacion).map(DatosListaTopico::new);
    }

    @GetMapping("/{id}")
    public Optional<Topico> buscarTopico(@PathVariable Long id) {
        Optional<Topico> topico = repository.findById(id);
        return topico;
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizacionTopico datos) {
        var topico = repository.getReferenceById(datos.id());
        service.actualizarTopico(id, datos);

        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        Optional<Topico> topico = repository.findById(id);
        if (topico.isPresent()) {
            repository.deleteById(id);
        }
        return ResponseEntity.noContent().build();
    }
}

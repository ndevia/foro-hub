package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.dto.DatosListaTopico;
import com.aluracursos.forohub.dto.DatosRegistroTopico;
import com.aluracursos.forohub.entity.Topico;
import com.aluracursos.forohub.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
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

//    @GetMapping("/{id}")
//    public DatosListaTopico buscarTopico(@PathVariable Long id) {
//
//        DatosListaTopico topicoPorId = repository.findById(id);
//        return topicoPorId;
//    }
//    @PutMapping
//    @DeleteMapping
}

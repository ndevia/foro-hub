package com.aluracursos.forohub.entity;

import com.aluracursos.forohub.dto.TopicoDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @Column(unique = true)
    private String mensaje;
    private LocalDate fechaDeCreacion;
    private String status; //  estado del tópico
    private String idAutor;
    private String curso;

    public Topico(@Valid TopicoDTO datos) {
        this.id = null;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaDeCreacion = LocalDate.now();
        this.status = "Abierto";
        this.idAutor = datos.idAutor();
        this.curso = datos.curso();
    }
}

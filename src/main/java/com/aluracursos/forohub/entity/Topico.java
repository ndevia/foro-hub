package com.aluracursos.forohub.entity;

import com.aluracursos.forohub.dto.DatosActualizacionTopico;
import com.aluracursos.forohub.dto.DatosRegistroTopico;
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
    private String idAutor;
    private String curso;

    private LocalDate fechaDeCreacion = LocalDate.now();
    private String status = "ABIERTO";  // estado del tópico


    public Topico(@Valid DatosRegistroTopico datos) {
        this.id = null;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaDeCreacion = LocalDate.now();
        this.status = "ABIERTO";
        this.idAutor = datos.idAutor();
        this.curso = datos.curso();
    }

    public void actualizar(@Valid DatosActualizacionTopico datos) {
        if (datos.titulo() != null) {
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
        }
        if (datos.idAutor() != null) {
            this.idAutor = datos.idAutor();
        }
        if (datos.curso() != null) {
            this.curso = datos.curso();
        }
    }
}

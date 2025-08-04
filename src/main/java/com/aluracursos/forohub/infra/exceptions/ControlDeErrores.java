package com.aluracursos.forohub.infra.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControlDeErrores {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity gestionar404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity gestionar400(MethodArgumentNotValidException exception) {
        var errores = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(errores.stream()
                .map(DatosErrorValidacion::new).toList());
    }

    // Gestionar error por titulo y mensaje ya existente
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity gestionarErrorIntegridad(DataIntegrityViolationException exception) {
        String causa = exception.getRootCause() != null ? exception.getRootCause().getMessage() : "";

        List<String> errores = new ArrayList<>();

        if (causa.contains("titulo")) {
            errores.add("Ya existe un tópico con ese título.");
        }
        if(causa.contains("mensaje")) {
            errores.add("Ya existe un tópico con ese mensaje.");
        }
        if (errores.isEmpty()) {
            errores.add("Error en la integridad de la base de datos.");
        }

        return ResponseEntity.badRequest().body(String.join(" ", errores));
    }

    // DTO dentro de la clase, ya que sólo se usa aquí
    public record DatosErrorValidacion(String campo, String mensaje) {
        public DatosErrorValidacion(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}

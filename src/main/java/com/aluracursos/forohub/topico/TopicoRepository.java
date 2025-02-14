package com.aluracursos.forohub.topico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Optional<Topico> findByTituloAndMensajeIgnoreCase(String titulo, String mensaje);
}

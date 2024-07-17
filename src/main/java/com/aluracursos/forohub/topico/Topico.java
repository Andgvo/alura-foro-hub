package com.aluracursos.forohub.topico;

import com.aluracursos.forohub.curso.Curso;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Column(length = 500)
    private String mensaje;
    private LocalDate fechaCreacion;
    private String autor;
    private String status;
    //Relations
    @ManyToOne
    private Curso curso;

    public Topico(TopicoRegistroDto dto){
        titulo = dto.titulo();
        mensaje = dto.mensaje();
        fechaCreacion = dto.fechaCreacion();
        autor = dto.autor();
        status = dto.status();
        curso = new Curso(dto.curso());
    }

    public Topico(TopicoActualizarDto dto){
        id = dto.id();
        titulo = dto.titulo();
        mensaje = dto.mensaje();
        status = dto.status();
    }

}

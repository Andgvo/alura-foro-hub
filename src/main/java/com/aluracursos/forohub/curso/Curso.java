package com.aluracursos.forohub.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cursos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Enumerated(EnumType.STRING)
    private CategoriaEnum categoria;

    public Curso(CursoDto dto) {
        id = dto.id();
        nombre = dto.nombre();
        categoria = dto.categoria();
    }

}

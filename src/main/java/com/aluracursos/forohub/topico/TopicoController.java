package com.aluracursos.forohub.topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    TopicoSerice topicoSerice;

    @PostMapping
    public void registrar(@RequestBody TopicoRegistroDto topicoRegistroDto){
        topicoSerice.create(new Topico(topicoRegistroDto));
    }

    @GetMapping
    public Page<TopicoListadoDto> listar(Pageable pageable){
        return topicoSerice.list(pageable).map(TopicoListadoDto::new);
    }

    @PutMapping
    void actualizar(@RequestBody TopicoActualizarDto topicoActualizarDto){
        topicoSerice.update(new Topico(topicoActualizarDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoListadoDto> obtenerUno(@PathVariable Long id){
        return ResponseEntity.ok(new TopicoListadoDto(topicoSerice.get(id)));
    }

}

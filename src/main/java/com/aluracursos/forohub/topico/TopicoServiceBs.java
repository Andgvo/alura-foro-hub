package com.aluracursos.forohub.topico;

import com.aluracursos.forohub.curso.CursoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TopicoServiceBs implements TopicoSerice {

    @Autowired
    TopicoRepository topicoRepository;
    @Autowired
    CursoService cursoService;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void create(Topico topico) {
        final var curso = cursoService.create(topico.getCurso());
        //Verificar si es unico
        var topicoExist = topicoRepository.findByTituloAndMensajeIgnoreCase(topico.getTitulo(), topico.getMensaje());
        if (topicoExist.isPresent()) {
            throw new TopicoException("Topico duplicado");
        }
        //Guardar la iformacion
        topico.setCurso(curso);
        topicoRepository.save(topico);
    }

    @Override
    public Page<Topico> list(Pageable pageable) {
        return topicoRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void update(Topico topico) {
        final var topicoRegistradoOptional = topicoRepository.findById(topico.getId());
        if (topicoRegistradoOptional.isEmpty()) {
            throw new EntityNotFoundException("No se encontro el topico");
        }
        final var topicoRegistrado = topicoRegistradoOptional.get();

        topicoRegistrado.setTitulo(topico.getTitulo());
        topicoRegistrado.setMensaje(topico.getMensaje());
        topicoRegistrado.setStatus(topico.getStatus());

        topicoRepository.save(topicoRegistrado);
    }

    @Override
    public Topico get(Long id) {
        System.out.println("=======");
        var otpional = topicoRepository.findById(id);
        if(otpional.isPresent()){
            System.out.println(otpional.get());
        }
        return topicoRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

}

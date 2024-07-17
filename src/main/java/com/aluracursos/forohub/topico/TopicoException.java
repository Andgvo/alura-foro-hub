package com.aluracursos.forohub.topico;

import java.io.Serializable;

public class TopicoException extends RuntimeException implements Serializable {

    public TopicoException(String message){
        super(message);
    }

}

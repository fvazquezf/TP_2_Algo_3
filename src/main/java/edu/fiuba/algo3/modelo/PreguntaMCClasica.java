package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Set;

public class PreguntaMCClasica extends Pregunta {

    public PreguntaMCClasica(String pregunta, Set<String> respuesta) {
        textoPregunta = pregunta;
        this.respuesta = new OpcionesCorrectasClasicas(respuesta);
    }
}
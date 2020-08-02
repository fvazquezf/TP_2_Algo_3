package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Set;

public class PreguntaVoFConPenalidad extends Pregunta {

    public PreguntaVoFConPenalidad(String pregunta, Set<String> respuesta) {
        textoPregunta = pregunta;
        this.opcionesCorrectas = new OpcionesCorrectasConPuntajeParcial(respuesta);
    }

}

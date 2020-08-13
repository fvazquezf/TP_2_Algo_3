package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PreguntasJson {
    private String pregunta;
    private String tipoPregunta;
    private List<String> respuestasCorrectas = new ArrayList<>();
    private List<String> respuetaFalsa = new ArrayList<>();

    public PreguntasJson( String pregunta, String respuestaCorrecta, String respuestaFalsa) {
        this.pregunta = pregunta;
        this.respuestasCorrectas.add(respuestaCorrecta);
        this.respuetaFalsa.add(respuestaFalsa);
    }

    public String obtenerPregunta() {
        return pregunta;
    }
    public List obtenerRespuestaCorrecta() {
        return respuestasCorrectas;
    }
        public List obtenerRespuestaFalsa() {
        return respuetaFalsa;
    }
}

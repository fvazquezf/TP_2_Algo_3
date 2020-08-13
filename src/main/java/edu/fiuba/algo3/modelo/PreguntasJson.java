package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PreguntasJson {
    private String pregunta;
    private String tipoPregunta;
    private Opciones opcionesPosibles;
    private Opciones opcionesCorrectas;

    public PreguntasJson( String pregunta, String tipoPregunta, Opciones opcionesPosibles, Opciones opcionesCorrectas) {
        this.pregunta = pregunta;
        this.tipoPregunta = tipoPregunta;
        this.opcionesPosibles = opcionesPosibles;
        this.opcionesCorrectas = opcionesCorrectas;
    }

    public String obtenerPregunta() {
        return this.pregunta;
    }
    public String obtenerTipoPregunta() {
        return this.tipoPregunta;
    }
    public Opciones obtenerOpcionesPosibles() {
        return this.opcionesPosibles;
    }
    public Opciones obtenerOpcionesCorrectas() {
        return this.opcionesCorrectas;
    }
}

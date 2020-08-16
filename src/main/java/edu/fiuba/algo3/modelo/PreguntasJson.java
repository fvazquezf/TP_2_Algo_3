package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PreguntasJson {
    private String pregunta;
    private String tipoPregunta;
    private String opcionesPosibles[];
    private String opcionesCorrectas[];

    public PreguntasJson( String tipoPregunta, String pregunta, String[] opcionesPosibles, String[] opcionesCorrectas) {
        this.tipoPregunta = tipoPregunta;
        this.pregunta = pregunta;
        this.opcionesPosibles = opcionesPosibles;
        this.opcionesCorrectas = opcionesCorrectas;
    }

    public String obtenerPregunta() {
        return this.pregunta;
    }
    public String obtenerTipoPregunta() {
        return this.tipoPregunta;
    }
    public String[] obtenerOpcionesPosibles() {
        return this.opcionesPosibles;
    }
    public String[] obtenerOpcionesCorrectas() {
        return this.opcionesCorrectas;
    }
}

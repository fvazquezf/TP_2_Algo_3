package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PreguntasJson {
    private String pregunta;
    private String tipoPregunta;
    private String opcionesPosibles[];
    private String opcionesCorrectas[];

    public PreguntasJson( String pregunta, String tipoPregunta, String[] opcionesPosibles, String[] opcionesCorrectas) {
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
    public String[] obtenerOpcionesPosibles() {
        return this.opcionesPosibles;
    }
    public String[] obtenerOpcionesCorrectas() {
        return this.opcionesCorrectas;
    }
}

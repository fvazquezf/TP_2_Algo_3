package edu.fiuba.algo3.modelo;


public class PreguntasJson {

    public final String pregunta;
    public final String tipoPregunta;
    public final String[] opcionesPosibles;
    public final String[] opcionesCorrectas;
    public final String[] grupos;

    public PreguntasJson( String tipoPregunta, String pregunta, String[] opcionesPosibles, String[] opcionesCorrectas, String[] grupos) {
        this.tipoPregunta = tipoPregunta;
        this.pregunta = pregunta;
        this.opcionesPosibles = opcionesPosibles;
        this.opcionesCorrectas = opcionesCorrectas;
        this.grupos = grupos;
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
    public String[] obtenerGrupos() {
        return this.grupos;
    }
}

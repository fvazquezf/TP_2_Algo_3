package edu.fiuba.algo3;


import java.util.*;

public class PreguntasJson {

    public final String pregunta;
    public final String tipoPregunta;
    public final String[] opcionesPosibles;
    public final String[] opcionesCorrectas;
    public final List<Grupo> grupos;
    public final Set<String> opPosibles = new HashSet<>();

    public PreguntasJson( String tipoPregunta, String pregunta, String[] opcionesPosibles, String[] opcionesCorrectas, List<Grupo> grupos) {
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
    public Map<String, String> obtenerGrupos() {
        return grupos.get(0).obtenerGrupos();
    }

    public Collection<String> obtenerOpPosbiles() {
        for(int i = 0; i < this.opcionesPosibles.length ; i++) {
            opPosibles.add(this.opcionesPosibles[i]);
        }
        return opPosibles;
    }
}

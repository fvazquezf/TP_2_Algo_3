package edu.fiuba.algo3;


import java.util.*;

public class Preguntas {

    public final String pregunta;
    public final String tipoPregunta;
    public final String[] opcionesPosibles;
    public final String[] opcionesCorrectas;
    public final List<Grupo> grupos;

    public Preguntas(String tipoPregunta, String pregunta, String[] opcionesPosibles, String[] opcionesCorrectas, List<Grupo> grupos) {
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

    public Map<String, String> obtenerGrupos() {
        return grupos.get(0).obtenerGrupos();
    }

    public Collection<String> obtenerOpcionesPosbiles() {
        Set<String> opPosibles = new HashSet<>();
        Collections.addAll(opPosibles, this.opcionesPosibles);
        return opPosibles;
    }

    public String[] obtenerOpcionesCorrectas() {
        return opcionesCorrectas;
    }
}

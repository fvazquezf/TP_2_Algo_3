package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.comportamientos.ComportamientoClasico;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionPreguntaGCInvalida;
import javafx.scene.media.AudioClip;

import java.io.File;
import java.util.Collection;
import java.util.Map;

public class PreguntaGC extends Pregunta {
    private final ComportamientoClasico comportamiento = new ComportamientoClasico();
    Map<String, String> grupos;
    static final String archivoFiesta = "rsc/diegoFiesta.wav";
    static final String archivoFrula = "rsc/pabloFrula.wav";


    public PreguntaGC(String tipoPregunta, String pregunta, String[] opcionesCorrectas, Collection<String> todasLasOpciones, Map<String, String> grupos) {
        super(tipoPregunta, pregunta, opcionesCorrectas, todasLasOpciones);
        if (todasLasOpciones.size() < 2 || todasLasOpciones.size() > 6)
            throw new ExcepcionPreguntaGCInvalida();
        if (todasLasOpciones.contains(grupos.get("grupoAComparar")) || todasLasOpciones.contains(grupos.get("OtroGrupo")))
            throw new ExcepcionPreguntaGCInvalida();
        this.grupos = grupos;
        this.opcionesCorrectas.add(grupos.get("grupoAComparar"));
    }


    public Integer compararRespuestas(Collection<String> opcionesJugador) {
        int puntos = comportamiento.compararRespuestas(opcionesJugador, opcionesCorrectas);
        notificarObservador();

        AudioClip sonido;
        if (puntos == 0) {
            sonido = new AudioClip(new File(archivoFrula).toURI().toString());
        } else {
            sonido = new AudioClip(new File(archivoFiesta).toURI().toString());
        }
        sonido.play();

        return puntos;
    }

    public String obtenerGrupoCorrecto() {
        return grupos.get("grupoAComparar");
    }

    public String obtenerGrupoIncorrecto() {
        return grupos.get("otroGrupo");
    }
}

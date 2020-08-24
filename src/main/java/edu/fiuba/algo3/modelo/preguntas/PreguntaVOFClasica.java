package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.comportamientos.ComportamientoClasico;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionPreguntaVOFInvalida;
import javafx.scene.media.AudioClip;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;

public class PreguntaVOFClasica extends Pregunta {
    private final ComportamientoClasico comportamiento = new ComportamientoClasico();
    static final String archivoFiesta = "rsc/diegoFiesta.wav";
    static final String archivoFrula = "rsc/pabloFrula.wav";

    public PreguntaVOFClasica(String tipoPregunta, String pregunta, String[] opcionesCorrectas) {
        super(tipoPregunta, pregunta, opcionesCorrectas);
        todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("V");
        todasLasOpciones.add("F");
        if (this.opcionesCorrectas.size() != 1)
            throw new ExcepcionPreguntaVOFInvalida();
    }

    @Override
    public Integer compararRespuestas(Collection<String> opcionesJugador) {
        int puntos = comportamiento.compararRespuestas(opcionesJugador, opcionesCorrectas);
        notificarObservador();

        AudioClip sonido;
        if (puntos == 0) {
            sonido = new AudioClip(new File(archivoFrula).toURI().toString());
        } else {
            sonido = new AudioClip(new File(archivoFiesta).toURI().toString());
            sonido.setVolume(2.0);
        }
        sonido.play();

        return puntos;
    }
}

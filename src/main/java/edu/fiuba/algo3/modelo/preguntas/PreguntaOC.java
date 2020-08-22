package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.comportamientos.ComportamientoClasico;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionPreguntaOCInvalida;
import javafx.scene.media.AudioClip;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

public class PreguntaOC extends Pregunta {
    private final ComportamientoClasico comportamiento = new ComportamientoClasico();
    static final String archivoFiesta = "rsc/diegoFiesta.wav";
    static final String archivoFrula = "rsc/pabloFrula.wav";

    public PreguntaOC(String tipoPregunta, String pregunta, String[] opcionesCorrectas, Collection<String> todasLasOpciones) {
        super(tipoPregunta, pregunta, Arrays.asList(opcionesCorrectas), todasLasOpciones);
        if (todasLasOpciones.size() < 2 || todasLasOpciones.size() > 5)
            throw new ExcepcionPreguntaOCInvalida();
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
        }
        sonido.play();

        return puntos;
    }
}

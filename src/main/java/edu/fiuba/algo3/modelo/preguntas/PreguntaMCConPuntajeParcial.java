package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.comportamientos.ComportamientoConPuntajeParcial;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionPreguntaMCInvalida;
import javafx.scene.media.AudioClip;

import java.io.File;
import java.util.Collection;

public class PreguntaMCConPuntajeParcial extends Pregunta {
    private final ComportamientoConPuntajeParcial comportamiento = new ComportamientoConPuntajeParcial();
    static final String archivoFiesta = "rsc/diegoFiesta.wav";
    static final String archivoFrula = "rsc/pabloFrula.wav";

    public PreguntaMCConPuntajeParcial(String tipoPregunta, String pregunta, String[] opcionesCorrectas, Collection<String> todasLasOpciones) {
        super(tipoPregunta, pregunta, opcionesCorrectas, todasLasOpciones);

        if (todasLasOpciones.size() > 5 || todasLasOpciones.size() < 2)
            throw new ExcepcionPreguntaMCInvalida();
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

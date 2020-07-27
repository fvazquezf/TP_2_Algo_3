package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVoFConPenalidadTest {

    @Test
    public void Test01PreguntaVerdaderoFalsoConPenalidadAsignaPuntosCorrectamente(){

        ArrayList<String> respuestasJugadores = new ArrayList<String>();
        respuestasJugadores.add("V");
        respuestasJugadores.add("F");

        ArrayList<Integer> puntosEsperados = new ArrayList<Integer>();
        puntosEsperados.add(1);
        puntosEsperados.add(-1);

        ArrayList<Boolean> respuestas = new ArrayList();
        respuestas.add(true);
        respuestas.add(false);

        Panel panel = new Panel();
//        panel.crearPreguntaVoFClasica("rsc/Preguntas.json");
        panel.crearPreguntaVoFConPenaldiad("El Caballo blanco de San Martin era Blanco?", respuestas);

        panel.crearJugador("Rulo");
        panel.crearJugador("Stef");

        panel.hacerPregunta(respuestasJugadores);

        assertEquals(puntosEsperados, panel.pedirPuntos() );

    }
}

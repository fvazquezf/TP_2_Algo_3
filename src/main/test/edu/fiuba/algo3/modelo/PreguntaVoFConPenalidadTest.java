package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVoFConPenalidadTest{

    @Test
    public void Test01PreguntaVerdaderoFalsoConPenalidadAsignaPuntosCorrectamente(){

        HashMap<Integer,Boolean> respuestasJ1 = new HashMap<Integer, Boolean>();
        HashMap<Integer,Boolean> respuestasJ2 = new HashMap<Integer, Boolean>();

        respuestasJ1.put(0,true);
        respuestasJ1.put(1,false);

        respuestasJ2.put(0,false);
        respuestasJ2.put(1,false);

        ArrayList<HashMap> respuestasJugadores = new ArrayList<HashMap>();
        respuestasJugadores.add(respuestasJ1);
        respuestasJugadores.add(respuestasJ2);

        ArrayList<Integer> puntosEsperados = new ArrayList<Integer>();
        puntosEsperados.add(1);
        puntosEsperados.add(-1);

        ArrayList<Boolean> respuestas = new ArrayList();
        respuestas.add(true);
        respuestas.add(false);

        Panel panel = new Panel();
//      panel.crearPreguntaVoFClasica("rsc/Preguntas.json");
        panel.crearPregunta("preguntaVoFConPenalidad","El Caballo blanco de San Martin era Blanco?", respuestas);

        panel.crearJugador("Rulo");
        panel.crearJugador("Stef");

        panel.hacerPregunta(respuestasJugadores);

        assertEquals(puntosEsperados, panel.pedirPuntos() );

    }
}

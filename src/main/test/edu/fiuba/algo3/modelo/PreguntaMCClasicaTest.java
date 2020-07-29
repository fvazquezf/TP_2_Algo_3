package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMCClasicaTest {

    @Test
    public void Test01CrearMCCon3PosiblesRespuestas() {

        ArrayList<Boolean> respuestas = new ArrayList();
        respuestas.add(true);
        respuestas.add(false);
        respuestas.add(false);

        Panel panel = new Panel();
        panel.crearPregunta("preguntaMCClasica","De que color era el caballo blanco de San Martin?", respuestas);

        assertEquals("De que color era el caballo blanco de San Martin?", panel.pasarPregunta());
    }
    @Test
    public void Test02PreguntaMCCon3PosiblesRespuestasYAsignaPuntosCorrectamenteALosJugadores(){

        HashMap<Integer,Boolean> respuestasJ1 = new HashMap<Integer, Boolean>();
        HashMap<Integer,Boolean> respuestasJ2 = new HashMap<Integer, Boolean>();

        respuestasJ1.put(0,true);
        respuestasJ1.put(1,false);
        respuestasJ1.put(2,false);

        respuestasJ2.put(0,false);
        respuestasJ2.put(1,true);
        respuestasJ2.put(2,false);

        ArrayList<HashMap> respuestasJugadores = new ArrayList<HashMap>();
        respuestasJugadores.add(respuestasJ1);
        respuestasJugadores.add(respuestasJ2);

        ArrayList<Integer> puntosEsperados = new ArrayList<Integer>();
        puntosEsperados.add(1);
        puntosEsperados.add(0);

        ArrayList<Boolean> respuestas = new ArrayList();
        respuestas.add(true);
        respuestas.add(false);
        respuestas.add(false);

        Panel panel = new Panel();
//        panel.crearPreguntaVoFClasica("rsc/Preguntas.json");
        panel.crearPregunta("preguntaMCClasica", "De que color era el caballo blanco de San Martin?", respuestas);

        panel.crearJugador("Rulo");
        panel.crearJugador("Stef");

        panel.hacerPregunta(respuestasJugadores);

        assertEquals(puntosEsperados, panel.pedirPuntos() );
    }


}

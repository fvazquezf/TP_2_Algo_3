package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMCClasicaTest {
    //Asigna un punto a cada jugador que acierte TODAS las opciones correctas.

    @Test
    public void Test01CrearMCCon3PosiblesRespuestas() {

        ArrayList<Boolean> respuestas = new ArrayList<>();
        respuestas.add(true);
        respuestas.add(false);
        respuestas.add(false);

        Panel panel = new Panel();
        panel.crearPregunta("preguntaMCClasica","De que color era el caballo blanco de San Martin?", respuestas);

        assertEquals("De que color era el caballo blanco de San Martin?", panel.pasarPregunta());
    }
    @Test
    public void Test02PreguntaMCCon3PosiblesRespuestasYAsignaPuntosCorrectamenteALosJugadores(){

        HashMap<Integer,Boolean> respuestasJ1 = new HashMap<>();
        HashMap<Integer,Boolean> respuestasJ2 = new HashMap<>();

        respuestasJ1.put(0,true);
        respuestasJ1.put(1,false);
        respuestasJ1.put(2,false);

        respuestasJ2.put(0,false);
        respuestasJ2.put(1,true);
        respuestasJ2.put(2,false);

        ArrayList<HashMap<Integer,Boolean>> respuestasJugadores = new ArrayList<>();
        respuestasJugadores.add(respuestasJ1);
        respuestasJugadores.add(respuestasJ2);

        ArrayList<Integer> puntosEsperados = new ArrayList<>();
        puntosEsperados.add(1);
        puntosEsperados.add(0);

        ArrayList<Boolean> respuestas = new ArrayList<>();
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
    @Test
    public void Test03PreguntaMCCon3PosiblesRespuestasY2VerdaderasYAsignaPuntosCorrectamenteALosJugadores(){

        HashMap<Integer,Boolean> respuestasJ1 = new HashMap<>();
        HashMap<Integer,Boolean> respuestasJ2 = new HashMap<>();

        respuestasJ1.put(0,true);
        respuestasJ1.put(1,true);
        respuestasJ1.put(2,false);

        respuestasJ2.put(0,true);
        respuestasJ2.put(1,false);
        respuestasJ2.put(2,true);

        ArrayList<HashMap<Integer,Boolean>> respuestasJugadores = new ArrayList<>();
        respuestasJugadores.add(respuestasJ1);
        respuestasJugadores.add(respuestasJ2);

        ArrayList<Integer> puntosEsperados = new ArrayList<>();
        puntosEsperados.add(0); //J1 obtiene 0 puntos porque no acerto TODAS las respuestas posibles
        puntosEsperados.add(1); //J2 obtiene 1 punto porque acerto TODAS las respuestas posibles

        ArrayList<Boolean> respuestas = new ArrayList<>();
        respuestas.add(true);
        respuestas.add(false);
        respuestas.add(true);

        Panel panel = new Panel();
//        panel.crearPreguntaVoFClasica("rsc/Preguntas.json");
        panel.crearPregunta("preguntaMCClasica", "De que color era el caballo blanco de San Martin?", respuestas);

        panel.crearJugador("Rulo");
        panel.crearJugador("Stef");

        panel.hacerPregunta(respuestasJugadores);

        assertEquals(puntosEsperados, panel.pedirPuntos() );
    }

    @Test
    public void Test04PreguntaMCCon5posiblesRespuestasY5CorrectasYAsignaPuntosCorrectamenteALosJugadores(){

        HashMap<Integer,Boolean> respuestasJ1 = new HashMap<>();
        HashMap<Integer,Boolean> respuestasJ2 = new HashMap<>();

        respuestasJ1.put(0,true);
        respuestasJ1.put(1,true);
        respuestasJ1.put(2,true);
        respuestasJ1.put(3,true);
        respuestasJ1.put(4,true);

        respuestasJ2.put(0,true);
        respuestasJ2.put(1,true);
        respuestasJ2.put(2,true);
        respuestasJ2.put(3,true);
        respuestasJ2.put(4,false);

        ArrayList<HashMap<Integer,Boolean>> respuestasJugadores = new ArrayList<>();
        respuestasJugadores.add(respuestasJ1);
        respuestasJugadores.add(respuestasJ2);

        ArrayList<Integer> puntosEsperados = new ArrayList<>();
        puntosEsperados.add(1); //recibe 1 punto por responder correctamente 5 veces de 5
        puntosEsperados.add(0); //recibe 0 puntos por responder correctamente solo 4 de 5

        ArrayList<Boolean> respuestas = new ArrayList<>();
        respuestas.add(true);
        respuestas.add(true);
        respuestas.add(true);
        respuestas.add(true);
        respuestas.add(true);

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCClasica", "De que color era el caballo blanco de San Martin?", respuestas);

        panel.crearJugador("Rulo");
        panel.crearJugador("Stef");

        panel.hacerPregunta(respuestasJugadores);

        assertEquals(puntosEsperados, panel.pedirPuntos() );
    }
}

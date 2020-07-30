package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PreguntaMCPuntajeConPenalidadlTest {
    @Test
    public void Test01CrearMCCon3PosiblesRespuestas() {

        ArrayList<Boolean> respuestas = new ArrayList<>();
        respuestas.add(true);
        respuestas.add(false);
        respuestas.add(false);

        Panel panel = new Panel();
        panel.crearPregunta("preguntaMCConPenalidad","De que color era el caballo blanco de San Martin?", respuestas);

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
        puntosEsperados.add(-1);

        ArrayList<Boolean> respuestas = new ArrayList<>();
        respuestas.add(true);
        respuestas.add(false);
        respuestas.add(false);

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPenalidad", "De que color era el caballo blanco de San Martin?", respuestas);

        panel.crearJugador("Rulo");
        panel.crearJugador("Stef");

        panel.hacerPregunta(respuestasJugadores);

        assertEquals(puntosEsperados, panel.pedirPuntos() );
    }


    @Test
    public void Test03PreguntaMCCon5posiblesRespuestasY3CorrectasYAsignaPuntosCorrectamenteALosJugadores(){

        HashMap<Integer,Boolean> respuestasJ1 = new HashMap<>();
        HashMap<Integer,Boolean> respuestasJ2 = new HashMap<>();

        respuestasJ1.put(0,true);
        respuestasJ1.put(1,true);
        respuestasJ1.put(2,false);
        respuestasJ1.put(3,false);
        respuestasJ1.put(4,false);

        respuestasJ2.put(0,true);
        respuestasJ2.put(1,true);
        respuestasJ2.put(2,true);
        respuestasJ2.put(3,false);
        respuestasJ2.put(4,true);

        ArrayList<HashMap<Integer,Boolean>> respuestasJugadores = new ArrayList<>();
        respuestasJugadores.add(respuestasJ1);
        respuestasJugadores.add(respuestasJ2);

        ArrayList<Integer> puntosEsperados = new ArrayList<>();
        puntosEsperados.add(2); //recibe 2 puntos por responder correctamente 2 veces. sin errores
        puntosEsperados.add(2); //recibe 2 puntos por haber contestado 3 bien, un error

        ArrayList<Boolean> respuestas = new ArrayList<>();
        respuestas.add(true);
        respuestas.add(true);
        respuestas.add(false);
        respuestas.add(false);
        respuestas.add(true);

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPenalidad", "De que color era el caballo blanco de San Martin?", respuestas);

        panel.crearJugador("Rulo");
        panel.crearJugador("Stef");

        panel.hacerPregunta(respuestasJugadores);

        assertEquals(puntosEsperados, panel.pedirPuntos() );
    }

    @Test
    public void Test04PreguntaMCCon5posiblesRespuestasY1CorrectaYAsignaPuntosCorrectamenteALosJugadores(){

        HashMap<Integer,Boolean> respuestasJ1 = new HashMap<>();
        HashMap<Integer,Boolean> respuestasJ2 = new HashMap<>();

        respuestasJ1.put(0,true);
        respuestasJ1.put(1,true);
        respuestasJ1.put(2,true);
        respuestasJ1.put(3,false);
        respuestasJ1.put(4,true);

        respuestasJ2.put(0,true);
        respuestasJ2.put(1,true);
        respuestasJ2.put(2,false);
        respuestasJ2.put(3,true);
        respuestasJ2.put(4,true);

        ArrayList<HashMap<Integer,Boolean>> respuestasJugadores = new ArrayList<>();
        respuestasJugadores.add(respuestasJ1);
        respuestasJugadores.add(respuestasJ2);

        ArrayList<Integer> puntosEsperados = new ArrayList<>();
        puntosEsperados.add(-2); //recibe 1 punto por responder correctamente 1 vez. 3 errores
        puntosEsperados.add(-4); //recibe -4 puntos por tener 4 errores.

        ArrayList<Boolean> respuestas = new ArrayList<>();
        respuestas.add(false);
        respuestas.add(false);
        respuestas.add(true);
        respuestas.add(false);
        respuestas.add(false);

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPenalidad", "De que color era el caballo blanco de San Martin?", respuestas);

        panel.crearJugador("Rulo");
        panel.crearJugador("Stef");

        panel.hacerPregunta(respuestasJugadores);

        assertEquals(puntosEsperados, panel.pedirPuntos() );
    }

    @Test
    public void Test05PreguntaMCCon5posiblesRespuestasY5CorrectasYAsignaPuntosCorrectamenteALosJugadores(){

        HashMap<Integer,Boolean> respuestasJ1 = new HashMap<>();
        HashMap<Integer,Boolean> respuestasJ2 = new HashMap<>();

        respuestasJ1.put(0,true);
        respuestasJ1.put(1,true);
        respuestasJ1.put(2,true);
        respuestasJ1.put(3,true);
        respuestasJ1.put(4,true);

        respuestasJ2.put(0,false);
        respuestasJ2.put(1,false);
        respuestasJ2.put(2,false);
        respuestasJ2.put(3,false);
        respuestasJ2.put(4,false);

        ArrayList<HashMap<Integer,Boolean>> respuestasJugadores = new ArrayList<>();
        respuestasJugadores.add(respuestasJ1);
        respuestasJugadores.add(respuestasJ2);

        ArrayList<Integer> puntosEsperados = new ArrayList<>();
        puntosEsperados.add(5); //recibe 5 puntos por responder correctamente 5 veces. 0 errores
        puntosEsperados.add(0); //recibe 0 puntos por no contestar

        ArrayList<Boolean> respuestas = new ArrayList<>();
        respuestas.add(true);
        respuestas.add(true);
        respuestas.add(true);
        respuestas.add(true);
        respuestas.add(true);

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPenalidad", "De que color era el caballo blanco de San Martin?", respuestas);

        panel.crearJugador("Rulo");
        panel.crearJugador("Stef");

        panel.hacerPregunta(respuestasJugadores);

        assertEquals(puntosEsperados, panel.pedirPuntos() );
    }
    
}

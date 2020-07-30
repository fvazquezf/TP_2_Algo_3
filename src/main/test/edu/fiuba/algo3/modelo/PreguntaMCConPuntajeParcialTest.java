package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMCConPuntajeParcialTest {
    //Asigna un punto a cada jugador por cada opción correcta que
    //seleccione (aunque no seleccione todas las correctas), siempre y
    //cuando no haya seleccionado ninguna de las opciones
    //incorrectas.

    @Test
    public void Test01CrearMCCon3PosiblesRespuestas() {

        ArrayList<Boolean> respuestas = new ArrayList<>();
        respuestas.add(true);
        respuestas.add(false);
        respuestas.add(false);

        Panel panel = new Panel();
        panel.crearPregunta("preguntaMCConPuntajeParcial","De que color era el caballo blanco de San Martin?", respuestas);

        assertEquals("De que color era el caballo blanco de San Martin?", panel.pasarPregunta());
    }
    @Test
    public void Test02PreguntaMCCon3PosiblesRespuestasYAsignaPuntosCorrectamenteALosJugadores(){

        HashMap<Integer,Boolean> respuestasJ1 = new HashMap<>();
        HashMap<Integer,Boolean> respuestasJ2 = new HashMap<>();

        respuestasJ1.put(0,true);
        respuestasJ1.put(1,true);
        respuestasJ1.put(2,false);

        respuestasJ2.put(0,false);
        respuestasJ2.put(1,true);
        respuestasJ2.put(2,false);

        ArrayList<HashMap<Integer,Boolean>> respuestasJugadores = new ArrayList<>();
        respuestasJugadores.add(respuestasJ1);
        respuestasJugadores.add(respuestasJ2);

        ArrayList<Integer> puntosEsperados = new ArrayList<>();
        puntosEsperados.add(2);
        puntosEsperados.add(1);

        ArrayList<Boolean> respuestas = new ArrayList<>();
        respuestas.add(true);
        respuestas.add(true);
        respuestas.add(false);

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPuntajeParcial", "De que color era el caballo blanco de San Martin?", respuestas);

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
        respuestasJ1.put(4,true);

        respuestasJ2.put(0,true);
        respuestasJ2.put(1,false);
        respuestasJ2.put(2,false);
        respuestasJ2.put(3,false);
        respuestasJ2.put(4,true);

        ArrayList<HashMap<Integer,Boolean>> respuestasJugadores = new ArrayList<>();
        respuestasJugadores.add(respuestasJ1);
        respuestasJugadores.add(respuestasJ2);

        ArrayList<Integer> puntosEsperados = new ArrayList<>();
        puntosEsperados.add(3); //recibe 3 puntos por responder correctamente 3 veces. sin errores
        puntosEsperados.add(2); //recibe 2 puntos por haber contestado 2 bien, sin errores

        ArrayList<Boolean> respuestas = new ArrayList<>();
        respuestas.add(true);
        respuestas.add(true);
        respuestas.add(false);
        respuestas.add(false);
        respuestas.add(true);

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPuntajeParcial", "De que color era el caballo blanco de San Martin?", respuestas);

        panel.crearJugador("Rulo");
        panel.crearJugador("Stef");

        panel.hacerPregunta(respuestasJugadores);

        assertEquals(puntosEsperados, panel.pedirPuntos() );
    }

    @Test
    public void Test04PreguntaMCCon5posiblesRespuestasY4CorrectasYAsignaPuntosCorrectamenteALosJugadores(){

        HashMap<Integer,Boolean> respuestasJ1 = new HashMap<>();
        HashMap<Integer,Boolean> respuestasJ2 = new HashMap<>();

        respuestasJ1.put(0,true);
        respuestasJ1.put(1,true);
        respuestasJ1.put(2,false);
        respuestasJ1.put(3,true);
        respuestasJ1.put(4,false);

        respuestasJ2.put(0,true);
        respuestasJ2.put(1,true);
        respuestasJ2.put(2,true);
        respuestasJ2.put(3,true);
        respuestasJ2.put(4,true);

        ArrayList<HashMap<Integer,Boolean>> respuestasJugadores = new ArrayList<>();
        respuestasJugadores.add(respuestasJ1);
        respuestasJugadores.add(respuestasJ2);

        ArrayList<Integer> puntosEsperados = new ArrayList<>();
        puntosEsperados.add(3); //recibe 3 puntos por responder correctamente 3 veces
        puntosEsperados.add(0); //recibe 0 puntos por contestar una mal

        ArrayList<Boolean> respuestas = new ArrayList<>();
        respuestas.add(true);
        respuestas.add(true);
        respuestas.add(true);
        respuestas.add(true);
        respuestas.add(false);

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPuntajeParcial", "De que color era el caballo blanco de San Martin?", respuestas);

        panel.crearJugador("Rulo");
        panel.crearJugador("Stef");

        panel.hacerPregunta(respuestasJugadores);

        assertEquals(puntosEsperados, panel.pedirPuntos() );
    }

}

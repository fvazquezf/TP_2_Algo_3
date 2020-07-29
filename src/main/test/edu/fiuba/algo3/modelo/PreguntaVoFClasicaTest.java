package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PreguntaVoFClasicaTest {

    // NOTA: QUEDA COMENTADO HASTA LA REFACTORIZACIÓN DEL JSON
    //- Una Pregunta de Verdadero/Falso clásico puede crearse indicándole cual es la respuesta
    //correcta
//    @Test
//    public void Test01CrearVoFClasica() {
//        Panel panel = new Panel();
//        panel.crearPreguntaVoFClasica("rsc/Preguntas.json");
//        assertEquals(true, panel.pasarRespuesta());
//        assertEquals("Es blanco el caballo blanco de San Martin?", panel.pasarPregunta());
//    }
    @Test
    public void Test01CrearVoFClasica() {

        ArrayList<Boolean> respuestas = new ArrayList();
        respuestas.add(true);
        respuestas.add(false);

        Panel panel = new Panel();
        panel.crearPregunta("preguntaVoFClasica","El Caballo blanco de San Martin era Blanco?", respuestas);

        assertEquals("El Caballo blanco de San Martin era Blanco?", panel.pasarPregunta());
    }

    //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
    //correctamente puntos a los jugadores que respondieron correctamente
    @Test
    public void Test02PreguntaVerdaderoFalsoAsignaPuntosCorrectamente(){

        HashMap<Integer,Boolean> respuestasJ1 = new HashMap<Integer, Boolean>();
        HashMap<Integer,Boolean> respuestasJ2 = new HashMap<Integer, Boolean>();

        respuestasJ1.put(0,true);
        respuestasJ1.put(1,false);

        respuestasJ2.put(0,false);
        respuestasJ2.put(1,false);

        ArrayList<HashMap> respuestasJugadores = new ArrayList<HashMap>();
        respuestasJugadores.add(respuestasJ1);
        respuestasJugadores.add(respuestasJ2);

//        ArrayList<String> respuestasJugadores = new ArrayList<String>();
//        respuestasJugadores.add("V");
//        respuestasJugadores.add("F");

        ArrayList<Integer> puntosEsperados = new ArrayList<Integer>();
        puntosEsperados.add(1);
        puntosEsperados.add(0);

        ArrayList<Boolean> respuestas = new ArrayList();
        respuestas.add(true);
        respuestas.add(false);

        Panel panel = new Panel();
//        panel.crearPreguntaVoFClasica("rsc/Preguntas.json");
        panel.crearPregunta("preguntaVoFClasica", "El Caballo blanco de San Martin era Blanco?", respuestas);

        panel.crearJugador("Rulo");
        panel.crearJugador("Stef");

        panel.hacerPregunta(respuestasJugadores);

        assertEquals(puntosEsperados, panel.pedirPuntos() );

    }
}


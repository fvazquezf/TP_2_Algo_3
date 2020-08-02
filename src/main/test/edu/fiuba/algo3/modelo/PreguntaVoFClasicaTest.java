package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PreguntaVoFClasicaTest {

    // NOTA: QUEDA COMENTADO HASTA LA REFACTORIZACIÓN DEL JSON
    //- Una Pregunta de Verdadero/Falso clásico puede crearse indicándole cual es la respuesta
    //correcta

    @Test
    public void Test01CrearVoFClasica() {

        List<Boolean> respuestas = new ArrayList<>();
        respuestas.add(true);
        respuestas.add(false);

        Panel panel = new Panel();
        panel.crearPregunta("preguntaVoFClasica", "El Caballo blanco de San Martin era Blanco?", respuestas);

        assertEquals("El Caballo blanco de San Martin era Blanco?", panel.pasarPregunta());
    }

    //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
    //correctamente puntos a los jugadores que respondieron correctamente
    @Test
    public void Test02PreguntaVerdaderoFalsoAsignaPuntosCorrectamente() {

        HashMap<Integer, Boolean> respuestasJ1 = new HashMap<>();
        HashMap<Integer, Boolean> respuestasJ2 = new HashMap<>();

        respuestasJ1.put(0, true);
        respuestasJ1.put(1, false);

        respuestasJ2.put(0, false);
        respuestasJ2.put(1, false);

        List<HashMap<Integer, Boolean>> respuestasJugadores = new ArrayList<>();
        respuestasJugadores.add(respuestasJ1);
        respuestasJugadores.add(respuestasJ2);

        List<Integer> puntosEsperados = new ArrayList<>();
        puntosEsperados.add(1);
        puntosEsperados.add(0);

        List<Boolean> respuestas = new ArrayList<>();
        respuestas.add(true);
        respuestas.add(false);

        Panel panel = new Panel();
        panel.crearPregunta("preguntaVoFClasica", "El Caballo blanco de San Martin era Blanco?", respuestas);

        panel.crearJugador("Rulo");
        panel.crearJugador("Stef");

        panel.hacerPregunta(respuestasJugadores);

        assertEquals(puntosEsperados, panel.pedirPuntos());

    }

    @Test
    public void Test03CreoPreguntaVoFExamenYSaltaExcepcion() {

        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
        List<Boolean> respuestas = new ArrayList<>();
        respuestas.add(true);
        respuestas.add(false);
        boolean seLanzoError = false;

        try {
            fabricaPreguntas.crearPregunta("preguntaVoFExamen", "El Caballo blanco de San Martin era Blanco?", respuestas);
        } catch (ExcepcionTipoPreguntaInvalida e) {
            seLanzoError = true;
        }

        assertTrue(seLanzoError);

    }
}


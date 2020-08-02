package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVoFClasicaTest {

    //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
    //correctamente puntos a los jugadores que respondieron correctamente
    @Test
    public void Test01CreoPreguntaVerdaderoFalsoYRespondoCorrectamenteYSeAsignaUnPuntoAlJugador() {

        Set<String> respuestasJ1 = new HashSet<>();
        respuestasJ1.add("a");

        Set<String> opcionesCorrectas = new HashSet<>();
        opcionesCorrectas.add("a");

        Panel panel = new Panel();
        panel.crearPregunta("preguntaVoFClasica", "El Caballo blanco de San Martin era Blanco?", opcionesCorrectas);

        panel.crearJugador("Rulo");

        panel.hacerPregunta("Rulo",respuestasJ1);

        assertEquals(1, panel.pedirPuntos("Rulo"));

    }

    @Test
    public void Test02CreoPreguntaVerdaderoFalsoYRespondoIncorrectamenteYSeAsignaCeroPuntosAlJugador() {
        Set<String> respuestasJ1 = new HashSet<>();
        respuestasJ1.add("b");

        Set<String> opcionesCorrectas = new HashSet<>();
        opcionesCorrectas.add("a");

        Panel panel = new Panel();
        panel.crearPregunta("preguntaVoFClasica", "El Caballo blanco de San Martin era Blanco?", opcionesCorrectas);

        panel.crearJugador("Rulo");

        panel.hacerPregunta("Rulo",respuestasJ1);

        assertEquals(0, panel.pedirPuntos("Rulo"));

    }
}


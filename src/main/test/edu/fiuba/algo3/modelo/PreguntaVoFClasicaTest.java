package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PreguntaVoFClasicaTest {

    //- Una Pregunta de Verdadero/Falso clásico puede crearse indicándole cual es la respuesta
    //correcta
    @Test
    public void Test01CrearVoFClasica() {
        Panel panel = new Panel();
        panel.crearPreguntaVoFClasica("rsc/Preguntas.json");
        assertEquals(true, panel.pasarRespuesta());
        assertEquals("Es blanco el caballo blanco de San Martin?", panel.pasarPregunta());
    }

    //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
    //correctamente puntos a los jugadores que respondieron correctamente
    @Test
    public void Test02PreguntaVerdaderoFalsoAsignaPuntosCorrectamente(){

        ArrayList<Integer> resultadoPuntosEsperados = new ArrayList<Integer>();
        resultadoPuntosEsperados.add(1);
        resultadoPuntosEsperados.add(0);

        ArrayList<Boolean> respuestasJugadores = new ArrayList();
        respuestasJugadores.add(true);
        respuestasJugadores.add(false);

        Panel panel = new Panel();
        panel.crearPreguntaVoFClasica("rsc/Preguntas.json");
        panel.crearJugador("Rulo");
        panel.crearJugador("Stef");
        panel.hacerPregunta(respuestasJugadores);
        assertEquals(resultadoPuntosEsperados, panel.pedirPuntos() );

    }

}


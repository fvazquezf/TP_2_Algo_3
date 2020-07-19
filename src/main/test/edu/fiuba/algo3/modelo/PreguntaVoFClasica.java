package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PreguntaVoFClasica{

    //- Una Pregunta de Verdadero/Falso clásico puede crearse indicándole cual es la respuesta
    //correcta
    @Test
    public void Test01CrearVoFClasica() {
        Panel panel = new Panel();
        panel.crearPreguntaVoFClasica("es blanco el color del caballo blanco de san martin", true);
        assertEquals(true, panel.pasarRespuesta());
    }

    //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
    //correctamente puntos a los jugadores que respondieron correctamente
    @Test
    public void Test02PreguntaVerdaderoFalsoAsignaPuntosCorrectamente(){

        ArrayList<Integer> resultadoPuntosEsperados = new ArrayList<Integer>();
        resultadoPuntosEsperados.add(1);
        resultadoPuntosEsperados.add(0);

        Panel panel = new Panel();
        panel.crearPreguntaVoFClasica("es blanco el color del caballo blanco de san martin", true);
        panel.crearJugador("Rulo");
        panel.crearJugador("Stef");
        panel.pedirRespuestas();
        panel.chequearRespuestas();

        assertEquals(panel.pedirPuntos(), resultadoPuntosEsperados );

    }

}


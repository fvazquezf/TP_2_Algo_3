package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PreguntaVoFClasica{
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
        Panel panel = new Panel();
        panel.crearPreguntaVoFClasica("es blanco el color del caballo blanco de san martin", true);
        panel.crearJugador1("Rulo");
        panel.crearJugador2("Stef");
        panel.pedirRespuestas();
        panel.chequearRespuestas();
        assertEquals(panel.pedirPuntosJugador1(), 1);
        assertEquals(panel.pedirPuntosJugador2(), 0);

    }

}


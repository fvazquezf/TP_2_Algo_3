package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntasTest {
    @Test
    public void Test01PreguntaVerdaderaChequeaRespuestaVerdaeraDevuelveVerdadero(){
        Pregunta preguntaVerdadera = new Pregunta("Esto es verdadero", true);

        assertEquals(preguntaVerdadera.chequearRespuesta(true), true);
    }

    @Test
    public void Test02PreguntaVerdaderaChequeaRespuestaFalsaDevuelveFalso(){
        Pregunta preguntaVerdadera = new Pregunta("Esto es verdadero", true);

        assertEquals(preguntaVerdadera.chequearRespuesta(false), false);
    }

    @Test
    public void Test03PreguntaFalsaChequeaRespuestaVerdaderaDevuelveFalso(){
        Pregunta preguntaFalsa = new Pregunta("Esto es falso", false);

        assertEquals(preguntaFalsa.chequearRespuesta(true), false);
    }

    @Test
    public void Test04PreguntaFalsaChequeaRespuestaFalsaDevuelveVerdadero(){
        Pregunta preguntaFalsa = new Pregunta("Esto es falso", false);

        assertEquals(preguntaFalsa.chequearRespuesta(false), true);
    }
}

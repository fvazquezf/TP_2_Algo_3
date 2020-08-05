package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.PreguntaConPenalidad;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaConPenalidadTest {

    @Test
    public void Test01PreguntaConPenalidadComparaConUnaOpcionCorrectaYDevuelveUnPunto() {
        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("a");

        Set<String> respuestasCorrectas = new HashSet<>();
        respuestasCorrectas.add("a");

        PreguntaConPenalidad preguntaConPenalidad = new PreguntaConPenalidad("Pregunta", respuestasCorrectas);

        int puntos = preguntaConPenalidad.compararRespuestas(respuestaElegidasDelJugador);

        assertEquals(1, puntos);
    }

    @Test
    public void Test02PreguntaConPenalidadComparoConUnaOpcionCorrectaYDosIncorrectasDevuelveMenosUnPunto() {
        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("a");
        respuestaElegidasDelJugador.add("b");
        respuestaElegidasDelJugador.add("d");

        Set<String> respuestasCorrectas = new HashSet<>();
        respuestasCorrectas.add("a");

        PreguntaConPenalidad preguntaConPenalidad = new PreguntaConPenalidad("Pregunta", respuestasCorrectas);

        int puntos = preguntaConPenalidad.compararRespuestas(respuestaElegidasDelJugador);

        assertEquals(-1, puntos);
    }

    @Test
    public void Test03PreguntaConPenalidadComparaConDosOpcionesYEligeSolaUnaYDevuelveUnPunto() {
        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("a");

        Set<String> respuestasCorrectas = new HashSet<>();
        respuestasCorrectas.add("a");
        respuestasCorrectas.add("c");

        PreguntaConPenalidad preguntaConPenalidad = new PreguntaConPenalidad("Pregunta", respuestasCorrectas);

        int puntos = preguntaConPenalidad.compararRespuestas(respuestaElegidasDelJugador);

        assertEquals(1, puntos);
    }

    @Test
    public void Test04PreguntaConPenalidadSiPuedeUsarDuplicadorRecibeTresPuntosDevuelveSeis() {
        Set<String> respuesta = new HashSet<>();
        respuesta.add("V");
        respuesta.add("F");

        Jugador jugador1 = new Jugador("Rulo");

        PreguntaConPenalidad pregunta = new PreguntaConPenalidad("pregunta", respuesta);

        jugador1.estadoDuplicador();
        pregunta.usarMultiplicador();
        jugador1.asignarPuntos(3);

        assertEquals(6, jugador1.pedirPuntos());
    }

}

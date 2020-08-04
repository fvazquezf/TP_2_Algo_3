package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.PreguntaClasica;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaClasicaTest {
    @Test
    public void Test01PreguntaClasicaYComparoConUnaOpcionCorrectaYDevuelveUnPunto() {
        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("a");

        Set<String> respuestasCorrectas = new HashSet<>();
        respuestasCorrectas.add("a");

        PreguntaClasica preguntaClasica = new PreguntaClasica("Pregunta", respuestasCorrectas);

        int puntos = preguntaClasica.compararRespuestas(respuestaElegidasDelJugador);

        assertEquals(1, puntos);
    }

    @Test
    public void Test02PreguntaClasicaYComparoConUnaOpcionIncorrectaYDevuelveCeroPuntos() {
        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("b");

        Set<String> respuestasCorrectas = new HashSet<>();
        respuestasCorrectas.add("a");

        PreguntaClasica preguntaClasica = new PreguntaClasica("Pregunta", respuestasCorrectas);

        int puntos = preguntaClasica.compararRespuestas(respuestaElegidasDelJugador);

        assertEquals(0, puntos);
    }

    @Test
    public void Test03PreguntaClasicaYComparoConTresOpcionesCorrectasYDevuelveUnPunto() {
        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("c");
        respuestaElegidasDelJugador.add("a");
        respuestaElegidasDelJugador.add("d");

        Set<String> respuestasCorrectas = new HashSet<>();
        respuestasCorrectas.add("a");
        respuestasCorrectas.add("c");
        respuestasCorrectas.add("d");

        PreguntaClasica preguntaClasica = new PreguntaClasica("Pregunta", respuestasCorrectas);

        int puntos = preguntaClasica.compararRespuestas(respuestaElegidasDelJugador);

        assertEquals(1, puntos);
    }

    @Test
    public void Test04PreguntaClasicaNoSeleccionaUnaOpcionCorrectaYDevuelveCeroPuntos() {
        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("c");
        respuestaElegidasDelJugador.add("a");

        Set<String> respuestasCorrectas = new HashSet<>();
        respuestasCorrectas.add("a");
        respuestasCorrectas.add("c");
        respuestasCorrectas.add("d");

        PreguntaClasica preguntaClasica = new PreguntaClasica("Pregunta", respuestasCorrectas);

        int puntos = preguntaClasica.compararRespuestas(respuestaElegidasDelJugador);

        assertEquals(0, puntos);
    }

    @Test
    public void Test05PreguntaOrderedChoiceComparaCorrectamenteYDevuelveUnPunto() {
        List<String> respuestaElegidasDelJugador = new LinkedList<>();
        respuestaElegidasDelJugador.add("1");
        respuestaElegidasDelJugador.add("2");
        respuestaElegidasDelJugador.add("3");

        List<String> respuestasCorrectas = new LinkedList<>();
        respuestasCorrectas.add("1");
        respuestasCorrectas.add("2");
        respuestasCorrectas.add("3");

        PreguntaClasica preguntaClasica = new PreguntaClasica("Pregunta", respuestasCorrectas);

        int puntos = preguntaClasica.compararRespuestas(respuestaElegidasDelJugador);

        assertEquals(1, puntos);
    }

    @Test
    public void Test06PreguntaOrderedChoiceComparaDesordenadoYDevuelveCeroPuntos() {
        List<String> respuestaElegidasDelJugador = new LinkedList<>();
        respuestaElegidasDelJugador.add("1");
        respuestaElegidasDelJugador.add("3");
        respuestaElegidasDelJugador.add("2");

        List<String> respuestasCorrectas = new LinkedList<>();
        respuestasCorrectas.add("1");
        respuestasCorrectas.add("2");
        respuestasCorrectas.add("3");

        PreguntaClasica preguntaClasica = new PreguntaClasica("Pregunta", respuestasCorrectas);

        int puntos = preguntaClasica.compararRespuestas(respuestaElegidasDelJugador);

        assertEquals(0, puntos);
    }

    @Test
    public void Test07PreguntaOrderedChoiceComparaVacioYDevuelveCeroPuntos() {
        List<String> respuestaElegidasDelJugador = new LinkedList<>();

        List<String> respuestasCorrectas = new LinkedList<>();
        respuestasCorrectas.add("1");
        respuestasCorrectas.add("2");
        respuestasCorrectas.add("3");

        PreguntaClasica preguntaClasica = new PreguntaClasica("Pregunta", respuestasCorrectas);

        int puntos = preguntaClasica.compararRespuestas(respuestaElegidasDelJugador);

        assertEquals(0, puntos);
    }
}

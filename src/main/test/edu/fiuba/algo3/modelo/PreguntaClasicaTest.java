package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionPreguntaNoEsDeTipoConPenalidad;
import edu.fiuba.algo3.modelo.preguntas.PreguntaClasica;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    public void Test08PreguntaClasicaNoPuedeUsarMultiplicadorLanzaExcepcion() {
        Set<String> respuesta = new HashSet<>();
        respuesta.add("V");
        respuesta.add("F");

        PreguntaClasica pregunta = new PreguntaClasica("pregunta", respuesta);
        assertThrows(ExcepcionPreguntaNoEsDeTipoConPenalidad.class, pregunta::activarMultiplicador);
    }

    @Test
    public void Test09PreguntaClasicaGroupChoiceDevuelveUnPuntoPorAsignarCorrectamenteLosGrupos() {
        Set<String> respuestasCorrectas = new HashSet<>();
        respuestasCorrectas.add("a");
        respuestasCorrectas.add("b");
        respuestasCorrectas.add("c");
        respuestasCorrectas.add("grupo1");

        Set<String> respuestasJugador = new HashSet<>();
        respuestasJugador.add("a");
        respuestasJugador.add("b");
        respuestasJugador.add("c");
        respuestasJugador.add("grupo1");

        PreguntaClasica pregunta = new PreguntaClasica("pregunta", respuestasCorrectas);
        int puntos = pregunta.compararRespuestas(respuestasJugador);
        assertEquals(1, puntos);
    }

    @Test
    public void Test10PreguntaClasicaGroupChoiceDevuelveCeroPuntosPorNoAsignarPorCompletoLosGrupos() {
        Set<String> respuestasCorrectas = new HashSet<>();
        respuestasCorrectas.add("a");
        respuestasCorrectas.add("b");
        respuestasCorrectas.add("c");
        respuestasCorrectas.add("grupo1");

        Set<String> respuestasJugador = new HashSet<>();
        respuestasJugador.add("a");
        respuestasJugador.add("b");
        respuestasJugador.add("grupo1");

        PreguntaClasica pregunta = new PreguntaClasica("pregunta", respuestasCorrectas);
        int puntos = pregunta.compararRespuestas(respuestasJugador);
        assertEquals(0, puntos);
    }

    @Test
    public void Test11PreguntaClasicaGroupChoiceDevuelveCeroPuntosPorAsignarIncorrectamenteLosGrupos() {
        Set<String> respuestasCorrectas = new HashSet<>();
        respuestasCorrectas.add("a");
        respuestasCorrectas.add("b");
        respuestasCorrectas.add("c");
        respuestasCorrectas.add("grupo1");

        Set<String> respuestasJugador = new HashSet<>();
        respuestasJugador.add("z");
        respuestasJugador.add("y");
        respuestasJugador.add("x");
        respuestasJugador.add("grupo1");

        PreguntaClasica pregunta = new PreguntaClasica("pregunta", respuestasCorrectas);
        int puntos = pregunta.compararRespuestas(respuestasJugador);
        assertEquals(0, puntos);
    }

    @Test
    public void Test11PreguntaClasicaGroupChoiceDevuelveUnPuntoPorAsignarCorrectamenteEnDesordenLosGrupos() {
        Set<String> respuestasCorrectas = new HashSet<>();
        respuestasCorrectas.add("a");
        respuestasCorrectas.add("b");
        respuestasCorrectas.add("c");
        respuestasCorrectas.add("grupo1");

        Set<String> respuestasJugador = new HashSet<>();
        respuestasJugador.add("b");
        respuestasJugador.add("grupo1");
        respuestasJugador.add("c");
        respuestasJugador.add("a");


        PreguntaClasica pregunta = new PreguntaClasica("pregunta", respuestasCorrectas);
        int puntos = pregunta.compararRespuestas(respuestasJugador);
        assertEquals(1, puntos);
    }
}

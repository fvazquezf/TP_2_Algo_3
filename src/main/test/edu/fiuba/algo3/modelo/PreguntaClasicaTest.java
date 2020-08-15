package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.excepciones.ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.PreguntaVOFClasica;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaClasicaTest {
    @Test
    public void Test01PreguntaVOFClasicaRespondeCorrectamenteYDevuelveUnPunto() {
        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("V");

        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("V");

        Pregunta pregunta = new PreguntaVOFClasica("Para ser grande hay que ser campeon mundial", respuestaCorrecta);

        int puntos = pregunta.compararRespuestas(respuestaElegidasDelJugador);

        assertEquals(1, puntos);
    }

//    @Test
//    public void Test02PreguntaClasicaYComparoConUnaOpcionIncorrectaYDevuelveCeroPuntos() {
//        Set<String> respuestaElegidasDelJugador = new HashSet<>();
//        respuestaElegidasDelJugador.add("b");
//
//        Set<String> respuestasCorrectas = new HashSet<>();
//        respuestasCorrectas.add("a");
//
//        ComportamientoClasico preguntaClasica = new ComportamientoClasico("Pregunta", respuestasCorrectas, respuestasCorrectas);
//
//        int puntos = preguntaClasica.compararRespuestas(respuestaElegidasDelJugador);
//
//        assertEquals(0, puntos);
//    }
//
//    @Test
//    public void Test03PreguntaClasicaYComparoConTresOpcionesCorrectasYDevuelveUnPunto() {
//        Set<String> respuestaElegidasDelJugador = new HashSet<>();
//        respuestaElegidasDelJugador.add("c");
//        respuestaElegidasDelJugador.add("a");
//        respuestaElegidasDelJugador.add("d");
//
//        Set<String> respuestasCorrectas = new HashSet<>();
//        respuestasCorrectas.add("a");
//        respuestasCorrectas.add("c");
//        respuestasCorrectas.add("d");
//
//        ComportamientoClasico preguntaClasica = new ComportamientoClasico("Pregunta", respuestasCorrectas, respuestasCorrectas);
//
//        int puntos = preguntaClasica.compararRespuestas(respuestaElegidasDelJugador);
//
//        assertEquals(1, puntos);
//    }
//
//    @Test
//    public void Test04PreguntaClasicaNoSeleccionaUnaOpcionCorrectaYDevuelveCeroPuntos() {
//        Set<String> respuestaElegidasDelJugador = new HashSet<>();
//        respuestaElegidasDelJugador.add("c");
//        respuestaElegidasDelJugador.add("a");
//
//        Set<String> respuestasCorrectas = new HashSet<>();
//        respuestasCorrectas.add("a");
//        respuestasCorrectas.add("c");
//        respuestasCorrectas.add("d");
//
//        ComportamientoClasico preguntaClasica = new ComportamientoClasico("Pregunta", respuestasCorrectas, respuestasCorrectas);
//
//        int puntos = preguntaClasica.compararRespuestas(respuestaElegidasDelJugador);
//
//        assertEquals(0, puntos);
//    }
//
//    @Test
//    public void Test05PreguntaOrderedChoiceComparaCorrectamenteYDevuelveUnPunto() {
//        List<String> respuestaElegidasDelJugador = new LinkedList<>();
//        respuestaElegidasDelJugador.add("1");
//        respuestaElegidasDelJugador.add("2");
//        respuestaElegidasDelJugador.add("3");
//
//        List<String> respuestasCorrectas = new LinkedList<>();
//        respuestasCorrectas.add("1");
//        respuestasCorrectas.add("2");
//        respuestasCorrectas.add("3");
//
//        ComportamientoClasico preguntaClasica = new ComportamientoClasico("Pregunta", respuestasCorrectas, respuestasCorrectas);
//
//        int puntos = preguntaClasica.compararRespuestas(respuestaElegidasDelJugador);
//
//        assertEquals(1, puntos);
//    }
//
//    @Test
//    public void Test06PreguntaOrderedChoiceComparaDesordenadoYDevuelveCeroPuntos() {
//        List<String> respuestaElegidasDelJugador = new LinkedList<>();
//        respuestaElegidasDelJugador.add("1");
//        respuestaElegidasDelJugador.add("3");
//        respuestaElegidasDelJugador.add("2");
//
//        List<String> respuestasCorrectas = new LinkedList<>();
//        respuestasCorrectas.add("1");
//        respuestasCorrectas.add("2");
//        respuestasCorrectas.add("3");
//
//        ComportamientoClasico preguntaClasica = new ComportamientoClasico("Pregunta", respuestasCorrectas, respuestasCorrectas);
//
//        int puntos = preguntaClasica.compararRespuestas(respuestaElegidasDelJugador);
//
//        assertEquals(0, puntos);
//    }
//
//    @Test
//    public void Test07PreguntaOrderedChoiceComparaVacioYDevuelveCeroPuntos() {
//        List<String> respuestaElegidasDelJugador = new LinkedList<>();
//
//        List<String> respuestasCorrectas = new LinkedList<>();
//        respuestasCorrectas.add("1");
//        respuestasCorrectas.add("2");
//        respuestasCorrectas.add("3");
//
//        ComportamientoClasico preguntaClasica = new ComportamientoClasico("Pregunta", respuestasCorrectas, respuestasCorrectas);
//
//        int puntos = preguntaClasica.compararRespuestas(respuestaElegidasDelJugador);
//
//        assertEquals(0, puntos);
//    }
//
//    @Test
//    public void Test08PreguntaClasicaNoPuedeUsarMultiplicadorLanzaExcepcion() {
//        Set<String> respuesta = new HashSet<>();
//        respuesta.add("V");
//        respuesta.add("F");
//
//        ComportamientoClasico pregunta = new ComportamientoClasico("pregunta", respuesta, respuesta);
//        assertThrows(ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador.class, pregunta::activarMultiplicador);
//    }
//
//    @Test
//    public void Test09PreguntaClasicaGroupChoiceDevuelveUnPuntoPorAsignarCorrectamenteLosGrupos() {
//        Set<String> respuestasCorrectas = new HashSet<>();
//        respuestasCorrectas.add("a");
//        respuestasCorrectas.add("b");
//        respuestasCorrectas.add("c");
//        respuestasCorrectas.add("grupo1");
//
//        Set<String> respuestasJugador = new HashSet<>();
//        respuestasJugador.add("a");
//        respuestasJugador.add("b");
//        respuestasJugador.add("c");
//        respuestasJugador.add("grupo1");
//
//        ComportamientoClasico pregunta = new ComportamientoClasico("pregunta", respuestasCorrectas, respuestasCorrectas);
//        int puntos = pregunta.compararRespuestas(respuestasJugador);
//        assertEquals(1, puntos);
//    }
//
//    @Test
//    public void Test10PreguntaClasicaGroupChoiceDevuelveCeroPuntosPorNoAsignarPorCompletoLosGrupos() {
//        Set<String> respuestasCorrectas = new HashSet<>();
//        respuestasCorrectas.add("a");
//        respuestasCorrectas.add("b");
//        respuestasCorrectas.add("c");
//        respuestasCorrectas.add("grupo1");
//
//        Set<String> respuestasJugador = new HashSet<>();
//        respuestasJugador.add("a");
//        respuestasJugador.add("b");
//        respuestasJugador.add("grupo1");
//
//        ComportamientoClasico pregunta = new ComportamientoClasico("pregunta", respuestasCorrectas, respuestasCorrectas);
//        int puntos = pregunta.compararRespuestas(respuestasJugador);
//        assertEquals(0, puntos);
//    }
//
//    @Test
//    public void Test11PreguntaClasicaGroupChoiceDevuelveCeroPuntosPorAsignarIncorrectamenteLosGrupos() {
//        Set<String> respuestasCorrectas = new HashSet<>();
//        respuestasCorrectas.add("a");
//        respuestasCorrectas.add("b");
//        respuestasCorrectas.add("c");
//        respuestasCorrectas.add("grupo1");
//
//        Set<String> respuestasJugador = new HashSet<>();
//        respuestasJugador.add("z");
//        respuestasJugador.add("y");
//        respuestasJugador.add("x");
//        respuestasJugador.add("grupo1");
//
//        ComportamientoClasico pregunta = new ComportamientoClasico("pregunta", respuestasCorrectas, respuestasCorrectas);
//        int puntos = pregunta.compararRespuestas(respuestasJugador);
//        assertEquals(0, puntos);
//    }
//
//    @Test
//    public void Test11PreguntaClasicaGroupChoiceDevuelveUnPuntoPorAsignarCorrectamenteEnDesordenLosGrupos() {
//        Set<String> respuestasCorrectas = new HashSet<>();
//        respuestasCorrectas.add("a");
//        respuestasCorrectas.add("b");
//        respuestasCorrectas.add("c");
//        respuestasCorrectas.add("grupo1");
//
//        Set<String> respuestasJugador = new HashSet<>();
//        respuestasJugador.add("b");
//        respuestasJugador.add("grupo1");
//        respuestasJugador.add("c");
//        respuestasJugador.add("a");
//
//
//        ComportamientoClasico pregunta = new ComportamientoClasico("pregunta", respuestasCorrectas, respuestasCorrectas);
//        int puntos = pregunta.compararRespuestas(respuestasJugador);
//        assertEquals(1, puntos);
//    }

}

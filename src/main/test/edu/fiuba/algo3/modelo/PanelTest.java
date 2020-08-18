package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Grupo;
import edu.fiuba.algo3.Preguntas;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.preguntas.FabricaPreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PanelTest {

    @Test
    public void test01PreguntaVoFClasicaJugador1ContestaBienSeLeAsigna1PuntoJugador2ContestaMalSeLeAigna0Puntos() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
        String[] respuestaCorrecta = new String[1];
        respuestaCorrecta[0] = "a";

        String[] todasLasRespuestas = new String[0];

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("Pares", "Imapres"));

        Preguntas pregunta = new Preguntas("preguntaVoFClasica", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
        Preguntas[] preguntas = new Preguntas[1];
        preguntas[0] = pregunta;

        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        LectorPreguntas mockedLector = mock(LectorPreguntas.class);

        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("a");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("b");

        Panel panel = new Panel(mockedLector);


        panel.crearJugadores("Stef", "Rulo");


        panel.hacerPregunta(respuestaJugador1);
        assertEquals(1, panel.pedirJugadorSiguiente().pedirPuntos());

        try {
            panel.hacerPregunta(respuestaJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(0, panel.pedirJugadorActual().pedirPuntos());
        }
    }
//
//    @Test
//    public void test02PreguntaMCClasicaJugador1ContestaBienSeLeAsignaUnPuntoJugador2ConstestaMalSeLeAsigna0Puntos() {
//        String[] respuestaCorrecta = new String[4];
//        String[] todasLasRespuestas = new String[5];
//        respuestaCorrecta[0] = "a";
//        respuestaCorrecta[1] = "b";
//        respuestaCorrecta[2] = "c";
//        respuestaCorrecta[3] = "d";
//
//        todasLasRespuestas[0] = "d";
//        todasLasRespuestas[1] = "b";
//        todasLasRespuestas[2] = "c";
//        todasLasRespuestas[3] = "d";
//        todasLasRespuestas[4] = "z";
//
//        Set<String> respuestaJugador1 = new HashSet<>();
//        respuestaJugador1.add("d");
//        respuestaJugador1.add("a");
//        respuestaJugador1.add("b");
//        respuestaJugador1.add("c");
//
//        Set<String> respuestaJugador2 = new HashSet<>();
//        respuestaJugador2.add("d");
//        respuestaJugador2.add("a");
//        respuestaJugador2.add("b");
//        respuestaJugador2.add("c");
//        respuestaJugador2.add("z");
//
//        List<Grupo> grupos = new LinkedList<>();
//        grupos.add(new Grupo("UnGrupo", "OtroGrupo"));
//
//        Preguntas pregunta = new Preguntas("preguntaMCClasica", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
//        Preguntas[] preguntas = new Preguntas[1];
//        preguntas[0] = pregunta;
//
//        LectorPreguntas mockedLector = mock(LectorPreguntas.class);
//
//        when(mockedLector.leerPreguntas()).thenReturn(preguntas);
//
//        Panel panel = new Panel(mockedLector);
//
//        panel.crearJugadores("Stef", "Rulo");
//
//        panel.hacerPregunta(respuestaJugador1);
//        assertEquals(1, panel.pedirJugadorSiguiente().pedirPuntos());
//
//        try {
//            panel.hacerPregunta(respuestaJugador2);
//        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
//            assertEquals(0, panel.pedirJugadorActual().pedirPuntos());
//        }
//    }
//
//    @Test
//    public void test03PreguntaOCJugador1ContestaOrdenadoSeLeAsignaUnPuntoJugador2ContestaDesordenadoSeLeAsigna0Puntos() {
//        String[] respuestaCorrecta = new String[4];
//
//        respuestaCorrecta[0] = "j";
//        respuestaCorrecta[1] = "b";
//        respuestaCorrecta[2] = "h";
//        respuestaCorrecta[3] = "d";
//
//        String[] todasLasRespuestas = new String[4];
//        todasLasRespuestas[0] = "j";
//        todasLasRespuestas[1] = "b";
//        todasLasRespuestas[2] = "h";
//        todasLasRespuestas[3] = "d";
//
//        List<String> respuestaJugador1 = new LinkedList<>();
//        respuestaJugador1.add("j");
//        respuestaJugador1.add("b");
//        respuestaJugador1.add("h");
//        respuestaJugador1.add("d");
//
//        List<String> respuestaJugador2 = new LinkedList<>();
//        respuestaJugador2.add("b");
//        respuestaJugador2.add("j");
//        respuestaJugador2.add("h");
//        respuestaJugador2.add("d");
//
//        List<Grupo> grupos = new LinkedList<>();
//        grupos.add(new Grupo("UnGrupo", "OtroGrupo"));
//
//        Preguntas pregunta = new Preguntas("preguntaOC", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
//        Preguntas[] preguntas = new Preguntas[1];
//        preguntas[0] = pregunta;
//
//        LectorPreguntas mockedLector = mock(LectorPreguntas.class);
//
//        when(mockedLector.leerPreguntas()).thenReturn(preguntas);
//        Panel panel = new Panel(mockedLector);
//
//
//        panel.crearJugadores("Stef", "Rulo");
//
//        panel.hacerPregunta(respuestaJugador1);
//        assertEquals(1, panel.pedirJugadorSiguiente().pedirPuntos());
//
//        try {
//            panel.hacerPregunta(respuestaJugador2);
//        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
//            assertEquals(0, panel.pedirJugadorActual().pedirPuntos());
//        }
//    }
//
//    @Test
//    public void test04PreguntaMCConPuntajeParcialJugador1Contesta2BienDe3SeLeAsigna2PuntosJugador2Contesta2BienY1MalSeLeAsigna0Puntos() {
//        String[] respuestaCorrecta = new String[3];
//        respuestaCorrecta[0] = "a";
//        respuestaCorrecta[1] = "b";
//        respuestaCorrecta[2] = "c";
//
//        String[] todasLasRespuestas = new String[4];
//        todasLasRespuestas[0] = "a";
//        todasLasRespuestas[1] = "b";
//        todasLasRespuestas[2] = "c";
//        todasLasRespuestas[3] = "h";
//
//        Set<String> respuestaJugador1 = new HashSet<>();
//        respuestaJugador1.add("a");
//        respuestaJugador1.add("c");
//
//        Set<String> respuestaJugador2 = new HashSet<>();
//        respuestaJugador2.add("a");
//        respuestaJugador2.add("c");
//        respuestaJugador2.add("h");
//
//        List<Grupo> grupos = new LinkedList<>();
//        grupos.add(new Grupo("UnGrupo", "OtroGrupo"));
//
//        Preguntas pregunta = new Preguntas("preguntaMCConPuntajeParcial", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
//        Preguntas[] preguntas = new Preguntas[1];
//        preguntas[0] = pregunta;
//
//        LectorPreguntas mockedLector = mock(LectorPreguntas.class);
//
//        when(mockedLector.leerPreguntas()).thenReturn(preguntas);
//        Panel panel = new Panel(mockedLector);
//
//        panel.crearJugadores("Stef", "Rulo");
//
//        panel.hacerPregunta(respuestaJugador1);
//        assertEquals(2, panel.pedirJugadorSiguiente().pedirPuntos());
//
//        try {
//            panel.hacerPregunta(respuestaJugador2);
//        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
//            assertEquals(0, panel.pedirJugadorActual().pedirPuntos());
//        }
//    }
//
//    @Test
//    public void test05PreguntaMCConPuntajeParcialJugador1Contesta3BienDe3SeLeAsigna3PuntosJugador2Contesta2MalSeLeAsigna0Puntos() {
//        String[] respuestaCorrecta = new String[3];
//        respuestaCorrecta[0] = "h";
//        respuestaCorrecta[1] = "u";
//        respuestaCorrecta[2] = "p";
//
//        String[] todasLasRespuestas = new String[5];
//        todasLasRespuestas[0] = "h";
//        todasLasRespuestas[1] = "u";
//        todasLasRespuestas[2] = "p";
//        todasLasRespuestas[3] = "a";
//        todasLasRespuestas[4] = "c";
//
//        Set<String> respuestaJugador1 = new HashSet<>();
//        respuestaJugador1.add("p");
//        respuestaJugador1.add("u");
//        respuestaJugador1.add("h");
//
//        Set<String> respuestaJugador2 = new HashSet<>();
//        respuestaJugador2.add("a");
//        respuestaJugador2.add("c");
//
//        List<Grupo> grupos = new LinkedList<>();
//        grupos.add(new Grupo("UnGrupo", "OtroGrupo"));
//
//        Preguntas pregunta = new Preguntas("preguntaMCConPuntajeParcial", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
//        Preguntas[] preguntas = new Preguntas[1];
//        preguntas[0] = pregunta;
//
//        LectorPreguntas mockedLector = mock(LectorPreguntas.class);
//
//        when(mockedLector.leerPreguntas()).thenReturn(preguntas);
//        Panel panel = new Panel(mockedLector);
//
//        panel.crearJugadores("Stef", "Rulo");
//
//        panel.hacerPregunta(respuestaJugador1);
//        assertEquals(3, panel.pedirJugadorSiguiente().pedirPuntos());
//
//        try {
//            panel.hacerPregunta(respuestaJugador2);
//        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
//            assertEquals(0, panel.pedirJugadorActual().pedirPuntos());
//        }
//    }
//
//    @Test
//    public void test06PreguntaMCConPenalidadJugador1ContestaBien2Y1MalSeLeAsigna1PuntoJugador2Contesta1MalYSeLeAsignaMenos1Puntos() {
//        String[] respuestaCorrecta = new String[3];
//        respuestaCorrecta[0] = "a";
//        respuestaCorrecta[1] = "b";
//        respuestaCorrecta[2] = "c";
//
//        String[] todasLasRespuestas = new String[4];
//        todasLasRespuestas[0] = "a";
//        todasLasRespuestas[1] = "b";
//        todasLasRespuestas[2] = "c";
//        todasLasRespuestas[3] = "z";
//
//        Set<String> respuestaJugador1 = new HashSet<>();
//        respuestaJugador1.add("b");
//        respuestaJugador1.add("c");
//        respuestaJugador1.add("z");
//
//        Set<String> respuestaJugador2 = new HashSet<>();
//        respuestaJugador2.add("z");
//
//        List<Grupo> grupos = new LinkedList<>();
//        grupos.add(new Grupo("UnGrupo", "OtroGrupo"));
//
//        Preguntas pregunta = new Preguntas("preguntaMCConPenalidad", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
//        Preguntas[] preguntas = new Preguntas[1];
//        preguntas[0] = pregunta;
//
//        LectorPreguntas mockedLector = mock(LectorPreguntas.class);
//
//        when(mockedLector.leerPreguntas()).thenReturn(preguntas);
//        Panel panel = new Panel(mockedLector);
//
//        panel.crearJugadores("Stef", "Rulo");
//
//        panel.hacerPregunta(respuestaJugador1);
//        assertEquals(1, panel.pedirJugadorSiguiente().pedirPuntos());
//
//        try {
//            panel.hacerPregunta(respuestaJugador2);
//        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
//            assertEquals(-1, panel.pedirJugadorActual().pedirPuntos());
//        }
//    }
////
////    @Test
////    public void test07PreguntaMCConPenalidadJugador1ContestaBien3SeLeAsigna3PuntosJugador2Contesta3Bien1MalSeLeAsigna2Puntos() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////        respuestaCorrecta.add("b");
////        respuestaCorrecta.add("c");
////
////        Set<String> respuestaJugador1 = new HashSet<>();
////        respuestaJugador1.add("b");
////        respuestaJugador1.add("c");
////        respuestaJugador1.add("a");
////
////        Set<String> respuestaJugador2 = new HashSet<>();
////        respuestaJugador2.add("z");
////        respuestaJugador2.add("b");
////        respuestaJugador2.add("c");
////        respuestaJugador2.add("a");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaMCConPenalidad", "pregunta", respuestaCorrecta, todasLasRespuestas);
////        panel.crearJugadores("Stef", "Rulo");
////
////        panel.hacerPregunta(respuestaJugador1);
////        assertEquals(3, panel.pedirJugadorSiguiente().pedirPuntos());
////
////
////        try {
////            panel.hacerPregunta(respuestaJugador2);
////        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
////            assertEquals(2, panel.pedirJugadorSiguiente().pedirPuntos());
////        }
////    }
////
////    @Test
////    public void gtest08PreguntaVoFConPenalidadJugador1ContestaBienSeLeAsigna1PuntoJugador2ContestaMalSeLeAsignaMenos1Punto() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////
////        Set<String> respuestaJugador1 = new HashSet<>();
////        respuestaJugador1.add("a");
////
////        Set<String> respuestaJugador2 = new HashSet<>();
////        respuestaJugador2.add("b");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaVoFConPenalidad", "pregunta", respuestaCorrecta, todasLasRespuestas);
////        panel.crearJugadores("Stef", "Rulo");
////
////        panel.hacerPregunta(respuestaJugador1);
////        assertEquals(1, panel.pedirJugadorSiguiente().pedirPuntos());
////
////        try {
////            panel.hacerPregunta(respuestaJugador2);
////        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
////            assertEquals(-1, panel.pedirJugadorSiguiente().pedirPuntos());
////        }
////    }
////
////    @Test
////    public void test09PreguntaVoFConPenalidadJugador1UsaMultiplicadorX2ContestaMalSeLeAsignaMenos2PuntosJugador2UsaMultiplicadorX2ContestaBienSeLeAsigna2Puntos() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////
////        Set<String> respuestaJugador1 = new HashSet<>();
////        respuestaJugador1.add("b");
////
////        Set<String> respuestaJugador2 = new HashSet<>();
////        respuestaJugador2.add("a");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaVoFConPenalidad", "pregunta", respuestaCorrecta, todasLasRespuestas);
////        panel.crearJugadores("Stef", "Rulo");
////
////        panel.activarDuplicador();
////        panel.hacerPregunta(respuestaJugador1);
////        assertEquals(-2, panel.pedirJugadorSiguiente().pedirPuntos());
////
////        panel.activarDuplicador();
////
////        try {
////            panel.hacerPregunta(respuestaJugador2);
////        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
////            assertEquals(2, panel.pedirJugadorSiguiente().pedirPuntos());
////        }
////    }
////
////    @Test
////    public void test10PreguntaVoFConPenalidadJugador1UsaMultiplicadorX3ContestaMalSeLeAsignaMenos3PuntosJugador2NoUsaMultiplicadorContestaBienSeLeAsigna1Punto() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////
////        Set<String> respuestaJugador1 = new HashSet<>();
////        respuestaJugador1.add("b");
////
////        Set<String> respuestaJugador2 = new HashSet<>();
////        respuestaJugador2.add("a");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaVoFConPenalidad", "pregunta", respuestaCorrecta, todasLasRespuestas);
////        panel.crearJugadores("Stef", "Rulo");
////
////        panel.activarTriplicador();
////        panel.hacerPregunta(respuestaJugador1);
////
////        assertEquals(-3, panel.pedirJugadorSiguiente().pedirPuntos());
////
////        try {
////            panel.hacerPregunta(respuestaJugador2);
////        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
////            assertEquals(1, panel.pedirJugadorSiguiente().pedirPuntos());
////        }
////    }
////
////    @Test
////    public void test11PreguntaMCConPenalidadJugador1UsaMultiplicadorX2Contesta2MalSeLeAsignaMenos4PuntosJugador2UsaMultiplicadorX2Contesta3BienSeLeAsigna6Puntos() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////        respuestaCorrecta.add("c");
////        respuestaCorrecta.add("d");
////
////        Set<String> respuestaJugador1 = new HashSet<>();
////        respuestaJugador1.add("b");
////        respuestaJugador1.add("e");
////
////        Set<String> respuestaJugador2 = new HashSet<>();
////        respuestaJugador2.add("a");
////        respuestaJugador2.add("d");
////        respuestaJugador2.add("c");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaMCConPenalidad", "pregunta", respuestaCorrecta, todasLasRespuestas);
////        panel.crearJugadores("Stef", "Rulo");
////
////        panel.activarDuplicador();
////        panel.hacerPregunta(respuestaJugador1);
////        assertEquals(-4, panel.pedirJugadorSiguiente().pedirPuntos());
////
////        panel.activarDuplicador();
////        try {
////            panel.hacerPregunta(respuestaJugador2);
////        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
////            assertEquals(6, panel.pedirJugadorSiguiente().pedirPuntos());
////        }
////    }
////
////    @Test
////    public void test12PreguntaMCConPenalidadJugador1UsaMultiplicadorX3Contesta1Bien2MalSeLeAsignaMenos3PuntosJugador2UsaMultiplicadorX3Contesta2BienSeLeAsigna6Puntos() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("d");
////        respuestaCorrecta.add("c");
////        respuestaCorrecta.add("e");
////
////        Set<String> respuestaJugador1 = new HashSet<>();
////        respuestaJugador1.add("b");
////        respuestaJugador1.add("e");
////        respuestaJugador1.add("z");
////
////        Set<String> respuestaJugador2 = new HashSet<>();
////        respuestaJugador2.add("e");
////        respuestaJugador2.add("d");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaMCConPenalidad", "pregunta", respuestaCorrecta, todasLasRespuestas);
////        panel.crearJugadores("Stef", "Rulo");
////
////        panel.activarTriplicador();
////        panel.hacerPregunta(respuestaJugador1);
////        assertEquals(-3, panel.pedirJugadorSiguiente().pedirPuntos());
////
////
////        panel.activarTriplicador();
////        try {
////            panel.hacerPregunta(respuestaJugador2);
////        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
////            assertEquals(6, panel.pedirJugadorSiguiente().pedirPuntos());
////        }
////    }
////
////    @Test
////    public void test13PidoUsarDosVecesElDuplicadorYSeLanzaExcepcion() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////        respuestaCorrecta.add("c");
////        respuestaCorrecta.add("d");
////        respuestaCorrecta.add("e");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaVoFConPenalidad", "pregunta", respuestaCorrecta, todasLasRespuestas);
////        panel.crearJugadores("Stef", "Rulo");
////        panel.activarDuplicador();
////        assertThrows(ExcepcionYaUsasteTuDuplicadorSalame.class, panel::activarDuplicador);
////    }
////
////    @Test
////    public void test14PidoUsarDosVecesElTriplicadorYSeLanzaExcepcion() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////        respuestaCorrecta.add("c");
////        respuestaCorrecta.add("d");
////        respuestaCorrecta.add("e");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaVoFConPenalidad", "pregunta", respuestaCorrecta, todasLasRespuestas);
////        panel.crearJugadores("Stef", "Rulo");
////        panel.activarTriplicador();
////        assertThrows(ExcepcionYaUsasteTuTriplicadorSalame.class, panel::activarTriplicador);
////    }
////
////    @Test
////    public void test15PreguntaMCClasicaPidoUsarDuplicadorYLanzaExcepcion() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////        respuestaCorrecta.add("c");
////        respuestaCorrecta.add("d");
////        respuestaCorrecta.add("e");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaMCClasica", "pregunta", respuestaCorrecta, todasLasRespuestas);
////        panel.crearJugadores("Stef", "Rulo");
////
////        assertThrows(ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador.class, panel::activarDuplicador);
////    }
////
////    @Test
////    public void test16PreguntaMCConPuntajeParcialPidoUsarTriplicadorYLanzaExcepcion() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////        respuestaCorrecta.add("c");
////        respuestaCorrecta.add("d");
////        respuestaCorrecta.add("e");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaMCConPuntajeParcial", "pregunta", respuestaCorrecta, todasLasRespuestas);
////        panel.crearJugadores("Stef", "Rulo");
////
////        assertThrows(ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador.class, panel::activarTriplicador);
////    }
////
////    @Test
////    public void test17PreguntaVoFConPenalidadNoSePuedeUsarExclusividad() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaVoFConPenalidad", "pregunta", respuestaCorrecta, todasLasRespuestas);
////
////        panel.crearJugadores("Stef", "Rulo");
////
////        assertThrows(ExcepcionSoloPreguntasClasicasYPuntajeParcialPuedeUsarExclusividad.class, panel::activarExclusividad);
////    }
////
////    @Test
////    public void test18PreguntaMCConPenalidadNoSePuedeUsarExclusividad() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaMCConPenalidad", "pregunta", respuestaCorrecta, todasLasRespuestas);
////
////        panel.crearJugadores("Stef", "Rulo");
////
////        assertThrows(ExcepcionSoloPreguntasClasicasYPuntajeParcialPuedeUsarExclusividad.class, panel::activarExclusividad);
////    }
////
////    @Test
////    public void test19PreguntaVoFClasicaJugador1UsaExlusividadContestaBienJugador2ContestaMalSeLeAsignaElDobleDePuntosAJugador1() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////
////        Set<String> respuestaJugador1 = new HashSet<>();
////        respuestaJugador1.add("a");
////
////        Set<String> respuestaJugador2 = new HashSet<>();
////        respuestaJugador2.add("b");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaVoFClasica", "pregunta", respuestaCorrecta, todasLasRespuestas);
////        panel.crearJugadores("Stef", "Ivan");
////
////        panel.activarExclusividad();
////        panel.hacerPregunta(respuestaJugador1);
////
////        try {
////            panel.hacerPregunta(respuestaJugador2);
////        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
////            assertEquals(2, panel.pedirJugadorActual().pedirPuntos());
////            assertEquals(0, panel.pedirJugadorSiguiente().pedirPuntos());
////        }
////    }
////
////    @Test
////    public void test20PreguntaVoFClasicaAmbosJugadoresUsanExlusividadElPrimeroContestaMalElSegundoBienYSeLeAsignaElCuadrupleDePutntosAlSegundo() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////
////        Set<String> respuestaJugador1 = new HashSet<>();
////        respuestaJugador1.add("b");
////
////        Set<String> respuestaJugador2 = new HashSet<>();
////        respuestaJugador2.add("a");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaVoFClasica", "pregunta", respuestaCorrecta, todasLasRespuestas);
////
////        panel.crearJugadores("Stef", "Ivan");
////
////        panel.activarExclusividad();
////        panel.hacerPregunta(respuestaJugador1);
////
////        panel.activarExclusividad();
////
////        try {
////            panel.hacerPregunta(respuestaJugador2);
////        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
////            assertEquals(0, panel.pedirJugadorActual().pedirPuntos());
////            assertEquals(4, panel.pedirJugadorSiguiente().pedirPuntos());
////        }
////    }
////
////    @Test
////    public void test21PreguntaVoFClasicaAmbosJugadoresActivanExlusividadAmbosContestanBienYNoSeMultiplicanLosPuntajes() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////
////        Set<String> respuestaJugador1 = new HashSet<>();
////        respuestaJugador1.add("a");
////
////        Set<String> respuestaJugador2 = new HashSet<>();
////        respuestaJugador2.add("a");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaVoFClasica", "pregunta", respuestaCorrecta, todasLasRespuestas);
////
////        panel.crearJugadores("Stef", "Ivan");
////
////        panel.activarExclusividad();
////        panel.hacerPregunta(respuestaJugador1);
////
////        panel.activarExclusividad();
////
////        try {
////            panel.hacerPregunta(respuestaJugador2);
////        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
////            assertEquals(1, panel.pedirJugadorActual().pedirPuntos());
////            assertEquals(1, panel.pedirJugadorSiguiente().pedirPuntos());
////        }
////    }
////
////    @Test
////    public void test22PreguntaVoFClasicaAmbosJugadoresActivanExlusividadAmbosContestanMalYLosPuntosSon0() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////
////        Set<String> respuestaJugador1 = new HashSet<>();
////        respuestaJugador1.add("b");
////
////        Set<String> respuestaJugador2 = new HashSet<>();
////        respuestaJugador2.add("b");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaVoFClasica", "pregunta", respuestaCorrecta, todasLasRespuestas);
////
////        panel.crearJugadores("Stef", "Ivan");
////
////        panel.activarExclusividad();
////        panel.hacerPregunta(respuestaJugador1);
////
////        panel.activarExclusividad();
////
////        try {
////            panel.hacerPregunta(respuestaJugador2);
////        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
////            assertEquals(0, panel.pedirJugadorActual().pedirPuntos());
////            assertEquals(0, panel.pedirJugadorSiguiente().pedirPuntos());
////        }
////    }
////
////    @Test
////    public void test23PreguntaMCClasicaJugador1ActivaExclusividadSoloElContestaBienYSeDuplicaSuPuntaje() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////        respuestaCorrecta.add("c");
////        respuestaCorrecta.add("d");
////
////        Set<String> respuestaJugador1 = new HashSet<>();
////        respuestaJugador1.add("d");
////        respuestaJugador1.add("a");
////        respuestaJugador1.add("c");
////
////        Set<String> respuestaJugador2 = new HashSet<>();
////        respuestaJugador2.add("b");
////        respuestaJugador2.add("a");
////        respuestaJugador2.add("c");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaMCClasica", "pregunta", respuestaCorrecta, todasLasRespuestas);
////
////        panel.crearJugadores("Stef", "Ivan");
////
////        panel.activarExclusividad();
////        panel.hacerPregunta(respuestaJugador1);
////
////        try {
////            panel.hacerPregunta(respuestaJugador2);
////        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
////            assertEquals(2, panel.pedirJugadorActual().pedirPuntos());
////            assertEquals(0, panel.pedirJugadorSiguiente().pedirPuntos());
////        }
////    }
////
////    @Test
////    public void test24PreguntaMCClasicaJugador1ActivaExclusividadSoloElSegundoJugadorContestaBienYSeLeDuplicaeElPuntajeAJugado2() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////        respuestaCorrecta.add("c");
////        respuestaCorrecta.add("b");
////
////        Set<String> respuestaJugador1 = new HashSet<>();
////        respuestaJugador1.add("d");
////        respuestaJugador1.add("a");
////        respuestaJugador1.add("c");
////
////        Set<String> respuestaJugador2 = new HashSet<>();
////        respuestaJugador2.add("b");
////        respuestaJugador2.add("a");
////        respuestaJugador2.add("c");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaMCClasica", "pregunta", respuestaCorrecta, todasLasRespuestas);
////
////        panel.crearJugadores("Stef", "Ivan");
////
////        panel.activarExclusividad();
////        panel.hacerPregunta(respuestaJugador1);
////        try {
////            panel.hacerPregunta(respuestaJugador2);
////        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
////            assertEquals(0, panel.pedirJugadorActual().pedirPuntos());
////            assertEquals(2, panel.pedirJugadorSiguiente().pedirPuntos());
////        }
////    }
////
////    @Test
////    public void test25PreguntaMCClasicaJugador2ActivaExclusividadAmbosContestanBienYNoSeLeDuplicaElPuntaje() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////        respuestaCorrecta.add("c");
////        respuestaCorrecta.add("b");
////
////        Set<String> respuestaJugador1 = new HashSet<>();
////        respuestaJugador1.add("b");
////        respuestaJugador1.add("a");
////        respuestaJugador1.add("c");
////
////        Set<String> respuestaJugador2 = new HashSet<>();
////        respuestaJugador2.add("c");
////        respuestaJugador2.add("a");
////        respuestaJugador2.add("b");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaMCClasica", "pregunta", respuestaCorrecta, todasLasRespuestas);
////
////        panel.crearJugadores("Stef", "Ivan");
////
////        panel.hacerPregunta(respuestaJugador1);
////
////        panel.activarExclusividad();
////        try {
////            panel.hacerPregunta(respuestaJugador2);
////        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
////            assertEquals(1, panel.pedirJugadorActual().pedirPuntos());
////            assertEquals(1, panel.pedirJugadorSiguiente().pedirPuntos());
////        }
////    }
////
////    @Test
////    public void test26PreguntaMCClasicaJugador2ActivaExclusividadAmbosContestanMalYNOSeLeDuplicaElPuntaje() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////        respuestaCorrecta.add("c");
////        respuestaCorrecta.add("b");
////
////        Set<String> respuestaJugador1 = new HashSet<>();
////        respuestaJugador1.add("b");
////        respuestaJugador1.add("a");
////        respuestaJugador1.add("d");
////
////        Set<String> respuestaJugador2 = new HashSet<>();
////        respuestaJugador2.add("c");
////        respuestaJugador2.add("d");
////        respuestaJugador2.add("b");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaMCClasica", "pregunta", respuestaCorrecta, todasLasRespuestas);
////
////        panel.crearJugadores("Stef", "Ivan");
////
////        panel.hacerPregunta(respuestaJugador1);
////
////        panel.activarExclusividad();
////
////        try {
////            panel.hacerPregunta(respuestaJugador2);
////        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
////            assertEquals(0, panel.pedirJugadorActual().pedirPuntos());
////            assertEquals(0, panel.pedirJugadorSiguiente().pedirPuntos());
////        }
////    }
////
////    @Test
////    public void test27PreguntaMCClasicaElSegundoJugadorActivaExclusividadContestaMalYSeLeDuplicaElPuntajeAlPrimerJugador() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////        respuestaCorrecta.add("c");
////        respuestaCorrecta.add("b");
////
////        Set<String> respuestaJugador1 = new HashSet<>();
////        respuestaJugador1.add("b");
////        respuestaJugador1.add("a");
////        respuestaJugador1.add("c");
////
////        Set<String> respuestaJugador2 = new HashSet<>();
////        respuestaJugador2.add("c");
////        respuestaJugador2.add("d");
////        respuestaJugador2.add("b");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaMCClasica", "pregunta", respuestaCorrecta, todasLasRespuestas);
////
////        panel.crearJugadores("Stef", "Ivan");
////
////        panel.hacerPregunta(respuestaJugador1);
////
////        panel.activarExclusividad();
////        try {
////            panel.hacerPregunta(respuestaJugador2);
////        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
////            assertEquals(2, panel.pedirJugadorActual().pedirPuntos());
////            assertEquals(0, panel.pedirJugadorSiguiente().pedirPuntos());
////        }
////    }
////
////    @Test
////    public void test28PreguntaMCClasicaAmbosActivanExclusividadJugador1ContestaMalJugador2ContestaBienYSeLeCuadriplicanLosPuntosAJugador2() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////        respuestaCorrecta.add("c");
////        respuestaCorrecta.add("b");
////        respuestaCorrecta.add("e");
////
////        Set<String> respuestaJugador1 = new HashSet<>();
////        respuestaJugador1.add("b");
////        respuestaJugador1.add("a");
////        respuestaJugador1.add("d");
////
////        Set<String> respuestaJugador2 = new HashSet<>();
////        respuestaJugador2.add("c");
////        respuestaJugador2.add("a");
////        respuestaJugador2.add("b");
////        respuestaJugador2.add("e");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaMCClasica", "pregunta", respuestaCorrecta, todasLasRespuestas);
////
////        panel.crearJugadores("Stef", "Ivan");
////
////        panel.activarExclusividad();
////        panel.hacerPregunta(respuestaJugador1);
////
////        panel.activarExclusividad();
////        try {
////            panel.hacerPregunta(respuestaJugador2);
////        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
////            assertEquals(0, panel.pedirJugadorActual().pedirPuntos());
////            assertEquals(4, panel.pedirJugadorSiguiente().pedirPuntos());
////        }
////    }
////
////    @Test
////    public void test29PreguntaMCClasicaAmbosActivanExclusividadAmbosContestanBienYNoSeLeCuadriplicanLosPuntos() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////        respuestaCorrecta.add("c");
////
////        Set<String> respuestaJugador1 = new HashSet<>();
////        respuestaJugador1.add("a");
////        respuestaJugador1.add("c");
////
////        Set<String> respuestaJugador2 = new HashSet<>();
////        respuestaJugador2.add("a");
////        respuestaJugador2.add("c");
////
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaMCClasica", "pregunta", respuestaCorrecta, todasLasRespuestas);
////
////        panel.crearJugadores("Stef", "Ivan");
////
////        panel.activarExclusividad();
////        panel.hacerPregunta(respuestaJugador1);
////
////        panel.activarExclusividad();
////
////        try {
////            panel.hacerPregunta(respuestaJugador2);
////        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
////            assertEquals(1, panel.pedirJugadorActual().pedirPuntos());
////            assertEquals(1, panel.pedirJugadorSiguiente().pedirPuntos());
////        }
////    }
////
////    @Test
////    public void test30PreguntaMCConPuntajeParcialJugador1ActivaExclusividadContestaBienJugador2ContestaParcialmenteBienNoSeLeDuplicanLosPuntos() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////        respuestaCorrecta.add("c");
////        respuestaCorrecta.add("e");
////
////        Set<String> respuestaJugador1 = new HashSet<>();
////        respuestaJugador1.add("c");
////        respuestaJugador1.add("a");
////        respuestaJugador1.add("e");
////
////        Set<String> respuestaJugador2 = new HashSet<>();
////        respuestaJugador2.add("c");
////        respuestaJugador2.add("a");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaMCConPuntajeParcial", "pregunta", respuestaCorrecta, todasLasRespuestas);
////
////        panel.crearJugadores("Stef", "Ivan");
////
////        panel.activarExclusividad();
////        panel.hacerPregunta(respuestaJugador1);
////
////        try {
////            panel.hacerPregunta(respuestaJugador2);
////        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
////            assertEquals(3, panel.pedirJugadorActual().pedirPuntos());
////            assertEquals(2, panel.pedirJugadorSiguiente().pedirPuntos());
////        }
////    }
////
////    @Test
////    public void test31PreguntaMCConPuntajeParcialElJugador1ActivaExclusividadContestaParcialmenteBienJugador2ContestaMalSeLeDuplicanLosPuntosAlPrimerJugador() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////        respuestaCorrecta.add("c");
////        respuestaCorrecta.add("e");
////        respuestaCorrecta.add("b");
////
////        Set<String> respuestaJugador1 = new HashSet<>();
////        respuestaJugador1.add("c");
////        respuestaJugador1.add("a");
////
////        Set<String> respuestaJugador2 = new HashSet<>();
////        respuestaJugador2.add("c");
////        respuestaJugador2.add("a");
////        respuestaJugador2.add("d");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaMCConPuntajeParcial", "pregunta", respuestaCorrecta, todasLasRespuestas);
////
////        panel.crearJugadores("Stef", "Ivan");
////
////        panel.activarExclusividad();
////        panel.hacerPregunta(respuestaJugador1);
////
////        try {
////            panel.hacerPregunta(respuestaJugador2);
////        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
////            assertEquals(4, panel.pedirJugadorActual().pedirPuntos());
////            assertEquals(0, panel.pedirJugadorSiguiente().pedirPuntos());
////        }
////    }
////
////    @Test
////    public void test32PreguntaMCConPuntajeParcialAmbosActivanExclusividadElJugador2ContestaBienEl1MalYSeLeCuadriplicanLosPuntosAlJugador2() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////        respuestaCorrecta.add("c");
////        respuestaCorrecta.add("d");
////        respuestaCorrecta.add("e");
////
////        Set<String> respuestaJugador1 = new HashSet<>();
////        respuestaJugador1.add("c");
////        respuestaJugador1.add("b");
////
////        Set<String> respuestaJugador2 = new HashSet<>();
////        respuestaJugador2.add("c");
////        respuestaJugador2.add("d");
////        respuestaJugador2.add("a");
////        respuestaJugador2.add("e");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaMCConPuntajeParcial", "pregunta", respuestaCorrecta, todasLasRespuestas);
////
////        panel.crearJugadores("Stef", "Ivan");
////
////        panel.activarExclusividad();
////        panel.hacerPregunta(respuestaJugador1);
////
////        panel.activarExclusividad();
////
////        try {
////            panel.hacerPregunta(respuestaJugador2);
////        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
////            assertEquals(0, panel.pedirJugadorActual().pedirPuntos());
////            assertEquals(16, panel.pedirJugadorSiguiente().pedirPuntos());
////        }
////    }
////
////    @Test
////    public void test33PreguntaMCConPuntajeParcialAmbosActivanExclusividadYContestanBienNoSeMultiplicanLosPuntos() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////        respuestaCorrecta.add("c");
////        respuestaCorrecta.add("d");
////        respuestaCorrecta.add("e");
////
////        Set<String> respuestaJugador1 = new HashSet<>();
////        respuestaJugador1.add("c");
////        respuestaJugador1.add("a");
////        respuestaJugador1.add("e");
////        respuestaJugador1.add("d");
////
////        Set<String> respuestaJugador2 = new HashSet<>();
////        respuestaJugador2.add("c");
////        respuestaJugador2.add("d");
////        respuestaJugador2.add("a");
////        respuestaJugador2.add("e");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaMCConPuntajeParcial", "pregunta", respuestaCorrecta, todasLasRespuestas);
////
////        panel.crearJugadores("Stef", "Ivan");
////
////        panel.activarExclusividad();
////        panel.hacerPregunta(respuestaJugador1);
////
////        panel.activarExclusividad();
////        try {
////            panel.hacerPregunta(respuestaJugador2);
////        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
////            assertEquals(4, panel.pedirJugadorActual().pedirPuntos());
////            assertEquals(4, panel.pedirJugadorSiguiente().pedirPuntos());
////        }
////    }
////
////    @Test
////    public void test34PreguntaOCAmbosActivanExclusividadYContestanBienNoSeMultiplicanLosPuntos() {
////        List<String> respuestaCorrecta = new LinkedList<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////        respuestaCorrecta.add("c");
////        respuestaCorrecta.add("d");
////        respuestaCorrecta.add("e");
////
////        List<String> respuestaJugador1 = new LinkedList<>();
////        respuestaJugador1.add("a");
////        respuestaJugador1.add("c");
////        respuestaJugador1.add("d");
////        respuestaJugador1.add("e");
////
////        List<String> respuestaJugador2 = new LinkedList<>();
////        respuestaJugador2.add("a");
////        respuestaJugador2.add("c");
////        respuestaJugador2.add("d");
////        respuestaJugador2.add("e");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaOC", "pregunta", respuestaCorrecta, todasLasRespuestas);
////
////        panel.crearJugadores("Stef", "Ivan");
////
////        panel.activarExclusividad();
////        panel.hacerPregunta(respuestaJugador1);
////
////        panel.activarExclusividad();
////        try {
////            panel.hacerPregunta(respuestaJugador2);
////        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
////            assertEquals(1, panel.pedirJugadorActual().pedirPuntos());
////            assertEquals(1, panel.pedirJugadorSiguiente().pedirPuntos());
////        }
////    }
////
////    @Test
////    public void test35PreguntaOCAmbosActivanExclusividadYContestanBienSoloAlJugador1SeMultiplicanLosPuntos() {
////        List<String> respuestaCorrecta = new LinkedList<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////        respuestaCorrecta.add("c");
////        respuestaCorrecta.add("d");
////        respuestaCorrecta.add("e");
////
////        List<String> respuestaJugador1 = new LinkedList<>();
////        respuestaJugador1.add("a");
////        respuestaJugador1.add("c");
////        respuestaJugador1.add("d");
////        respuestaJugador1.add("e");
////
////        List<String> respuestaJugador2 = new LinkedList<>();
////        respuestaJugador2.add("a");
////        respuestaJugador2.add("d");
////        respuestaJugador2.add("c");
////        respuestaJugador2.add("e");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaOC", "pregunta", respuestaCorrecta, todasLasRespuestas);
////
////        panel.crearJugadores("Stef", "Ivan");
////
////        panel.activarExclusividad();
////        panel.hacerPregunta(respuestaJugador1);
////
////        panel.activarExclusividad();
////        try {
////            panel.hacerPregunta(respuestaJugador2);
////        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
////            assertEquals(4, panel.pedirJugadorActual().pedirPuntos());
////            assertEquals(0, panel.pedirJugadorSiguiente().pedirPuntos());
////        }
////    }
////
////    @Test
////    public void test36PreguntaGCAmbosActivanExclusividadYContestaBienSoloELJugador1SeLeMultiplicanLosPuntos() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////        respuestaCorrecta.add("c");
////        respuestaCorrecta.add("d");
////        respuestaCorrecta.add("e");
////        respuestaCorrecta.add("grupo1");
////
////        Set<String> respuestaJugador1 = new HashSet<>();
////        respuestaJugador1.add("a");
////        respuestaJugador1.add("e");
////        respuestaJugador1.add("d");
////        respuestaJugador1.add("c");
////        respuestaJugador1.add("grupo1");
////
////        Set<String> respuestaJugador2 = new HashSet<>();
////        respuestaJugador2.add("a");
////        respuestaJugador2.add("d");
////        respuestaJugador2.add("grupo1");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaGC", "pregunta", respuestaCorrecta, todasLasRespuestas);
////
////        panel.crearJugadores("Stef", "Ivan");
////
////        panel.activarExclusividad();
////        panel.hacerPregunta(respuestaJugador1);
////
////        panel.activarExclusividad();
////        try {
////            panel.hacerPregunta(respuestaJugador2);
////        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
////            assertEquals(4, panel.pedirJugadorActual().pedirPuntos());
////            assertEquals(0, panel.pedirJugadorSiguiente().pedirPuntos());
////        }
////    }
////
////    @Test
////    public void test37PreguntaGCAmbosActivanExclusividadYContestanMalNoSeMultiplicanLosPuntos() {
////        Set<String> respuestaCorrecta = new HashSet<>();
////        Set<String> todasLasRespuestas = new HashSet<>();
////        respuestaCorrecta.add("a");
////        respuestaCorrecta.add("c");
////        respuestaCorrecta.add("d");
////        respuestaCorrecta.add("e");
////        respuestaCorrecta.add("grupo1");
////
////        Set<String> respuestaJugador1 = new HashSet<>();
////        respuestaJugador1.add("a");
////        respuestaJugador1.add("c");
////        respuestaJugador1.add("e");
////        respuestaJugador1.add("d");
////        respuestaJugador1.add("grupo2");
////
////        Set<String> respuestaJugador2 = new HashSet<>();
////        respuestaJugador2.add("a");
////        respuestaJugador2.add("d");
////        respuestaJugador2.add("grupo1");
////
////        Panel panel = new Panel();
////
////        panel.crearPregunta("preguntaGC", "pregunta", respuestaCorrecta, todasLasRespuestas);
////
////        panel.crearJugadores("Stef", "Ivan");
////
////        panel.activarExclusividad();
////        panel.hacerPregunta(respuestaJugador1);
////
////        panel.activarExclusividad();
////        try {
////            panel.hacerPregunta(respuestaJugador2);
////        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
////            assertEquals(0, panel.pedirJugadorActual().pedirPuntos());
////            assertEquals(0, panel.pedirJugadorSiguiente().pedirPuntos());
////        }
////    }
////
}

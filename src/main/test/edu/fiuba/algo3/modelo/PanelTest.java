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
        respuestaCorrecta[0] = "V";

        String[] todasLasRespuestas = new String[0];

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("", ""));

        Preguntas pregunta = new Preguntas("preguntaVoFClasica", "Era blanco el caballo blanco de San Martin?", todasLasRespuestas, respuestaCorrecta, grupos);

        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        LectorPreguntas mockedLector = mock(LectorPreguntas.class);

        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("V");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("F");

        Panel panel = new Panel(mockedLector);


        panel.crearJugadores("Stef", "Rulo");

        panel.hacerPregunta(respuestaJugador1);
        assertEquals(1, panel.pedirJugadorSiguiente().pedirPuntos());

        try {
            panel.hacerPregunta(respuestaJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(0, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void test02PreguntaMCClasicaJugador1ContestaBienSeLeAsignaUnPuntoJugador2ConstestaMalSeLeAsigna0Puntos() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
        String[] respuestasCorrectas = new String[2];
        respuestasCorrectas[0] = "A";
        respuestasCorrectas[1] = "B";

        String[] todasLasRespuestas = new String[5];
        todasLasRespuestas[0] = "A";
        todasLasRespuestas[0] = "j";
        todasLasRespuestas[0] = "7";
        todasLasRespuestas[0] = "B";
        todasLasRespuestas[0] = "-";


        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("", ""));

        Preguntas pregunta = new Preguntas("preguntaMCClasica", "Primeras 2 letras del abecesario?", todasLasRespuestas, respuestasCorrectas, grupos);

        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        LectorPreguntas mockedLector = mock(LectorPreguntas.class);

        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);

        Set<String> respuestasJugador1 = new HashSet<>();
        respuestasJugador1.add("A");
        respuestasJugador1.add("B");

        Set<String> respuestasJugador2 = new HashSet<>();
        respuestasJugador2.add("7");

        Panel panel = new Panel(mockedLector);


        panel.crearJugadores("Ivan", "Lu");

        panel.hacerPregunta(respuestasJugador1);
        assertEquals(1, panel.pedirJugadorSiguiente().pedirPuntos());

        try {
            panel.hacerPregunta(respuestasJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(0, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void test03PreguntaOCJugador1ContestaOrdenadoSeLeAsignaUnPuntoJugador2ContestaDesordenadoSeLeAsigna0Puntos() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
        String[] respuestaCorrecta = new String[4];

        respuestaCorrecta[0] = "j";
        respuestaCorrecta[1] = "b";
        respuestaCorrecta[2] = "h";
        respuestaCorrecta[3] = "d";

        String[] todasLasRespuestas = new String[4];
        todasLasRespuestas[0] = "j";
        todasLasRespuestas[1] = "b";
        todasLasRespuestas[2] = "h";
        todasLasRespuestas[3] = "d";

        List<String> respuestaJugador1 = new LinkedList<>();
        respuestaJugador1.add("j");
        respuestaJugador1.add("b");
        respuestaJugador1.add("h");
        respuestaJugador1.add("d");

        List<String> respuestaJugador2 = new LinkedList<>();
        respuestaJugador2.add("b");
        respuestaJugador2.add("j");
        respuestaJugador2.add("h");
        respuestaJugador2.add("d");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("UnGrupo", "OtroGrupo"));

        Preguntas pregunta = new Preguntas("preguntaOC", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
        Preguntas[] preguntas = new Preguntas[1];
        preguntas[0] = pregunta;

        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        LectorPreguntas mockedLector = mock(LectorPreguntas.class);

        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);
        Panel panel = new Panel(mockedLector);


        panel.crearJugadores("Stef", "Rulo");

        panel.hacerPregunta(respuestaJugador1);
        assertEquals(1, panel.pedirJugadorSiguiente().pedirPuntos());

        try {
            panel.hacerPregunta(respuestaJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(0, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void test04PreguntaMCConPuntajeParcialJugador1Contesta2BienDe3SeLeAsigna2PuntosJugador2Contesta2BienY1MalSeLeAsigna0Puntos() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
        String[] respuestaCorrecta = new String[3];
        respuestaCorrecta[0] = "a";
        respuestaCorrecta[1] = "b";
        respuestaCorrecta[2] = "c";

        String[] todasLasRespuestas = new String[4];
        todasLasRespuestas[0] = "a";
        todasLasRespuestas[1] = "b";
        todasLasRespuestas[2] = "c";
        todasLasRespuestas[3] = "h";

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("a");
        respuestaJugador1.add("c");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("a");
        respuestaJugador2.add("c");
        respuestaJugador2.add("h");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("UnGrupo", "OtroGrupo"));

        Preguntas pregunta = new Preguntas("preguntaMCConPuntajeParcial", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
        Preguntas[] preguntas = new Preguntas[1];
        preguntas[0] = pregunta;

        LectorPreguntas mockedLector = mock(LectorPreguntas.class);
        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);
        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Stef", "Rulo");

        panel.hacerPregunta(respuestaJugador1);
        assertEquals(2, panel.pedirJugadorSiguiente().pedirPuntos());

        try {
            panel.hacerPregunta(respuestaJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(0, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void test05PreguntaMCConPuntajeParcialJugador1Contesta3BienDe3SeLeAsigna3PuntosJugador2Contesta2MalSeLeAsigna0Puntos() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
        String[] respuestaCorrecta = new String[3];
        respuestaCorrecta[0] = "h";
        respuestaCorrecta[1] = "u";
        respuestaCorrecta[2] = "p";

        String[] todasLasRespuestas = new String[5];
        todasLasRespuestas[0] = "h";
        todasLasRespuestas[1] = "u";
        todasLasRespuestas[2] = "p";
        todasLasRespuestas[3] = "a";
        todasLasRespuestas[4] = "c";

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("p");
        respuestaJugador1.add("u");
        respuestaJugador1.add("h");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("a");
        respuestaJugador2.add("c");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("UnGrupo", "OtroGrupo"));

        Preguntas pregunta = new Preguntas("preguntaMCConPuntajeParcial", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
        Preguntas[] preguntas = new Preguntas[1];
        preguntas[0] = pregunta;

        LectorPreguntas mockedLector = mock(LectorPreguntas.class);
        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);
        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Stef", "Rulo");

        panel.hacerPregunta(respuestaJugador1);
        assertEquals(3, panel.pedirJugadorSiguiente().pedirPuntos());

        try {
            panel.hacerPregunta(respuestaJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(0, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void test06PreguntaMCConPenalidadJugador1ContestaBien2Y1MalSeLeAsigna1PuntoJugador2Contesta1MalYSeLeAsignaMenos1Puntos() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
        String[] respuestaCorrecta = new String[3];
        respuestaCorrecta[0] = "a";
        respuestaCorrecta[1] = "b";
        respuestaCorrecta[2] = "c";

        String[] todasLasRespuestas = new String[4];
        todasLasRespuestas[0] = "a";
        todasLasRespuestas[1] = "b";
        todasLasRespuestas[2] = "c";
        todasLasRespuestas[3] = "z";

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("b");
        respuestaJugador1.add("c");
        respuestaJugador1.add("z");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("z");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("UnGrupo", "OtroGrupo"));

        Preguntas pregunta = new Preguntas("preguntaMCConPenalidad", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
        Preguntas[] preguntas = new Preguntas[1];
        preguntas[0] = pregunta;

        LectorPreguntas mockedLector = mock(LectorPreguntas.class);
        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);
        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Stef", "Rulo");

        panel.hacerPregunta(respuestaJugador1);
        assertEquals(1, panel.pedirJugadorSiguiente().pedirPuntos());

        try {
            panel.hacerPregunta(respuestaJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(-1, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void test07PreguntaMCConPenalidadJugador1ContestaBien3SeLeAsigna3PuntosJugador2Contesta3Bien1MalSeLeAsigna2Puntos() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
        String[] respuestaCorrecta = new String[3];
        respuestaCorrecta[0] = "a";
        respuestaCorrecta[1] = "b";
        respuestaCorrecta[2] = "c";

        String[] todasLasRespuestas = new String[4];
        todasLasRespuestas[0] = "a";
        todasLasRespuestas[1] = "b";
        todasLasRespuestas[2] = "c";
        todasLasRespuestas[3] = "z";

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("b");
        respuestaJugador1.add("c");
        respuestaJugador1.add("a");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("z");
        respuestaJugador2.add("b");
        respuestaJugador2.add("c");
        respuestaJugador2.add("a");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("UnGrupo", "OtroGrupo"));

        Preguntas pregunta = new Preguntas("preguntaMCConPenalidad", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
        Preguntas[] preguntas = new Preguntas[1];
        preguntas[0] = pregunta;

        LectorPreguntas mockedLector = mock(LectorPreguntas.class);
        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);
        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Stef", "Rulo");

        panel.hacerPregunta(respuestaJugador1);
        assertEquals(3, panel.pedirJugadorSiguiente().pedirPuntos());


        try {
            panel.hacerPregunta(respuestaJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(2, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void gtest08PreguntaVoFConPenalidadJugador1ContestaBienSeLeAsigna1PuntoJugador2ContestaMalSeLeAsignaMenos1Punto() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();

        String[] respuestaCorrecta = new String[1];
        respuestaCorrecta[0] = "a";

        String[] todasLasRespuestas = new String[1];
        todasLasRespuestas[0] = "a";

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("a");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("b");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("UnGrupo", "OtroGrupo"));

        Preguntas pregunta = new Preguntas("preguntaVoFConPenalidad", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
        Preguntas[] preguntas = new Preguntas[1];
        preguntas[0] = pregunta;

        LectorPreguntas mockedLector = mock(LectorPreguntas.class);
        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);
        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Stef", "Rulo");

        panel.hacerPregunta(respuestaJugador1);
        assertEquals(1, panel.pedirJugadorSiguiente().pedirPuntos());

        try {
            panel.hacerPregunta(respuestaJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(-1, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void test09PreguntaVoFConPenalidadJugador1UsaMultiplicadorX2ContestaMalSeLeAsignaMenos2PuntosJugador2UsaMultiplicadorX2ContestaBienSeLeAsigna2Puntos() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();

        String[] respuestaCorrecta = new String[1];
        respuestaCorrecta[0] = "a";

        String[] todasLasRespuestas = new String[1];
        todasLasRespuestas[0] = "a";

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("b");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("a");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("UnGrupo", "OtroGrupo"));

        Preguntas pregunta = new Preguntas("preguntaVoFConPenalidad", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
        Preguntas[] preguntas = new Preguntas[1];
        preguntas[0] = pregunta;

        LectorPreguntas mockedLector = mock(LectorPreguntas.class);
        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);
        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Stef", "Rulo");

        panel.activarDuplicador();
        panel.hacerPregunta(respuestaJugador1);
        assertEquals(-2, panel.pedirJugadorSiguiente().pedirPuntos());

        panel.activarDuplicador();

        try {
            panel.hacerPregunta(respuestaJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(2, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void test10PreguntaVoFConPenalidadJugador1UsaMultiplicadorX3ContestaMalSeLeAsignaMenos3PuntosJugador2NoUsaMultiplicadorContestaBienSeLeAsigna1Punto() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();

        String[] respuestaCorrecta = new String[1];
        respuestaCorrecta[0] = "a";

        String[] todasLasRespuestas = new String[1];
        todasLasRespuestas[0] = "a";

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("b");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("a");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("UnGrupo", "OtroGrupo"));

        Preguntas pregunta = new Preguntas("preguntaVoFConPenalidad", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
        Preguntas[] preguntas = new Preguntas[1];
        preguntas[0] = pregunta;

        LectorPreguntas mockedLector = mock(LectorPreguntas.class);
        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);
        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Stef", "Rulo");

        panel.activarTriplicador();
        panel.hacerPregunta(respuestaJugador1);

        assertEquals(-3, panel.pedirJugadorSiguiente().pedirPuntos());

        try {
            panel.hacerPregunta(respuestaJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(1, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void test11PreguntaMCConPenalidadJugador1UsaMultiplicadorX2Contesta2MalSeLeAsignaMenos4PuntosJugador2UsaMultiplicadorX2Contesta3BienSeLeAsigna6Puntos() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();

        String[] respuestaCorrecta = new String[3];
        respuestaCorrecta[0] = "a";
        respuestaCorrecta[1] = "c";
        respuestaCorrecta[2] = "d";

        String[] todasLasRespuestas = new String[5];
        todasLasRespuestas[0] = "a";
        todasLasRespuestas[1] = "c";
        todasLasRespuestas[2] = "d";
        todasLasRespuestas[3] = "b";
        todasLasRespuestas[4] = "e";


        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("b");
        respuestaJugador1.add("e");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("a");
        respuestaJugador2.add("d");
        respuestaJugador2.add("c");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("UnGrupo", "OtroGrupo"));

        Preguntas pregunta = new Preguntas("preguntaMCConPenalidad", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
        Preguntas[] preguntas = new Preguntas[1];
        preguntas[0] = pregunta;

        LectorPreguntas mockedLector = mock(LectorPreguntas.class);
        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);
        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Stef", "Rulo");

        panel.activarDuplicador();
        panel.hacerPregunta(respuestaJugador1);
        assertEquals(-4, panel.pedirJugadorSiguiente().pedirPuntos());

        panel.activarDuplicador();
        try {
            panel.hacerPregunta(respuestaJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(6, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void test12PreguntaMCConPenalidadJugador1UsaMultiplicadorX3Contesta1Bien2MalSeLeAsignaMenos3PuntosJugador2UsaMultiplicadorX3Contesta2BienSeLeAsigna6Puntos() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();

        String[] respuestaCorrecta = new String[3];
        respuestaCorrecta[0] = "d";
        respuestaCorrecta[1] = "c";
        respuestaCorrecta[2] = "e";

        String[] todasLasRespuestas = new String[5];
        todasLasRespuestas[0] = "d";
        todasLasRespuestas[1] = "c";
        todasLasRespuestas[2] = "e";
        todasLasRespuestas[3] = "b";
        todasLasRespuestas[4] = "e";

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("b");
        respuestaJugador1.add("e");
        respuestaJugador1.add("z");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("e");
        respuestaJugador2.add("d");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("UnGrupo", "OtroGrupo"));

        Preguntas pregunta = new Preguntas("preguntaMCConPenalidad", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
        Preguntas[] preguntas = new Preguntas[1];
        preguntas[0] = pregunta;

        LectorPreguntas mockedLector = mock(LectorPreguntas.class);
        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);
        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Stef", "Rulo");

        panel.activarTriplicador();
        panel.hacerPregunta(respuestaJugador1);
        assertEquals(-3, panel.pedirJugadorSiguiente().pedirPuntos());


        panel.activarTriplicador();
        try {
            panel.hacerPregunta(respuestaJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(6, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void test13PidoUsarDosVecesElDuplicadorYSeLanzaExcepcion() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();

        String[] respuestaCorrecta = new String[1];
        respuestaCorrecta[0] = "V";


        String[] todasLasRespuestas = new String[2];
        todasLasRespuestas[0] = "V";
        todasLasRespuestas[1] = "F";

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("UnGrupo", "OtroGrupo"));

        Preguntas pregunta = new Preguntas("preguntaVoFConPenalidad", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
        Preguntas[] preguntas = new Preguntas[1];
        preguntas[0] = pregunta;

        LectorPreguntas mockedLector = mock(LectorPreguntas.class);
        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);
        Panel panel = new Panel(mockedLector);


        panel.crearJugadores("Stef", "Rulo");
        panel.activarDuplicador();
        assertThrows(ExcepcionYaUsasteTuDuplicadorSalame.class, panel::activarDuplicador);
    }

    @Test
    public void test14PidoUsarDosVecesElTriplicadorYSeLanzaExcepcion() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();

        String[] respuestaCorrecta = new String[1];
        respuestaCorrecta[0] = "V";;

        String[] todasLasRespuestas = new String[2];
        todasLasRespuestas[0] = "V";
        todasLasRespuestas[1] = "F";

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("UnGrupo", "OtroGrupo"));

        Preguntas pregunta = new Preguntas("preguntaVoFConPenalidad", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
        Preguntas[] preguntas = new Preguntas[1];
        preguntas[0] = pregunta;

        LectorPreguntas mockedLector = mock(LectorPreguntas.class);
        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);
        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Stef", "Rulo");
        panel.activarTriplicador();
        assertThrows(ExcepcionYaUsasteTuTriplicadorSalame.class, panel::activarTriplicador);
    }

    @Test
    public void test15PreguntaMCClasicaPidoUsarDuplicadorYLanzaExcepcion() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();

        String[] respuestaCorrecta = new String[4];
        respuestaCorrecta[0] = "a";
        respuestaCorrecta[1] = "c";
        respuestaCorrecta[2] = "d";
        respuestaCorrecta[3] = "e";

        String[] todasLasRespuestas = new String[4];
        todasLasRespuestas[0] = "a";
        todasLasRespuestas[1] = "c";
        todasLasRespuestas[2] = "d";
        todasLasRespuestas[3] = "e";

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("UnGrupo", "OtroGrupo"));

        Preguntas pregunta = new Preguntas("preguntaMCClasica", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
        Preguntas[] preguntas = new Preguntas[1];
        preguntas[0] = pregunta;

        LectorPreguntas mockedLector = mock(LectorPreguntas.class);
        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);
        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Stef", "Rulo");

        assertThrows(ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador.class, panel::activarDuplicador);
    }

    @Test
    public void test16PreguntaMCConPuntajeParcialPidoUsarTriplicadorYLanzaExcepcion() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();

        String[] respuestaCorrecta = new String[4];
        respuestaCorrecta[0] = "a";
        respuestaCorrecta[1] = "c";
        respuestaCorrecta[2] = "d";
        respuestaCorrecta[3] = "e";

        String[] todasLasRespuestas = new String[4];
        todasLasRespuestas[0] = "a";
        todasLasRespuestas[1] = "c";
        todasLasRespuestas[2] = "d";
        todasLasRespuestas[3] = "e";

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("UnGrupo", "OtroGrupo"));

        Preguntas pregunta = new Preguntas("preguntaMCConPuntajeParcial", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
        Preguntas[] preguntas = new Preguntas[1];
        preguntas[0] = pregunta;

        LectorPreguntas mockedLector = mock(LectorPreguntas.class);
        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);
        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Stef", "Rulo");

        assertThrows(ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador.class, panel::activarTriplicador);
    }

    @Test
    public void test17PreguntaVoFConPenalidadNoSePuedeUsarExclusividad() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();

        String[] respuestaCorrecta = new String[1];
        respuestaCorrecta[0] = "V";

        String[] todasLasRespuestas = new String[2];
        todasLasRespuestas[0] = "V";
        todasLasRespuestas[1] = "F";

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("UnGrupo", "OtroGrupo"));

        Preguntas pregunta = new Preguntas("preguntaVoFConPenalidad", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
        Preguntas[] preguntas = new Preguntas[1];
        preguntas[0] = pregunta;

        LectorPreguntas mockedLector = mock(LectorPreguntas.class);
        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);
        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Stef", "Rulo");

        assertThrows(ExcepcionSoloPreguntasClasicasYPuntajeParcialPuedeUsarExclusividad.class, panel::activarExclusividad);
    }

    @Test
    public void test18PreguntaMCConPenalidadNoSePuedeUsarExclusividad() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();

        String[] respuestaCorrecta = new String[4];
        respuestaCorrecta[0] = "a";
        respuestaCorrecta[0] = "c";

        String[] todasLasRespuestas = new String[4];
        todasLasRespuestas[0] = "a";
        todasLasRespuestas[1] = "c";
        todasLasRespuestas[2] = "d";

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("UnGrupo", "OtroGrupo"));

        Preguntas pregunta = new Preguntas("preguntaMCConPenalidad", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
        Preguntas[] preguntas = new Preguntas[1];
        preguntas[0] = pregunta;

        LectorPreguntas mockedLector = mock(LectorPreguntas.class);
        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);
        Panel panel = new Panel(mockedLector);


        panel.crearJugadores("Stef", "Rulo");

        assertThrows(ExcepcionSoloPreguntasClasicasYPuntajeParcialPuedeUsarExclusividad.class, panel::activarExclusividad);
    }

    @Test
    public void test19PreguntaVoFClasicaJugador1UsaExlusividadContestaBienJugador2ContestaMalSeLeAsignaElDobleDePuntosAJugador1() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();

        String[] respuestaCorrecta = new String[1];
        respuestaCorrecta[0] = "V";

        String[] todasLasRespuestas = new String[2];
        todasLasRespuestas[0] = "V";
        todasLasRespuestas[1] = "F";

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("V");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("F");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("UnGrupo", "OtroGrupo"));

        Preguntas pregunta = new Preguntas("preguntaVoFClasica", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
        Preguntas[] preguntas = new Preguntas[1];
        preguntas[0] = pregunta;

        LectorPreguntas mockedLector = mock(LectorPreguntas.class);
        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);
        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Stef", "Ivan");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador1);

        try {
            panel.hacerPregunta(respuestaJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(2, panel.pedirJugadorActual().pedirPuntos());
            assertEquals(0, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void test20PreguntaVoFClasicaAmbosJugadoresUsanExlusividadElPrimeroContestaMalElSegundoBienYSeLeAsignaElCuadrupleDePutntosAlSegundo() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();

        String[] respuestaCorrecta = new String[1];
        respuestaCorrecta[0] = "V";

        String[] todasLasRespuestas = new String[2];
        todasLasRespuestas[0] = "V";
        todasLasRespuestas[1] = "F";

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("F");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("V");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("UnGrupo", "OtroGrupo"));

        Preguntas pregunta = new Preguntas("preguntaVoFClasica", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
        Preguntas[] preguntas = new Preguntas[1];
        preguntas[0] = pregunta;

        LectorPreguntas mockedLector = mock(LectorPreguntas.class);
        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);
        Panel panel = new Panel(mockedLector);


        panel.crearJugadores("Stef", "Ivan");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador1);

        panel.activarExclusividad();

        try {
            panel.hacerPregunta(respuestaJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(0, panel.pedirJugadorActual().pedirPuntos());
            assertEquals(4, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void test21PreguntaVoFClasicaAmbosJugadoresActivanExlusividadAmbosContestanBienYNoSeMultiplicanLosPuntajes() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();

        String[] respuestaCorrecta = new String[1];
        respuestaCorrecta[0] = "V";

        String[] todasLasRespuestas = new String[2];
        todasLasRespuestas[0] = "V";
        todasLasRespuestas[1] = "F";

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("V");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("V");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("UnGrupo", "OtroGrupo"));

        Preguntas pregunta = new Preguntas("preguntaVoFClasica", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
        Preguntas[] preguntas = new Preguntas[1];
        preguntas[0] = pregunta;

        LectorPreguntas mockedLector = mock(LectorPreguntas.class);
        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);
        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Stef", "Ivan");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador1);

        panel.activarExclusividad();

        try {
            panel.hacerPregunta(respuestaJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(1, panel.pedirJugadorSiguiente().pedirPuntos());
            assertEquals(1, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void test22PreguntaVoFClasicaAmbosJugadoresActivanExlusividadAmbosContestanMalYLosPuntosSon0() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();

        String[] respuestaCorrecta = new String[1];
        respuestaCorrecta[0] = "V";;

        String[] todasLasRespuestas = new String[2];
        todasLasRespuestas[0] = "V";
        todasLasRespuestas[1] = "F";

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("F");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("F");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("UnGrupo", "OtroGrupo"));

        Preguntas pregunta = new Preguntas("preguntaVoFClasica", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
        Preguntas[] preguntas = new Preguntas[1];
        preguntas[0] = pregunta;

        LectorPreguntas mockedLector = mock(LectorPreguntas.class);
        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);
        Panel panel = new Panel(mockedLector);


        panel.crearJugadores("Stef", "Ivan");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador1);

        panel.activarExclusividad();

        try {
            panel.hacerPregunta(respuestaJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(0, panel.pedirJugadorSiguiente().pedirPuntos());
            assertEquals(0, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void test23PreguntaMCClasicaJugador1ActivaExclusividadSoloElContestaBienYSeDuplicaSuPuntaje() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();

        String[] respuestaCorrecta = new String[3];
        respuestaCorrecta[0] = "a";
        respuestaCorrecta[1] = "c";
        respuestaCorrecta[2] = "d";

        String[] todasLasRespuestas = new String[4];
        todasLasRespuestas[0] = "a";
        todasLasRespuestas[1] = "b";
        todasLasRespuestas[2] = "c";
        todasLasRespuestas[3] = "d";

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("d");
        respuestaJugador1.add("a");
        respuestaJugador1.add("c");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("b");
        respuestaJugador2.add("a");
        respuestaJugador2.add("c");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("UnGrupo", "OtroGrupo"));

        Preguntas pregunta = new Preguntas("preguntaMCClasica", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
        Preguntas[] preguntas = new Preguntas[1];
        preguntas[0] = pregunta;

        LectorPreguntas mockedLector = mock(LectorPreguntas.class);
        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);
        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Stef", "Ivan");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador1);

        try {
            panel.hacerPregunta(respuestaJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(2, panel.pedirJugadorActual().pedirPuntos());
            assertEquals(0, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void test24PreguntaMCClasicaJugador1ActivaExclusividadSoloElSegundoJugadorContestaBienYSeLeDuplicaeElPuntajeAJugado2() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();

        String[] respuestaCorrecta = new String[3];
        respuestaCorrecta[0] = "a";
        respuestaCorrecta[1] = "c";
        respuestaCorrecta[2] = "b";

        String[] todasLasRespuestas = new String[4];
        todasLasRespuestas[0] = "a";
        todasLasRespuestas[1] = "b";
        todasLasRespuestas[2] = "c";
        todasLasRespuestas[3] = "d";

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("d");
        respuestaJugador1.add("a");
        respuestaJugador1.add("c");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("b");
        respuestaJugador2.add("a");
        respuestaJugador2.add("c");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("UnGrupo", "OtroGrupo"));

        Preguntas pregunta = new Preguntas("preguntaMCClasica", "pregunta", todasLasRespuestas, respuestaCorrecta, grupos );
        Preguntas[] preguntas = new Preguntas[1];
        preguntas[0] = pregunta;

        LectorPreguntas mockedLector = mock(LectorPreguntas.class);
        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);
        Panel panel = new Panel(mockedLector);


        panel.crearJugadores("Stef", "Ivan");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador1);
        try {
            panel.hacerPregunta(respuestaJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(0, panel.pedirJugadorActual().pedirPuntos());
            assertEquals(2, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }
    @Test
    public void test25PreguntaMCClasicaJugador2ActivaExclusividadAmbosContestanBienYNoSeLeDuplicaElPuntaje() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
        String[] respuestasCorrectas = new String[3];
        respuestasCorrectas[0] = "Argentina";
        respuestasCorrectas[1] = "Cuba";
        respuestasCorrectas[2] = "Mexico";

        String[] todasLasRespuestas = new String[4];
        todasLasRespuestas[0] = "Argentina";
        todasLasRespuestas[1] = "Cuba";
        todasLasRespuestas[2] = "Bariloche";
        todasLasRespuestas[3] = "Mexico";

        Set<String> respuestasJugador1 = new HashSet<>();
        respuestasJugador1.add("Argentina");
        respuestasJugador1.add("Cuba");
        respuestasJugador1.add("Mexico");

        Set<String> respuestasJugador2 = new HashSet<>();
        respuestasJugador2.add("Argentina");
        respuestasJugador2.add("Cuba");
        respuestasJugador2.add("Mexico");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("", ""));

        Preguntas pregunta = new Preguntas("preguntaMCClasica", "elija los paises", todasLasRespuestas, respuestasCorrectas, grupos);

        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        LectorPreguntas mockedLector = mock(LectorPreguntas.class);

        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);

        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Ivan", "Lu");

        panel.hacerPregunta(respuestasJugador1);

        panel.activarExclusividad();
        try {
            panel.hacerPregunta(respuestasJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(1, panel.pedirJugadorSiguiente().pedirPuntos());
            assertEquals(1, panel.pedirJugadorActual().pedirPuntos());
        }
    }

    @Test
    public void test26PreguntaMCClasicaJugador2ActivaExclusividadAmbosContestanMalYNoSeLeDuplicaElPuntaje() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
        String[] respuestasCorrectas = new String[3];
        respuestasCorrectas[0] = "Argentina";
        respuestasCorrectas[1] = "Cuba";
        respuestasCorrectas[2] = "Mexico";

        String[] todasLasRespuestas = new String[4];
        todasLasRespuestas[0] = "Argentina";
        todasLasRespuestas[1] = "Cuba";
        todasLasRespuestas[2] = "Bariloche";
        todasLasRespuestas[3] = "Mexico";

        Set<String> respuestasJugador1 = new HashSet<>();
        respuestasJugador1.add("Argentina");
        respuestasJugador1.add("Bariloche");
        respuestasJugador1.add("Mexico");

        Set<String> respuestasJugador2 = new HashSet<>();
        respuestasJugador2.add("Argentina");
        respuestasJugador2.add("Cuba");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("", ""));

        Preguntas pregunta = new Preguntas("preguntaMCClasica", "elija los paises", todasLasRespuestas, respuestasCorrectas, grupos);

        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        LectorPreguntas mockedLector = mock(LectorPreguntas.class);

        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);

        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Ivan", "Lu");

        panel.hacerPregunta(respuestasJugador1);

        panel.activarExclusividad();

        try {
            panel.hacerPregunta(respuestasJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(0, panel.pedirJugadorActual().pedirPuntos());
            assertEquals(0, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void test27PreguntaMCClasicaElSegundoJugadorActivaExclusividadContestaMalYSeLeDuplicaElPuntajeAlPrimerJugador() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
        String[] respuestasCorrectas = new String[3];
        respuestasCorrectas[0] = "Argentina";
        respuestasCorrectas[1] = "Cuba";
        respuestasCorrectas[2] = "Mexico";

        String[] todasLasRespuestas = new String[4];
        todasLasRespuestas[0] = "Argentina";
        todasLasRespuestas[1] = "Cuba";
        todasLasRespuestas[2] = "Bariloche";
        todasLasRespuestas[3] = "Mexico";

        Set<String> respuestasJugador1 = new HashSet<>();
        respuestasJugador1.add("Argentina");
        respuestasJugador1.add("Cuba");
        respuestasJugador1.add("Mexico");

        Set<String> respuestasJugador2 = new HashSet<>();
        respuestasJugador2.add("Argentina");
        respuestasJugador2.add("Cuba");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("", ""));

        Preguntas pregunta = new Preguntas("preguntaMCClasica", "elija los paises", todasLasRespuestas, respuestasCorrectas, grupos);

        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        LectorPreguntas mockedLector = mock(LectorPreguntas.class);

        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);

        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Ivan", "Lu");

        panel.hacerPregunta(respuestasJugador1);

        panel.activarExclusividad();
        try {
            panel.hacerPregunta(respuestasJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(2, panel.pedirJugadorActual().pedirPuntos());
            assertEquals(0, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void test28PreguntaMCClasicaAmbosActivanExclusividadJugador1ContestaMalJugador2ContestaBienYSeLeCuadriplicanLosPuntosAJugador2() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
        String[] respuestasCorrectas = new String[3];
        respuestasCorrectas[0] = "Argentina";
        respuestasCorrectas[1] = "Cuba";
        respuestasCorrectas[2] = "Mexico";

        String[] todasLasRespuestas = new String[4];
        todasLasRespuestas[0] = "Argentina";
        todasLasRespuestas[1] = "Cuba";
        todasLasRespuestas[2] = "Bariloche";
        todasLasRespuestas[3] = "Mexico";

        Set<String> respuestasJugador1 = new HashSet<>();
        respuestasJugador1.add("Bariloche");
        respuestasJugador1.add("Cuba");
        respuestasJugador1.add("Mexico");

        Set<String> respuestasJugador2 = new HashSet<>();
        respuestasJugador2.add("Argentina");
        respuestasJugador2.add("Cuba");
        respuestasJugador2.add("Mexico");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("", ""));

        Preguntas pregunta = new Preguntas("preguntaMCClasica", "elija los paises", todasLasRespuestas, respuestasCorrectas, grupos);

        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        LectorPreguntas mockedLector = mock(LectorPreguntas.class);

        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);

        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Ivan", "Lu");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestasJugador1);

        panel.activarExclusividad();
        try {
            panel.hacerPregunta(respuestasJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(0, panel.pedirJugadorActual().pedirPuntos());
            assertEquals(4, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void test29PreguntaMCClasicaAmbosActivanExclusividadAmbosContestanBienYNoSeLesCuadriplicanLosPuntos() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
        String[] respuestasCorrectas = new String[4];
        respuestasCorrectas[0] = "Argentina";
        respuestasCorrectas[1] = "Cuba";
        respuestasCorrectas[2] = "Mexico";
        respuestasCorrectas[3] = "Peru";

        String[] todasLasRespuestas = new String[5];
        todasLasRespuestas[0] = "Argentina";
        todasLasRespuestas[1] = "Cuba";
        todasLasRespuestas[2] = "Bariloche";
        todasLasRespuestas[3] = "Mexico";
        todasLasRespuestas[4] = "Peru";

        Set<String> respuestasJugador1 = new HashSet<>();
        respuestasJugador1.add("Cuba");
        respuestasJugador1.add("Mexico");
        respuestasJugador1.add("Argentina");
        respuestasJugador1.add("Peru");

        Set<String> respuestasJugador2 = new HashSet<>();
        respuestasJugador2.add("Argentina");
        respuestasJugador2.add("Cuba");
        respuestasJugador2.add("Mexico");
        respuestasJugador2.add("Peru");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("", ""));

        Preguntas pregunta = new Preguntas("preguntaMCClasica", "elija los paises", todasLasRespuestas, respuestasCorrectas, grupos);

        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        LectorPreguntas mockedLector = mock(LectorPreguntas.class);

        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);

        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Ivan", "Lu");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestasJugador1);

        panel.activarExclusividad();

        try {
            panel.hacerPregunta(respuestasJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(1, panel.pedirJugadorActual().pedirPuntos());
            assertEquals(1, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void test30PreguntaMCConPuntajeParcialJugador1ActivaExclusividadContestaBienJugador2ContestaParcialmenteBienNoSeLeDuplicanLosPuntos() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
        String[] respuestasCorrectas = new String[4];
        respuestasCorrectas[0] = "Argentina";
        respuestasCorrectas[1] = "Cuba";
        respuestasCorrectas[2] = "Mexico";
        respuestasCorrectas[3] = "Peru";

        String[] todasLasRespuestas = new String[5];
        todasLasRespuestas[0] = "Argentina";
        todasLasRespuestas[1] = "Cuba";
        todasLasRespuestas[2] = "Bariloche";
        todasLasRespuestas[3] = "Mexico";
        todasLasRespuestas[4] = "Peru";

        Set<String> respuestasJugador1 = new HashSet<>();
        respuestasJugador1.add("Cuba");
        respuestasJugador1.add("Mexico");
        respuestasJugador1.add("Argentina");
        respuestasJugador1.add("Peru");

        Set<String> respuestasJugador2 = new HashSet<>();
        respuestasJugador2.add("Argentina");
        respuestasJugador2.add("Cuba");
        respuestasJugador2.add("Mexico");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("", ""));

        Preguntas pregunta = new Preguntas("preguntaMCConPuntajeParcial", "elija los paises", todasLasRespuestas, respuestasCorrectas, grupos);

        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        LectorPreguntas mockedLector = mock(LectorPreguntas.class);

        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);

        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Ivan", "Lu");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestasJugador1);

        try {
            panel.hacerPregunta(respuestasJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(4, panel.pedirJugadorActual().pedirPuntos());
            assertEquals(3, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void test31PreguntaMCConPuntajeParcialElJugador1ActivaExclusividadContestaParcialmenteBienJugador2ContestaMalSeLeDuplicanLosPuntosAlPrimerJugador() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
        String[] respuestasCorrectas = new String[4];
        respuestasCorrectas[0] = "Argentina";
        respuestasCorrectas[1] = "Cuba";
        respuestasCorrectas[2] = "Mexico";
        respuestasCorrectas[3] = "Peru";

        String[] todasLasRespuestas = new String[5];
        todasLasRespuestas[0] = "Argentina";
        todasLasRespuestas[1] = "Cuba";
        todasLasRespuestas[2] = "Bariloche";
        todasLasRespuestas[3] = "Mexico";
        todasLasRespuestas[4] = "Peru";

        Set<String> respuestasJugador1 = new HashSet<>();
        respuestasJugador1.add("Cuba");
        respuestasJugador1.add("Mexico");
        respuestasJugador1.add("Argentina");

        Set<String> respuestasJugador2 = new HashSet<>();
        respuestasJugador2.add("Argentina");
        respuestasJugador2.add("Cuba");
        respuestasJugador2.add("Bariloche");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("", ""));

        Preguntas pregunta = new Preguntas("preguntaMCConPuntajeParcial", "elija los paises", todasLasRespuestas, respuestasCorrectas, grupos);

        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        LectorPreguntas mockedLector = mock(LectorPreguntas.class);

        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);

        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Ivan", "Lu");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestasJugador1);

        try {
            panel.hacerPregunta(respuestasJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(6, panel.pedirJugadorActual().pedirPuntos());
            assertEquals(0, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void test32PreguntaMCConPuntajeParcialAmbosActivanExclusividadElJugador2ContestaBienEl1MalYSeLeCuadriplicanLosPuntosAlJugador2() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
        String[] respuestasCorrectas = new String[2];
        respuestasCorrectas[0] = "Argentina";
        respuestasCorrectas[1] = "Cuba";

        String[] todasLasRespuestas = new String[3];
        todasLasRespuestas[0] = "Argentina";
        todasLasRespuestas[1] = "Cuba";
        todasLasRespuestas[2] = "Bariloche";

        Set<String> respuestasJugador1 = new HashSet<>();
        respuestasJugador1.add("Cuba");
        respuestasJugador1.add("Bariloche");
        respuestasJugador1.add("Argentina");

        Set<String> respuestasJugador2 = new HashSet<>();
        respuestasJugador2.add("Argentina");
        respuestasJugador2.add("Cuba");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("", ""));

        Preguntas pregunta = new Preguntas("preguntaMCConPuntajeParcial", "elija los paises", todasLasRespuestas, respuestasCorrectas, grupos);

        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        LectorPreguntas mockedLector = mock(LectorPreguntas.class);

        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);

        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Ivan", "Lu");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestasJugador1);

        panel.activarExclusividad();

        try {
            panel.hacerPregunta(respuestasJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(0, panel.pedirJugadorActual().pedirPuntos());
            assertEquals(8, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void test33PreguntaMCConPuntajeParcialAmbosActivanExclusividadYContestanBienNoSeMultiplicanLosPuntos() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
        String[] respuestasCorrectas = new String[3];
        respuestasCorrectas[0] = "Argentina";
        respuestasCorrectas[1] = "Cuba";
        respuestasCorrectas[2] = "Chile";

        String[] todasLasRespuestas = new String[5];
        todasLasRespuestas[0] = "Argentina";
        todasLasRespuestas[1] = "Cuba";
        todasLasRespuestas[2] = "Bariloche";
        todasLasRespuestas[3] = "Chile";
        todasLasRespuestas[4] = "Mendoza";

        Set<String> respuestasJugador1 = new HashSet<>();
        respuestasJugador1.add("Cuba");
        respuestasJugador1.add("Chile");
        respuestasJugador1.add("Argentina");

        Set<String> respuestasJugador2 = new HashSet<>();
        respuestasJugador2.add("Argentina");
        respuestasJugador2.add("Cuba");
        respuestasJugador2.add("Chile");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("", ""));

        Preguntas pregunta = new Preguntas("preguntaMCConPuntajeParcial", "elija los paises", todasLasRespuestas, respuestasCorrectas, grupos);

        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        LectorPreguntas mockedLector = mock(LectorPreguntas.class);

        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);

        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Ivan", "Lu");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestasJugador1);

        panel.activarExclusividad();
        try {
            panel.hacerPregunta(respuestasJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(3, panel.pedirJugadorActual().pedirPuntos());
            assertEquals(3, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void test34PreguntaOCAmbosActivanExclusividadYContestanBienNoSeMultiplicanLosPuntos() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
        String[] respuestasCorrectas = new String[5];
        respuestasCorrectas[0] = "1";
        respuestasCorrectas[1] = "5";
        respuestasCorrectas[2] = "7";
        respuestasCorrectas[3] = "8";
        respuestasCorrectas[4] = "20";

        String[] todasLasRespuestas = new String[5];
        todasLasRespuestas[0] = "5";
        todasLasRespuestas[1] = "8";
        todasLasRespuestas[2] = "20";
        todasLasRespuestas[3] = "1";
        todasLasRespuestas[4] = "7";

        List<String> respuestasJugador1 = new LinkedList<>();
        respuestasJugador1.add("1");
        respuestasJugador1.add("5");
        respuestasJugador1.add("7");
        respuestasJugador1.add("8");
        respuestasJugador1.add("20");

        List<String> respuestasJugador2 = new LinkedList<>();
        respuestasJugador2.add("1");
        respuestasJugador2.add("5");
        respuestasJugador2.add("7");
        respuestasJugador2.add("8");
        respuestasJugador2.add("20");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("", ""));

        Preguntas pregunta = new Preguntas("preguntaOC", "ordene ascendentemente", todasLasRespuestas, respuestasCorrectas, grupos);

        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        LectorPreguntas mockedLector = mock(LectorPreguntas.class);

        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);

        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Ivan", "Lu");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestasJugador1);

        panel.activarExclusividad();
        try {
            panel.hacerPregunta(respuestasJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(1, panel.pedirJugadorActual().pedirPuntos());
            assertEquals(1, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void test35PreguntaOCAmbosActivanExclusividadYContestaBienSoloAlJugador1SeMultiplicanLosPuntos() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
        String[] respuestasCorrectas = new String[5];
        respuestasCorrectas[0] = "1";
        respuestasCorrectas[1] = "5";
        respuestasCorrectas[2] = "7";
        respuestasCorrectas[3] = "8";
        respuestasCorrectas[4] = "20";

        String[] todasLasRespuestas = new String[5];
        todasLasRespuestas[0] = "5";
        todasLasRespuestas[1] = "8";
        todasLasRespuestas[2] = "20";
        todasLasRespuestas[3] = "1";
        todasLasRespuestas[4] = "7";

        List<String> respuestasJugador1 = new LinkedList<>();
        respuestasJugador1.add("1");
        respuestasJugador1.add("5");
        respuestasJugador1.add("7");
        respuestasJugador1.add("8");
        respuestasJugador1.add("20");

        List<String> respuestasJugador2 = new LinkedList<>();
        respuestasJugador2.add("1");
        respuestasJugador2.add("5");
        respuestasJugador2.add("20");
        respuestasJugador2.add("8");
        respuestasJugador2.add("7");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("", ""));

        Preguntas pregunta = new Preguntas("preguntaOC", "ordene ascendentemente", todasLasRespuestas, respuestasCorrectas, grupos);

        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        LectorPreguntas mockedLector = mock(LectorPreguntas.class);

        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);

        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Ivan", "Lu");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestasJugador1);

        panel.activarExclusividad();
        try {
            panel.hacerPregunta(respuestasJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(4, panel.pedirJugadorActual().pedirPuntos());
            assertEquals(0, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void test36PreguntaGCAmbosActivanExclusividadYContestaBienSoloELJugador1SeLeCuadriplicanLosPuntos() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
        String[] respuestasCorrectas = new String[3];
        respuestasCorrectas[0] = "gato";
        respuestasCorrectas[1] = "leon";
        respuestasCorrectas[2] = "lobo";

        String[] todasLasRespuestas = new String[5];
        todasLasRespuestas[0] = "gato";
        todasLasRespuestas[1] = "leon";
        todasLasRespuestas[2] = "caballo";
        todasLasRespuestas[3] = "lobo";
        todasLasRespuestas[4] = "elefante";

        Set<String> respuestasJugador1 = new HashSet<>();
        respuestasJugador1.add("leon");
        respuestasJugador1.add("gato");
        respuestasJugador1.add("lobo");
        respuestasJugador1.add("carnivoros");

        Set<String> respuestasJugador2 = new HashSet<>();
        respuestasJugador2.add("caballo");
        respuestasJugador2.add("lobo");
        respuestasJugador2.add("carnivoros");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("carnivoros", "herbivoros"));

        Preguntas pregunta = new Preguntas("preguntaGC", "ordene ascendentemente", todasLasRespuestas, respuestasCorrectas, grupos);

        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        LectorPreguntas mockedLector = mock(LectorPreguntas.class);

        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);

        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Ivan", "Lu");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestasJugador1);

        panel.activarExclusividad();
        try {
            panel.hacerPregunta(respuestasJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(4, panel.pedirJugadorActual().pedirPuntos());
            assertEquals(0, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }

    @Test
    public void test37PreguntaGCAmbosActivanExclusividadYContestanMalNoSeMultiplicanLosPuntos() {
        List<Pregunta> preguntaTest = new ArrayList<>();
        FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
        String[] respuestasCorrectas = new String[3];
        respuestasCorrectas[0] = "gato";
        respuestasCorrectas[1] = "leon";
        respuestasCorrectas[2] = "lobo";

        String[] todasLasRespuestas = new String[5];
        todasLasRespuestas[0] = "gato";
        todasLasRespuestas[1] = "leon";
        todasLasRespuestas[2] = "caballo";
        todasLasRespuestas[3] = "lobo";
        todasLasRespuestas[4] = "elefante";

        Set<String> respuestasJugador1 = new HashSet<>();
        respuestasJugador1.add("leon");
        respuestasJugador1.add("gato");
        respuestasJugador1.add("carnivoros");

        Set<String> respuestasJugador2 = new HashSet<>();
        respuestasJugador2.add("caballo");
        respuestasJugador2.add("lobo");
        respuestasJugador2.add("carnivoros");

        List<Grupo> grupos = new LinkedList<>();
        grupos.add(new Grupo("carnivoros", "herbivoros"));

        Preguntas pregunta = new Preguntas("preguntaGC", "ordene ascendentemente", todasLasRespuestas, respuestasCorrectas, grupos);

        preguntaTest.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));
        LectorPreguntas mockedLector = mock(LectorPreguntas.class);

        when(mockedLector.parsearPreguntas()).thenReturn(preguntaTest);

        Panel panel = new Panel(mockedLector);

        panel.crearJugadores("Ivan", "Lu");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestasJugador1);

        panel.activarExclusividad();
        try {
            panel.hacerPregunta(respuestasJugador2);
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            assertEquals(0, panel.pedirJugadorActual().pedirPuntos());
            assertEquals(0, panel.pedirJugadorSiguiente().pedirPuntos());
        }
    }
}

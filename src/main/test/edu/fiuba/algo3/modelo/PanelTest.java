package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PanelTest {

    @Test
    public void test01PreguntaVoFClasicaJugador1ContestaBienSeLeAsigna1PuntoJugador2ContestaMalSeLeAigna0Puntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("a");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("b");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFClasica", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Rulo");

        panel.hacerPregunta(respuestaJugador1);
        assertEquals(1, panel.pedirPuntos());

        panel.siguienteJugador();

        panel.hacerPregunta(respuestaJugador2);
        assertEquals(0, panel.pedirPuntos());
    }

    @Test
    public void test02PreguntaMCClasicaJugador1ContestaBienSeLeAsignaUnPuntoJugador2ConstestaMalSeLeAsigna0Puntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("d");
        respuestaJugador1.add("a");
        respuestaJugador1.add("b");
        respuestaJugador1.add("c");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("d");
        respuestaJugador2.add("a");
        respuestaJugador2.add("b");
        respuestaJugador2.add("c");
        respuestaJugador2.add("z");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCClasica", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Rulo");

        panel.hacerPregunta(respuestaJugador1);
        assertEquals(1, panel.pedirPuntos());

        panel.siguienteJugador();

        panel.hacerPregunta(respuestaJugador2);
        assertEquals(0, panel.pedirPuntos());
    }

    @Test
    public void test03PreguntaOCJugador1ContestaOrdenadoSeLeAsignaUnPuntoJugador2ContestaDesordenadoSeLeAsigna0Puntos() {
        List<String> respuestaCorrecta = new LinkedList<>();
        respuestaCorrecta.add("j");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("h");
        respuestaCorrecta.add("d");

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

        Panel panel = new Panel();

        panel.crearPregunta("preguntaOC", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Rulo");

        panel.hacerPregunta(respuestaJugador1);
        assertEquals(1, panel.pedirPuntos());

        panel.siguienteJugador();

        panel.hacerPregunta(respuestaJugador2);
        assertEquals(0, panel.pedirPuntos());
    }

    @Test
    public void test04PreguntaMCConPuntajeParcialJugador1Contesta2BienDe3SeLeAsigna2PuntosJugador2Contesta2BienY1MalSeLeAsigna0Puntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("a");
        respuestaJugador1.add("c");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("a");
        respuestaJugador2.add("c");
        respuestaJugador2.add("h");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPuntajeParcial", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Rulo");

        panel.hacerPregunta(respuestaJugador1);
        assertEquals(2, panel.pedirPuntos());

        panel.siguienteJugador();

        panel.hacerPregunta(respuestaJugador2);
        assertEquals(0, panel.pedirPuntos());
    }

    @Test
    public void test05PreguntaMCConPuntajeParcialJugador1Contesta3BienDe3SeLeAsigna3PuntosJugador2Contesta2MalSeLeAsigna0Puntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("h");
        respuestaCorrecta.add("u");
        respuestaCorrecta.add("p");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("p");
        respuestaJugador1.add("u");
        respuestaJugador1.add("h");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("a");
        respuestaJugador2.add("c");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPuntajeParcial", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Rulo");

        panel.hacerPregunta(respuestaJugador1);
        assertEquals(3, panel.pedirPuntos());

        panel.siguienteJugador();

        panel.hacerPregunta(respuestaJugador2);
        assertEquals(0, panel.pedirPuntos());
    }

    @Test
    public void test06PreguntaMCConPenalidadJugador1ContestaBien2Y1MalSeLeAsigna1PuntoJugador2Contesta1MalYSeLeAsignaMenos1Puntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("b");
        respuestaJugador1.add("c");
        respuestaJugador1.add("z");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("z");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPenalidad", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Rulo");

        panel.hacerPregunta(respuestaJugador1);
        assertEquals(1, panel.pedirPuntos());

        panel.siguienteJugador();

        panel.hacerPregunta(respuestaJugador2);
        assertEquals(-1, panel.pedirPuntos());
    }

    @Test
    public void test07PreguntaMCConPenalidadJugador1ContestaBien3SeLeAsigna3PuntosJugador2Contesta3Bien1MalSeLeAsigna2Puntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("b");
        respuestaJugador1.add("c");
        respuestaJugador1.add("a");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("z");
        respuestaJugador2.add("b");
        respuestaJugador2.add("c");
        respuestaJugador2.add("a");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPenalidad", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Rulo");

        panel.hacerPregunta(respuestaJugador1);
        assertEquals(3, panel.pedirPuntos());

        panel.siguienteJugador();

        panel.hacerPregunta(respuestaJugador2);
        assertEquals(2, panel.pedirPuntos());
    }

    @Test
    public void gtest08PreguntaVoFConPenalidadJugador1ContestaBienSeLeAsigna1PuntoJugador2ContestaMalSeLeAsignaMenos1Punto() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("a");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("b");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFConPenalidad", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Rulo");

        panel.hacerPregunta(respuestaJugador1);
        assertEquals(1, panel.pedirPuntos());

        panel.siguienteJugador();

        panel.hacerPregunta(respuestaJugador2);
        assertEquals(-1, panel.pedirPuntos());
    }

    @Test
    public void test09PreguntaVoFConPenalidadJugador1UsaMultiplicadorX2ContestaMalSeLeAsignaMenos2PuntosJugador2UsaMultiplicadorX2ContestaBienSeLeAsigna2Puntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("b");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("a");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFConPenalidad", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Rulo");

        panel.activarDuplicador();
        panel.hacerPregunta(respuestaJugador1);
        assertEquals(-2, panel.pedirPuntos());

        panel.siguienteJugador();

        panel.activarDuplicador();
        panel.hacerPregunta(respuestaJugador2);
        assertEquals(2, panel.pedirPuntos());
    }

    @Test
    public void test10PreguntaVoFConPenalidadJugador1UsaMultiplicadorX3ContestaMalSeLeAsignaMenos3PuntosJugador2NoUsaMultiplicadorContestaBienSeLeAsigna1Punto() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("b");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("a");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFConPenalidad", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Rulo");

        panel.activarTriplicador();
        panel.hacerPregunta(respuestaJugador1);
        assertEquals(-3, panel.pedirPuntos());

        panel.siguienteJugador();

        panel.hacerPregunta(respuestaJugador2);
        assertEquals(1, panel.pedirPuntos());
    }

    @Test
    public void test11PreguntaMCConPenalidadJugador1UsaMultiplicadorX2Contesta2MalSeLeAsignaMenos4PuntosJugador2UsaMultiplicadorX2Contesta3BienSeLeAsigna6Puntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("b");
        respuestaJugador1.add("e");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("a");
        respuestaJugador2.add("d");
        respuestaJugador2.add("c");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPenalidad", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Rulo");

        panel.activarDuplicador();
        panel.hacerPregunta(respuestaJugador1);
        assertEquals(-4, panel.pedirPuntos());

        panel.siguienteJugador();

        panel.activarDuplicador();
        panel.hacerPregunta(respuestaJugador2);
        assertEquals(6, panel.pedirPuntos());
    }

    @Test
    public void test12PreguntaMCConPenalidadJugador1UsaMultiplicadorX3Contesta1Bien2MalSeLeAsignaMenos3PuntosJugador2UsaMultiplicadorX3Contesta2BienSeLeAsigna6Puntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("d");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("e");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("b");
        respuestaJugador1.add("e");
        respuestaJugador1.add("z");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("e");
        respuestaJugador2.add("d");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPenalidad", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Rulo");

        panel.activarTriplicador();
        panel.hacerPregunta(respuestaJugador1);
        assertEquals(-3, panel.pedirPuntos());

        panel.siguienteJugador();

        panel.activarTriplicador();
        panel.hacerPregunta(respuestaJugador2);
        assertEquals(6, panel.pedirPuntos());
    }

    @Test
    public void test13PidoUsarDosVecesElDuplicadorYSeLanzaExcepcion() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");
        respuestaCorrecta.add("e");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFConPenalidad", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Rulo");
        panel.activarDuplicador();
        assertThrows(ExcepcionYaUsasteTuDuplicadorSalame.class, panel::activarDuplicador);
    }

    @Test
    public void test14PidoUsarDosVecesElTriplicadorYSeLanzaExcepcion() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");
        respuestaCorrecta.add("e");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFConPenalidad", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Rulo");
        panel.activarTriplicador();
        assertThrows(ExcepcionYaUsasteTuTriplicadorSalame.class, panel::activarTriplicador);
    }

    @Test
    public void test15PreguntaMCClasicaPidoUsarDuplicadorYLanzaExcepcion() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");
        respuestaCorrecta.add("e");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCClasica", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Rulo");

        assertThrows(ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador.class, panel::activarDuplicador);
    }

    @Test
    public void test16PreguntaMCConPuntajeParcialPidoUsarTriplicadorYLanzaExcepcion() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");
        respuestaCorrecta.add("e");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPuntajeParcial", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Rulo");

        assertThrows(ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador.class, panel::activarTriplicador);
    }

    @Test
    public void test17PreguntaVoFConPenalidadNoSePuedeUsarExclusividad() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFConPenalidad", "pregunta", respuestaCorrecta);

        panel.crearJugadores("Stef", "Rulo");

        assertThrows(ExcepcionSoloPreguntasClasicasYPuntajeParcialPuedeUsarExclusividad.class, panel::activarExclusividad);
    }

    @Test
    public void test18PreguntaMCConPenalidadNoSePuedeUsarExclusividad() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPenalidad", "pregunta", respuestaCorrecta);

        panel.crearJugadores("Stef", "Rulo");

        assertThrows(ExcepcionSoloPreguntasClasicasYPuntajeParcialPuedeUsarExclusividad.class, panel::activarExclusividad);
    }

    @Test
    public void test19PreguntaVoFClasicaJugador1UsaExlusividadContestaBienJugador2ContestaMalSeLeAsignaElDobleDePuntosAJugador1() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("a");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("b");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFClasica", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Ivan");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador1);
        panel.siguienteJugador();
        panel.hacerPregunta(respuestaJugador2);

        panel.calcularExclusividad();
        panel.siguienteJugador();

        assertEquals(2, panel.pedirPuntos());
        panel.siguienteJugador();
        assertEquals(0, panel.pedirPuntos());
    }

    @Test
    public void test20PreguntaVoFClasicaAmbosJugadoresUsanExlusividadElPrimeroContestaMalElSegundoBienYSeLeAsignaElCuadrupleDePutntosAlSegundo() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("b");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("a");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFClasica", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Ivan");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador1);
        panel.siguienteJugador();
        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador2);

        panel.calcularExclusividad();
        panel.siguienteJugador();

        assertEquals(0, panel.pedirPuntos());
        panel.siguienteJugador();
        assertEquals(4, panel.pedirPuntos());
    }

    @Test
    public void test21PreguntaVoFClasicaAmbosJugadoresActivanExlusividadAmbosContestanBienYNoSeMultiplicanLosPuntajes() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("a");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("a");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFClasica", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Ivan");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador1);
        panel.siguienteJugador();
        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador2);

        panel.calcularExclusividad();
        panel.siguienteJugador();

        assertEquals(1, panel.pedirPuntos());
        panel.siguienteJugador();
        assertEquals(1, panel.pedirPuntos());
    }

    @Test
    public void test22PreguntaVoFClasicaAmbosJugadoresActivanExlusividadAmbosContestanMalYLosPuntosSon0() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("b");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("b");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFClasica", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Ivan");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador1);
        panel.siguienteJugador();
        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador2);

        panel.calcularExclusividad();
        panel.siguienteJugador();

        assertEquals(0, panel.pedirPuntos());
        panel.siguienteJugador();
        assertEquals(0, panel.pedirPuntos());
    }

    @Test
    public void test23PreguntaMCClasicaJugador1ActivaExclusividadSoloElContestaBienYSeDuplicaSuPuntaje() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("d");
        respuestaJugador1.add("a");
        respuestaJugador1.add("c");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("b");
        respuestaJugador2.add("a");
        respuestaJugador2.add("c");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCClasica", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Ivan");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador1);
        panel.siguienteJugador();
        panel.hacerPregunta(respuestaJugador2);

        panel.calcularExclusividad();
        panel.siguienteJugador();

        assertEquals(2, panel.pedirPuntos());
        panel.siguienteJugador();
        assertEquals(0, panel.pedirPuntos());
    }

    @Test
    public void test24PreguntaMCClasicaJugador1ActivaExclusividadSoloElSegundoJugadorContestaBienYSeLeDuplicaeElPuntajeAJugado2() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("b");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("d");
        respuestaJugador1.add("a");
        respuestaJugador1.add("c");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("b");
        respuestaJugador2.add("a");
        respuestaJugador2.add("c");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCClasica", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Ivan");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador1);
        panel.siguienteJugador();
        panel.hacerPregunta(respuestaJugador2);

        panel.calcularExclusividad();
        panel.siguienteJugador();

        assertEquals(0, panel.pedirPuntos());
        panel.siguienteJugador();
        assertEquals(2, panel.pedirPuntos());
    }

    @Test
    public void test25PreguntaMCClasicaJugador2ActivaExclusividadAmbosContestanBienYNoSeLeDuplicaElPuntaje() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("b");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("b");
        respuestaJugador1.add("a");
        respuestaJugador1.add("c");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("c");
        respuestaJugador2.add("a");
        respuestaJugador2.add("b");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCClasica", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Ivan");

        panel.hacerPregunta(respuestaJugador1);
        panel.siguienteJugador();
        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador2);

        panel.calcularExclusividad();
        panel.siguienteJugador();

        assertEquals(1, panel.pedirPuntos());
        panel.siguienteJugador();
        assertEquals(1, panel.pedirPuntos());
    }

    @Test
    public void test26PreguntaMCClasicaJugador2ActivaExclusividadAmbosContestanMalYNOSeLeDuplicaElPuntaje() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("b");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("b");
        respuestaJugador1.add("a");
        respuestaJugador1.add("d");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("c");
        respuestaJugador2.add("d");
        respuestaJugador2.add("b");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCClasica", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Ivan");

        panel.hacerPregunta(respuestaJugador1);
        panel.siguienteJugador();
        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador2);

        panel.calcularExclusividad();
        panel.siguienteJugador();

        assertEquals(0, panel.pedirPuntos());
        panel.siguienteJugador();
        assertEquals(0, panel.pedirPuntos());
    }

    @Test
    public void test27PreguntaMCClasicaElSegundoJugadorActivaExclusividadContestaMalYSeLeDuplicaElPuntajeAlPrimerJugador() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("b");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("b");
        respuestaJugador1.add("a");
        respuestaJugador1.add("c");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("c");
        respuestaJugador2.add("d");
        respuestaJugador2.add("b");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCClasica", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Ivan");

        panel.hacerPregunta(respuestaJugador1);
        panel.siguienteJugador();
        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador2);

        panel.calcularExclusividad();
        panel.siguienteJugador();

        assertEquals(2, panel.pedirPuntos());
        panel.siguienteJugador();
        assertEquals(0, panel.pedirPuntos());
    }

    @Test
    public void test28PreguntaMCClasicaAmbosActivanExclusividadJugador1ContestaMalJugador2ContestaBienYSeLeCuadriplicanLosPuntosAJugador2() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("e");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("b");
        respuestaJugador1.add("a");
        respuestaJugador1.add("d");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("c");
        respuestaJugador2.add("a");
        respuestaJugador2.add("b");
        respuestaJugador2.add("e");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCClasica", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Ivan");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador1);
        panel.siguienteJugador();
        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador2);

        panel.calcularExclusividad();
        panel.siguienteJugador();

        assertEquals(0, panel.pedirPuntos());
        panel.siguienteJugador();
        assertEquals(4, panel.pedirPuntos());
    }

    @Test
    public void test29PreguntaMCClasicaAmbosActivanExclusividadAmbosContestanBienYNoSeLeCuadriplicanLosPuntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("e");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("b");
        respuestaJugador1.add("a");
        respuestaJugador1.add("c");
        respuestaJugador1.add("e");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("c");
        respuestaJugador2.add("a");
        respuestaJugador2.add("b");
        respuestaJugador2.add("e");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCClasica", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Ivan");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador1);
        panel.siguienteJugador();
        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador2);

        panel.calcularExclusividad();
        panel.siguienteJugador();

        assertEquals(1, panel.pedirPuntos());
        panel.siguienteJugador();
        assertEquals(1, panel.pedirPuntos());
    }

    @Test
    public void test30PreguntaMCConPuntajeParcialJugador1ActivaExclusividadContestaBienJugador2ContestaParcialmenteBienNoSeLeDuplicanLosPuntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("e");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("c");
        respuestaJugador1.add("a");
        respuestaJugador1.add("e");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("c");
        respuestaJugador2.add("a");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPuntajeParcial", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Ivan");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador1);
        panel.siguienteJugador();
        panel.hacerPregunta(respuestaJugador2);

        panel.calcularExclusividad();
        panel.siguienteJugador();

        assertEquals(3, panel.pedirPuntos());
        panel.siguienteJugador();
        assertEquals(2, panel.pedirPuntos());
    }

    @Test
    public void test31PreguntaMCConPuntajeParcialElJugador1ActivaExclusividadContestaParcialmenteBienJugador2ContestaMalSeLeDuplicanLosPuntosAlPrimerJugador() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("e");
        respuestaCorrecta.add("b");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("c");
        respuestaJugador1.add("a");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("c");
        respuestaJugador2.add("a");
        respuestaJugador2.add("d");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPuntajeParcial", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Ivan");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador1);
        panel.siguienteJugador();
        panel.hacerPregunta(respuestaJugador2);

        panel.calcularExclusividad();
        panel.siguienteJugador();

        assertEquals(4, panel.pedirPuntos());
        panel.siguienteJugador();
        assertEquals(0, panel.pedirPuntos());
    }

    @Test
    public void test32PreguntaMCConPuntajeParcialAmbosActivanExclusividadElJugador2ContestaBienEl1MalYSeLeCuadriplicanLosPuntosAlJugador2() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");
        respuestaCorrecta.add("e");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("c");
        respuestaJugador1.add("b");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("c");
        respuestaJugador2.add("d");
        respuestaJugador2.add("a");
        respuestaJugador2.add("e");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPuntajeParcial", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Ivan");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador1);
        panel.siguienteJugador();
        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador2);

        panel.calcularExclusividad();
        panel.siguienteJugador();

        assertEquals(0, panel.pedirPuntos());
        panel.siguienteJugador();
        assertEquals(16, panel.pedirPuntos());
    }

    @Test
    public void test33PreguntaMCConPuntajeParcialAmbosActivanExclusividadYContestanBienNoSeMultiplicanLosPuntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");
        respuestaCorrecta.add("e");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("c");
        respuestaJugador1.add("a");
        respuestaJugador1.add("e");
        respuestaJugador1.add("d");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("c");
        respuestaJugador2.add("d");
        respuestaJugador2.add("a");
        respuestaJugador2.add("e");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPuntajeParcial", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Ivan");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador1);
        panel.siguienteJugador();
        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador2);

        panel.calcularExclusividad();
        panel.siguienteJugador();

        assertEquals(4, panel.pedirPuntos());
        panel.siguienteJugador();
        assertEquals(4, panel.pedirPuntos());
    }

    @Test
    public void test34PreguntaOCAmbosActivanExclusividadYContestanBienNoSeMultiplicanLosPuntos() {
        List<String> respuestaCorrecta = new LinkedList<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");
        respuestaCorrecta.add("e");

        List<String> respuestaJugador1 = new LinkedList<>();
        respuestaJugador1.add("a");
        respuestaJugador1.add("c");
        respuestaJugador1.add("d");
        respuestaJugador1.add("e");

        List<String> respuestaJugador2 = new LinkedList<>();
        respuestaJugador2.add("a");
        respuestaJugador2.add("c");
        respuestaJugador2.add("d");
        respuestaJugador2.add("e");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaOC", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Ivan");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador1);
        panel.siguienteJugador();
        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador2);

        panel.calcularExclusividad();
        panel.siguienteJugador();

        assertEquals(1, panel.pedirPuntos());
        panel.siguienteJugador();
        assertEquals(1, panel.pedirPuntos());
    }

    @Test
    public void test35PreguntaOCAmbosActivanExclusividadYContestanBienSoloAlJugador1SeMultiplicanLosPuntos() {
        List<String> respuestaCorrecta = new LinkedList<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");
        respuestaCorrecta.add("e");

        List<String> respuestaJugador1 = new LinkedList<>();
        respuestaJugador1.add("a");
        respuestaJugador1.add("c");
        respuestaJugador1.add("d");
        respuestaJugador1.add("e");

        List<String> respuestaJugador2 = new LinkedList<>();
        respuestaJugador2.add("a");
        respuestaJugador2.add("d");
        respuestaJugador2.add("c");
        respuestaJugador2.add("e");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaOC", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Ivan");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador1);
        panel.siguienteJugador();
        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador2);

        panel.calcularExclusividad();
        panel.siguienteJugador();

        assertEquals(4, panel.pedirPuntos());
        panel.siguienteJugador();
        assertEquals(0, panel.pedirPuntos());
    }

    @Test
    public void test36PreguntaGCAmbosActivanExclusividadYContestaBienSoloELJugador1SeLeMultiplicanLosPuntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");
        respuestaCorrecta.add("e");
        respuestaCorrecta.add("grupo1");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("a");
        respuestaJugador1.add("e");
        respuestaJugador1.add("d");
        respuestaJugador1.add("c");
        respuestaJugador1.add("grupo1");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("a");
        respuestaJugador2.add("d");
        respuestaJugador2.add("grupo1");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaGC", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Ivan");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador1);
        panel.siguienteJugador();
        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador2);

        panel.calcularExclusividad();
        panel.siguienteJugador();

        assertEquals(4, panel.pedirPuntos());
        panel.siguienteJugador();
        assertEquals(0, panel.pedirPuntos());
    }

    @Test
    public void test37PreguntaGCAmbosActivanExclusividadYContestanMalNoSeMultiplicanLosPuntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");
        respuestaCorrecta.add("e");
        respuestaCorrecta.add("grupo1");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("a");
        respuestaJugador1.add("c");
        respuestaJugador1.add("e");
        respuestaJugador1.add("d");
        respuestaJugador1.add("grupo2");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("a");
        respuestaJugador2.add("d");
        respuestaJugador2.add("grupo1");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaGC", "pregunta", respuestaCorrecta);
        panel.crearJugadores("Stef", "Ivan");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador1);
        panel.siguienteJugador();
        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador2);

        panel.calcularExclusividad();
        panel.siguienteJugador();

        assertEquals(0, panel.pedirPuntos());
        panel.siguienteJugador();
        assertEquals(0, panel.pedirPuntos());
    }

    @Test
    public void test38PreguntaGCOtraVoFClasicaYUnaMCclasicaElJugadorUnoUsaExclusividadEnTodasSaltaExcepcion() {
        Set<String> respuestaCorrectaGC = new HashSet<>();
        respuestaCorrectaGC.add("a");
        respuestaCorrectaGC.add("c");
        respuestaCorrectaGC.add("d");
        respuestaCorrectaGC.add("grupo1");

        Set<String> respuestaJugador1GC = new HashSet<>();
        respuestaJugador1GC.add("a");
        respuestaJugador1GC.add("c");
        respuestaJugador1GC.add("d");
        respuestaJugador1GC.add("grupo1");

        Set<String> respuestaJugador2GC = new HashSet<>();
        respuestaJugador2GC.add("a");
        respuestaJugador2GC.add("d");
        respuestaJugador2GC.add("grupo2");

        Set<String> respuestaCorrectaVF = new HashSet<>();
        respuestaCorrectaVF.add("a");

        Set<String> respuestaJugador1VF = new HashSet<>();
        respuestaJugador1VF.add("a");

        Set<String> respuestaJugador2VF = new HashSet<>();
        respuestaJugador2VF.add("b");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaGC", "pregunta", respuestaCorrectaGC);
        panel.crearJugadores("Stef", "Ivan");

        panel.activarExclusividad();
        panel.hacerPregunta(respuestaJugador1GC);
        panel.siguienteJugador();
        panel.hacerPregunta(respuestaJugador2GC);

        panel.calcularExclusividad();
        panel.siguienteJugador();

        assertEquals(2, panel.pedirPuntos());
        panel.siguienteJugador();
        assertEquals(0, panel.pedirPuntos());
        panel.siguienteJugador();

        panel.crearPregunta("preguntaVoFClasica", "pregunta", respuestaCorrectaVF);
        panel.activarExclusividad();

        panel.hacerPregunta(respuestaJugador1VF);
        panel.siguienteJugador();
        panel.hacerPregunta(respuestaJugador2VF);

        panel.calcularExclusividad();
        panel.siguienteJugador();

        assertEquals(4, panel.pedirPuntos());
        panel.siguienteJugador();
        assertEquals(0, panel.pedirPuntos());
        panel.siguienteJugador();

        assertThrows(ExcepcionYaUsasteLasExclusividadesSalame.class, panel::activarExclusividad);
    }
}

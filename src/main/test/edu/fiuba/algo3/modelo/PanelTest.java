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
    public void test01CreoUnaPreguntaFoVClasicaYElJugadorLaContestaBienYSeLeAsignaUnPunto() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");

        Set<String> respuestaJugador = new HashSet<>();
        respuestaJugador.add("a");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFClasica", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef", respuestaJugador);

        assertEquals(1, panel.pedirPuntos("Stef"));
    }

    @Test
    public void test02CreoUnaPreguntaFoVClasicaYElJugadorLaContestaMalYSeLeAsignaCeroPuntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");

        Set<String> respuestaJugador = new HashSet<>();
        respuestaJugador.add("b");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCClasica", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef", respuestaJugador);

        assertEquals(0, panel.pedirPuntos("Stef"));
    }

    @Test
    public void test03CreoUnaPreguntaMCClasicaYElJugadorLaContestaCorrectamenteYSeLeAsignaUnPunto() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");

        Set<String> respuestaJugador = new HashSet<>();
        respuestaJugador.add("d");
        respuestaJugador.add("a");
        respuestaJugador.add("b");
        respuestaJugador.add("c");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFClasica", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef", respuestaJugador);

        assertEquals(1, panel.pedirPuntos("Stef"));
    }

    @Test
    public void test04CreoUnaPreguntaMCClasicaYElJugadorLaContestaMalYSeLeAsignaCeroPunto() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("e");

        Set<String> respuestaJugador = new HashSet<>();
        respuestaJugador.add("d");
        respuestaJugador.add("a");
        respuestaJugador.add("b");
        respuestaJugador.add("c");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCClasica", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef", respuestaJugador);

        assertEquals(0, panel.pedirPuntos("Stef"));
    }

    @Test
    public void test05CreoUnaPreguntaGCYElJugadorLaContestaMalYSeLeAsignaCeroPunto() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");

        Set<String> respuestaJugador = new HashSet<>();
        respuestaJugador.add("d");
        respuestaJugador.add("a");
        respuestaJugador.add("b");
        respuestaJugador.add("c");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaGC", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef", respuestaJugador);

        assertEquals(0, panel.pedirPuntos("Stef"));
    }

    @Test
    public void test06CreoUnaPreguntGCYElJugadorLaContestaCorrectamenteYSeLeAsignaUnPunto() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");

        Set<String> respuestaJugador = new HashSet<>();
        respuestaJugador.add("d");
        respuestaJugador.add("a");
        respuestaJugador.add("b");
        respuestaJugador.add("c");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaGC", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef", respuestaJugador);

        assertEquals(1, panel.pedirPuntos("Stef"));
    }

    @Test
    public void test07CreoUnaPreguntOCYElJugadorLaContestaCorrectamenteYSeLeAsignaUnPunto() {
        List<String> respuestaCorrecta = new LinkedList<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");

        List<String> respuestaJugador = new LinkedList<>();
        respuestaJugador.add("a");
        respuestaJugador.add("b");
        respuestaJugador.add("c");
        respuestaJugador.add("d");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaOC", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef", respuestaJugador);

        assertEquals(1, panel.pedirPuntos("Stef"));
    }

    @Test
    public void test08CreoUnaPreguntOCYElJugadorLaContestaDesordenadoYSeLeAsignaCeroPuntos() {
        List<String> respuestaCorrecta = new LinkedList<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");

        List<String> respuestaJugador = new LinkedList<>();
        respuestaJugador.add("a");
        respuestaJugador.add("c");
        respuestaJugador.add("b");
        respuestaJugador.add("d");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaOC", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef", respuestaJugador);

        assertEquals(0, panel.pedirPuntos("Stef"));
    }

    @Test
    public void test09CreoUnaPreguntMCConPuntajeParcialYElJugadorLaContestaCorrectamenteDosBienDeTresYSeLeAsignaDosPuntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");

        Set<String> respuestaJugador = new HashSet<>();
        respuestaJugador.add("a");
        respuestaJugador.add("c");


        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPuntajeParcial", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef", respuestaJugador);

        assertEquals(2, panel.pedirPuntos("Stef"));
    }

    @Test
    public void test10CreoUnaPreguntMCConPuntajeParcialYElJugadorLaContestaCorrectamenteTresBienDeTresYSeLeAsignaDosPuntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");

        Set<String> respuestaJugador = new HashSet<>();
        respuestaJugador.add("b");
        respuestaJugador.add("c");
        respuestaJugador.add("a");


        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPuntajeParcial", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef", respuestaJugador);

        assertEquals(3, panel.pedirPuntos("Stef"));
    }

    @Test
    public void test11CreoUnaPreguntMCConPuntajeParcialYElJugadorLaContestaCorrectamenteDosYUnaMalYSeLeAsignaCeroPuntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");

        Set<String> respuestaJugador = new HashSet<>();
        respuestaJugador.add("b");
        respuestaJugador.add("c");
        respuestaJugador.add("a");


        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPuntajeParcial", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef", respuestaJugador);

        assertEquals(3, panel.pedirPuntos("Stef"));
    }

    @Test
    public void test12CreoUnaPreguntMCConPenalidadYElJugadorLaContestaCorrectamenteDosYUnaMalYSeLeAsignaUnoPuntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");

        Set<String> respuestaJugador = new HashSet<>();
        respuestaJugador.add("b");
        respuestaJugador.add("c");
        respuestaJugador.add("d");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPenalidad", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef", respuestaJugador);

        assertEquals(1, panel.pedirPuntos("Stef"));
    }

    @Test
    public void test13CreoUnaPreguntMCConPenalidadYElJugadorLaContestaCorrectamenteTresDeTresYSeLeAsignantresPuntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");

        Set<String> respuestaJugador = new HashSet<>();
        respuestaJugador.add("b");
        respuestaJugador.add("c");
        respuestaJugador.add("a");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPenalidad", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef", respuestaJugador);

        assertEquals(3, panel.pedirPuntos("Stef"));
    }

    @Test
    public void test14CreoUnaPreguntMCConPenalidadYElJugadorLaContestaCorrectamenteUnaDeTresYSeLeAsignaMenosUnPunto() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");

        Set<String> respuestaJugador = new HashSet<>();
        respuestaJugador.add("b");
        respuestaJugador.add("d");
        respuestaJugador.add("e");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPenalidad", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef", respuestaJugador);

        assertEquals(-1, panel.pedirPuntos("Stef"));
    }

    @Test
    public void test14CreoUnaPreguntVoFConPenalidadYElJugadorLaContestaCorrectamenteYSeLeAsignaUnPunto() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");

        Set<String> respuestaJugador = new HashSet<>();
        respuestaJugador.add("a");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFConPenalidad", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef", respuestaJugador);

        assertEquals(1, panel.pedirPuntos("Stef"));
    }

    @Test
    public void test15CreoUnaPreguntVoFConPenalidadYElJugadorLaContestaIncorrectamenteYSeLeAsignaMenosunPunto() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");

        Set<String> respuestaJugador = new HashSet<>();
        respuestaJugador.add("b");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFConPenalidad", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef", respuestaJugador);

        assertEquals(-1, panel.pedirPuntos("Stef"));
    }

    @Test
    public void test16CreoUnaPreguntVoFConPenalidadYElJugadorLaContestaIncorrectamenteYSeLeAsignaMenosunPunto() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");

        Set<String> respuestaJugador = new HashSet<>();
        respuestaJugador.add("b");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFConPenalidad", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef", respuestaJugador);

        assertEquals(-1, panel.pedirPuntos("Stef"));
    }

    @Test
    public void test17CreoUnaPreguntVoFConPenalidadYElJugadorElijeUsarMultiplicadorX2LaContestaIncorrectamenteYSeLeAsignaMenoDosPuntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");

        Set<String> respuestaJugador = new HashSet<>();
        respuestaJugador.add("b");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFConPenalidad", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");
        panel.activarDuplicador("Stef");
        panel.hacerPregunta("Stef", respuestaJugador);

        assertEquals(-2, panel.pedirPuntos("Stef"));
    }

    @Test
    public void test18CreoUnaPreguntVoFConPenalidadYElJugadorElijeUsarMultiplicadorX2LaContestaCorrectamenteYSeLeAsignaMenoDosPuntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");

        Set<String> respuestaJugador = new HashSet<>();
        respuestaJugador.add("a");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFConPenalidad", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");
        panel.activarDuplicador("Stef");
        panel.hacerPregunta("Stef", respuestaJugador);

        assertEquals(2, panel.pedirPuntos("Stef"));
    }

    @Test
    public void test19CreoUnaPreguntVoFConPenalidadYElJugadorElijeUsarMultiplicadorX3LaContestaIncorrectamenteYSeLeAsignaMenoTresPuntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");

        Set<String> respuestaJugador = new HashSet<>();
        respuestaJugador.add("b");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFConPenalidad", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");
        panel.activarTriplicador("Stef");
        panel.hacerPregunta("Stef", respuestaJugador);

        assertEquals(-3, panel.pedirPuntos("Stef"));
    }

    @Test
    public void test20CreoUnaPreguntVoFConPenalidadYElJugadorElijeUsarMultiplicadorX2LaContestaCorrectamenteYSeLeAsignanTresPuntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");

        Set<String> respuestaJugador = new HashSet<>();
        respuestaJugador.add("a");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFConPenalidad", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");
        panel.activarTriplicador("Stef");
        panel.hacerPregunta("Stef", respuestaJugador);

        assertEquals(3, panel.pedirPuntos("Stef"));
    }

    @Test
    public void test21CreoUnaPreguntMCConPenalidadYElJugadorElijeUsarMultiplicadorX2ContestaCeroDeTresCorrectamenteYSeLeAsignaMenosCuatroPuntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");

        Set<String> respuestaJugador = new HashSet<>();
        respuestaJugador.add("b");
        respuestaJugador.add("e");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPenalidad", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");
        panel.activarDuplicador("Stef");
        panel.hacerPregunta("Stef", respuestaJugador);

        assertEquals(-4, panel.pedirPuntos("Stef"));
    }

    @Test
    public void test22CreoUnaPreguntMCConPenalidadYElJugadorElijeUsarMultiplicadorX2LaContestaCorrectamenteYSeLeAsignaMenoSeisPuntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");

        Set<String> respuestaJugador = new HashSet<>();
        respuestaJugador.add("a");
        respuestaJugador.add("c");
        respuestaJugador.add("d");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPenalidad", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");
        panel.activarDuplicador("Stef");
        panel.hacerPregunta("Stef", respuestaJugador);


        assertEquals(6, panel.pedirPuntos("Stef"));
    }


    @Test
    public void test23CreoUnaPreguntMCConPenalidadYElJugadorElijeUsarMultiplicadorX3ContestaCeroDeTresBienYSeLeAsignaMenosSeisPuntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("d");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("e");

        Set<String> respuestaJugador = new HashSet<>();
        respuestaJugador.add("a");
        respuestaJugador.add("b");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPenalidad", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");
        panel.activarTriplicador("Stef");
        panel.hacerPregunta("Stef", respuestaJugador);

        assertEquals(-6, panel.pedirPuntos("Stef"));
    }

    @Test
    public void test24CreoUnaPreguntaMCConPenalidadYElJugadorElijeUsarMultiplicadorX3LaContestaCorrectamenteYSeLeAsignanDocePuntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");
        respuestaCorrecta.add("e");

        Set<String> respuestaJugador = new HashSet<>();
        respuestaJugador.add("a");
        respuestaJugador.add("c");
        respuestaJugador.add("e");
        respuestaJugador.add("d");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFConPenalidad", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");
        panel.activarTriplicador("Stef");
        panel.hacerPregunta("Stef", respuestaJugador);

        assertEquals(12, panel.pedirPuntos("Stef"));
    }

    @Test
    public void test25PidoUsarDosVecesElDuplicadorYSeLanzaExcepcion() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");
        respuestaCorrecta.add("e");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFConPenalidad", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");
        panel.activarDuplicador("Stef");
        assertThrows(ExcepcionYaUsasteTuDuplicadorSalame.class, () -> panel.activarDuplicador("Stef"));
    }

    @Test
    public void test26PidoUsarDosVecesElTriplicadorYSeLanzaExcepcion() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");
        respuestaCorrecta.add("e");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFConPenalidad", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");
        panel.activarTriplicador("Stef");
        assertThrows(ExcepcionYaUsasteTuTriplicadorSalame.class, () -> panel.activarTriplicador("Stef"));
    }

    @Test
    public void test27CreoUnaPreguntaMCClasicaPidoUsarDuplicadorYLanzaExcepcion() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");
        respuestaCorrecta.add("e");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCClasica", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");

        assertThrows(ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador.class, () -> panel.activarDuplicador("Stef"));
    }

    @Test
    public void test28CreoUnaPreguntaMCConPuntajeParcialPidoUsarTriplicadorYLanzaExcepcion() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");
        respuestaCorrecta.add("e");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPuntajeParcial", "pregunta", respuestaCorrecta);
        panel.crearJugador("Stef");

        assertThrows(ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador.class, () -> panel.activarTriplicador("Stef"));
    }

    @Test
    public void test29CreoUnaPreguntaVoFConPenalidadSaltaExcepcion() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFConPenalidad", "pregunta", respuestaCorrecta);

        panel.crearJugador("Stef");
        panel.crearJugador("Ivan");

        assertThrows(ExcepcionSoloPreguntasClasicasYPuntajeParcialPuedeUsarExclusividad.class, ()-> panel.activarExclusividad("Stef"));

    }

    @Test
    public void test30CreoUnaPreguntaVoFClasicaElPrimerJugadorActivaExlusividadContestaBienElSegundoMalYSeLeAsignaEldobleDePutntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("a");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("b");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFClasica", "pregunta", respuestaCorrecta);

        panel.crearJugador("Stef");
        panel.crearJugador("Ivan");

        panel.activarExclusividad("Stef");
        panel.hacerPregunta("Stef",respuestaJugador1);
        panel.hacerPregunta("Ivan",respuestaJugador2);

        panel.calcularExclusividad();

        assertEquals(2,panel.pedirPuntos("Stef"));

    }

    @Test
    public void test30CreoUnaPreguntaVoFClasicaElPrimerJugadorActivaExlusividadContestaMalElSegundoBienYSeLeAsignaEldobleDePutntosAlSegundo() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("b");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("a");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFClasica", "pregunta", respuestaCorrecta);

        panel.crearJugador("Stef");
        panel.crearJugador("Ivan");

        panel.activarExclusividad("Stef");
        panel.hacerPregunta("Stef",respuestaJugador1);
        panel.hacerPregunta("Ivan",respuestaJugador2);

        panel.calcularExclusividad();

        assertEquals(2,panel.pedirPuntos("Ivan"));

    }

    @Test
    public void test31CreoUnaPreguntaVoFClasicaAmbosJugadoresActivanExlusividadElPrimeroContestaMalElSegundoBienYSeLeAsignaElCuadrupleDePutntosAlSegundo() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("b");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("a");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFClasica", "pregunta", respuestaCorrecta);

        panel.crearJugador("Stef");
        panel.crearJugador("Ivan");

        panel.activarExclusividad("Stef");
        panel.hacerPregunta("Stef",respuestaJugador1);

        panel.activarExclusividad("Ivan");
        panel.hacerPregunta("Ivan",respuestaJugador2);

        panel.calcularExclusividad();

        assertEquals(4,panel.pedirPuntos("Ivan"));

    }

    @Test
    public void test32CreoUnaPreguntaVoFClasicaAmbosJugadoresActivanExlusividadAmbosContestanBienYNoSeMultiplicanLosPuntajes() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("a");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("a");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFClasica", "pregunta", respuestaCorrecta);

        panel.crearJugador("Stef");
        panel.crearJugador("Ivan");

        panel.activarExclusividad("Stef");
        panel.hacerPregunta("Stef",respuestaJugador1);

        panel.activarExclusividad("Ivan");
        panel.hacerPregunta("Ivan",respuestaJugador2);

        panel.calcularExclusividad();

        assertEquals(1,panel.pedirPuntos("Stef"));
        assertEquals(1,panel.pedirPuntos("Ivan"));

    }

    @Test
    public void test33CreoUnaPreguntaVoFClasicaAmbosJugadoresActivanExlusividadAmbosContestanMalYLosPuntosSonCero() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");

        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("b");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("b");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFClasica", "pregunta", respuestaCorrecta);

        panel.crearJugador("Stef");
        panel.crearJugador("Ivan");

        panel.activarExclusividad("Stef");
        panel.hacerPregunta("Stef",respuestaJugador1);

        panel.activarExclusividad("Ivan");
        panel.hacerPregunta("Ivan",respuestaJugador2);

        panel.calcularExclusividad();

        assertEquals(0,panel.pedirPuntos("Stef"));
        assertEquals(0,panel.pedirPuntos("Ivan"));

    }

    @Test
    public void test34CreoUnaPreguntaMCCElPrimerJugadorActivaExclusividadYSoloElContestaBienYSeLeDuplicanElPuntaje() {
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

        panel.crearJugador("Stef");
        panel.crearJugador("Ivan");

        panel.activarExclusividad("Stef");
        panel.hacerPregunta("Stef",respuestaJugador1);

        panel.hacerPregunta("Ivan",respuestaJugador2);

        panel.calcularExclusividad();

        assertEquals(2,panel.pedirPuntos("Stef"));
        assertEquals(0,panel.pedirPuntos("Ivan"));

    }

    @Test
    public void test35CreoUnaPreguntaMCCElPrimerJugadorActivaExclusividadYSoloElSegundoJugadorContestaBienYSeLeDuplicaeElPuntaje() {
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

        panel.crearJugador("Stef");
        panel.crearJugador("Ivan");

        panel.activarExclusividad("Stef");
        panel.hacerPregunta("Stef",respuestaJugador1);

        panel.hacerPregunta("Ivan",respuestaJugador2);

        panel.calcularExclusividad();

        assertEquals(0,panel.pedirPuntos("Stef"));
        assertEquals(2,panel.pedirPuntos("Ivan"));
    }

    @Test
    public void test36CreoUnaPreguntaMCCElPrimerJugadorActivaExclusividadYAmbosContestaBienYNOSeLeDuplicaElPuntaje() {
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

        panel.crearJugador("Stef");
        panel.crearJugador("Ivan");

        panel.activarExclusividad("Stef");
        panel.hacerPregunta("Stef",respuestaJugador1);

        panel.hacerPregunta("Ivan",respuestaJugador2);

        panel.calcularExclusividad();

        assertEquals(1,panel.pedirPuntos("Stef"));
        assertEquals(1,panel.pedirPuntos("Ivan"));
    }

    @Test
    public void test37CreoUnaPreguntaMCCElPrimerJugadorActivaExclusividadYAmbosContestaMalYNOSeLeDuplicaElPuntaje() {
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

        panel.crearJugador("Stef");
        panel.crearJugador("Ivan");

        panel.activarExclusividad("Stef");
        panel.hacerPregunta("Stef",respuestaJugador1);

        panel.hacerPregunta("Ivan",respuestaJugador2);

        panel.calcularExclusividad();

        assertEquals(0,panel.pedirPuntos("Stef"));
        assertEquals(0,panel.pedirPuntos("Ivan"));
    }

    @Test
    public void test38CreoUnaPreguntaMCCElSegundoJugadorActivaExclusividadContestaMalYSeLeDuplicaElPuntajeAlPrimerJugador() {
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

        panel.crearJugador("Stef");
        panel.crearJugador("Ivan");

        panel.hacerPregunta("Stef",respuestaJugador1);

        panel.activarExclusividad("Ivan");
        panel.hacerPregunta("Ivan",respuestaJugador2);

        panel.calcularExclusividad();

        assertEquals(2,panel.pedirPuntos("Stef"));
        assertEquals(0,panel.pedirPuntos("Ivan"));
    }

    @Test
    public void test39CreoUnaPreguntaMCCAmbosActivaExclusividadElPrimeroContestaMalElSegundoBienYSeLeCuadriplicanLosPuntos() {
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

        panel.crearJugador("Stef");
        panel.crearJugador("Ivan");

        panel.activarExclusividad("Stef");
        panel.hacerPregunta("Stef",respuestaJugador1);

        panel.activarExclusividad("Ivan");
        panel.hacerPregunta("Ivan",respuestaJugador2);

        panel.calcularExclusividad();

        assertEquals(0,panel.pedirPuntos("Stef"));
        assertEquals(4,panel.pedirPuntos("Ivan"));
    }

    @Test
    public void test40CreoUnaPreguntaMCCAmbosActivaExclusividadAmbosContestanBienYNoSeLeCuadriplicanLosPuntos() {
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

        panel.crearJugador("Stef");
        panel.crearJugador("Ivan");

        panel.activarExclusividad("Stef");
        panel.hacerPregunta("Stef",respuestaJugador1);

        panel.activarExclusividad("Ivan");
        panel.hacerPregunta("Ivan",respuestaJugador2);

        panel.calcularExclusividad();

        assertEquals(1,panel.pedirPuntos("Stef"));
        assertEquals(1,panel.pedirPuntos("Ivan"));
    }

    @Test
    public void test41CreoUnaPreguntaMCConPuntajeParcialElJugadorUnoActivaExclusividadContestaBienSeLeDuplicanLosPuntos() {
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
        respuestaJugador2.add("b");
        respuestaJugador2.add("e");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPuntajeParcial", "pregunta", respuestaCorrecta);

        panel.crearJugador("Stef");
        panel.crearJugador("Ivan");

        panel.activarExclusividad("Stef");
        panel.hacerPregunta("Stef",respuestaJugador1);

        panel.hacerPregunta("Ivan",respuestaJugador2);

        panel.calcularExclusividad();

        assertEquals(6,panel.pedirPuntos("Stef"));
        assertEquals(0,panel.pedirPuntos("Ivan"));
    }

    @Test
    public void test42CreoUnaPreguntaMCConPuntajeParcialElJugadorUnoActivaExclusividadContestaBienYElSegundoContestaParcialmenteBienNoSeLeDuplicanLosPuntos() {
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

        panel.crearJugador("Stef");
        panel.crearJugador("Ivan");

        panel.activarExclusividad("Stef");
        panel.hacerPregunta("Stef",respuestaJugador1);

        panel.hacerPregunta("Ivan",respuestaJugador2);

        panel.calcularExclusividad();

        assertEquals(3,panel.pedirPuntos("Stef"));
        assertEquals(2,panel.pedirPuntos("Ivan"));
    }

    @Test
    public void test43CreoUnaPreguntaMCConPuntajeParcialElJugadorUnoActivaExclusividadContestaParcialmenteBienYElSegundoContestaParcialmenteBienIgualQueElJugadorUnoNoSeLeDuplicanLosPuntosANingunJugador() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("e");
        respuestaCorrecta.add("b");


        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("c");
        respuestaJugador1.add("a");
        respuestaJugador1.add("e");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("c");
        respuestaJugador2.add("a");
        respuestaJugador2.add("b");


        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPuntajeParcial", "pregunta", respuestaCorrecta);

        panel.crearJugador("Stef");
        panel.crearJugador("Ivan");

        panel.activarExclusividad("Stef");
        panel.hacerPregunta("Stef",respuestaJugador1);

        panel.hacerPregunta("Ivan",respuestaJugador2);

        panel.calcularExclusividad();

        assertEquals(3,panel.pedirPuntos("Stef"));
        assertEquals(3,panel.pedirPuntos("Ivan"));
    }

    @Test
    public void test44CreoUnaPreguntaMCConPuntajeParcialElJugadorUnoActivaExclusividadContestaParcialmenteBienYElSegundoContestaParcialmenteBienMejorQueElJugadorUnoNoSeLeDuplicanLosPuntos() {
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
        respuestaJugador2.add("b");


        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPuntajeParcial", "pregunta", respuestaCorrecta);

        panel.crearJugador("Stef");
        panel.crearJugador("Ivan");

        panel.activarExclusividad("Stef");
        panel.hacerPregunta("Stef",respuestaJugador1);

        panel.hacerPregunta("Ivan",respuestaJugador2);

        panel.calcularExclusividad();

        assertEquals(2,panel.pedirPuntos("Stef"));
        assertEquals(3,panel.pedirPuntos("Ivan"));
    }

    @Test
    public void test45CreoUnaPreguntaMCConPuntajeParcialElJugadorUnoActivaExclusividadContestaParcialmenteBienBienYElSegundoMalSeLeDuplicanLosPuntosAlPrimerJugador() {
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

        panel.crearJugador("Stef");
        panel.crearJugador("Ivan");

        panel.activarExclusividad("Stef");
        panel.hacerPregunta("Stef",respuestaJugador1);

        panel.hacerPregunta("Ivan",respuestaJugador2);

        panel.calcularExclusividad();

        assertEquals(4,panel.pedirPuntos("Stef"));
        assertEquals(0,panel.pedirPuntos("Ivan"));
    }
    @Test
    public void test46CreoUnaPreguntaMCConPuntajeParcialElJugadorUnoActivaExclusividadContestaParcialmenteBienYElSegundoContestaMalSeLeDuplicanLosPuntosAlPrimerJugador() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");
        respuestaCorrecta.add("e");


        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("c");
        respuestaJugador1.add("e");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("c");
        respuestaJugador2.add("b");
        respuestaJugador2.add("a");


        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPuntajeParcial", "pregunta", respuestaCorrecta);

        panel.crearJugador("Stef");
        panel.crearJugador("Ivan");

        panel.activarExclusividad("Stef");
        panel.hacerPregunta("Stef",respuestaJugador1);

        panel.hacerPregunta("Ivan",respuestaJugador2);

        panel.calcularExclusividad();

        assertEquals(4,panel.pedirPuntos("Stef"));
        assertEquals(0,panel.pedirPuntos("Ivan"));
    }

    @Test
    public void test47CreoUnaPreguntaMCConPuntajeParcialAmbosActivanExclusividadElJugadorDosContestaBienElUnoMalYSeLeCuadriplicanLosPuntosAlJugadorDos() {
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

        panel.crearJugador("Stef");
        panel.crearJugador("Ivan");

        panel.activarExclusividad("Stef");
        panel.hacerPregunta("Stef",respuestaJugador1);

        panel.activarExclusividad("Ivan");
        panel.hacerPregunta("Ivan",respuestaJugador2);

        panel.calcularExclusividad();

        assertEquals(0,panel.pedirPuntos("Stef"));
        assertEquals(16,panel.pedirPuntos("Ivan"));
    }

    @Test
    public void test48CreoUnaPreguntaMCConPuntajeParcialAmbosActivanExclusividadYContestanBienNoSeMultiplicanLosPuntos() {
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

        panel.crearJugador("Stef");
        panel.crearJugador("Ivan");

        panel.activarExclusividad("Stef");
        panel.hacerPregunta("Stef",respuestaJugador1);

        panel.activarExclusividad("Ivan");
        panel.hacerPregunta("Ivan",respuestaJugador2);

        panel.calcularExclusividad();

        assertEquals(4,panel.pedirPuntos("Stef"));
        assertEquals(4,panel.pedirPuntos("Ivan"));
    }

    @Test
    public void test49CreoUnaPreguntaOCAmbosActivanExclusividadYContestanBienNoSeMultiplicanLosPuntos() {
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

        panel.crearJugador("Stef");
        panel.crearJugador("Ivan");

        panel.activarExclusividad("Stef");
        panel.hacerPregunta("Stef",respuestaJugador1);

        panel.activarExclusividad("Ivan");
        panel.hacerPregunta("Ivan",respuestaJugador2);

        panel.calcularExclusividad();

        assertEquals(1,panel.pedirPuntos("Stef"));
        assertEquals(1,panel.pedirPuntos("Ivan"));
    }

    @Test
    public void test50CreoUnaPreguntaOCAmbosActivanExclusividadYContestanBienSoloELJugador1SeMultiplicanLosPuntos() {
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

        panel.crearJugador("Stef");
        panel.crearJugador("Ivan");

        panel.activarExclusividad("Stef");
        panel.hacerPregunta("Stef",respuestaJugador1);

        panel.activarExclusividad("Ivan");
        panel.hacerPregunta("Ivan",respuestaJugador2);

        panel.calcularExclusividad();

        assertEquals(4,panel.pedirPuntos("Stef"));
        assertEquals(0,panel.pedirPuntos("Ivan"));
    }
    @Test
    public void test51CreoUnaPreguntaGCAmbosActivanExclusividadYContestanBienSoloELJugador1SeMultiplicanLosPuntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");
        respuestaCorrecta.add("e");
        respuestaCorrecta.add("grupo1");


        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("a");
        respuestaJugador1.add("c");
        respuestaJugador1.add("d");
        respuestaJugador1.add("e");
        respuestaJugador1.add("grupo1");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("a");
        respuestaJugador2.add("d");
        respuestaJugador2.add("grupo1");


        Panel panel = new Panel();

        panel.crearPregunta("preguntaOC", "pregunta", respuestaCorrecta);

        panel.crearJugador("Stef");
        panel.crearJugador("Ivan");

        panel.activarExclusividad("Stef");
        panel.hacerPregunta("Stef",respuestaJugador1);

        panel.activarExclusividad("Ivan");
        panel.hacerPregunta("Ivan",respuestaJugador2);

        panel.calcularExclusividad();

        assertEquals(4,panel.pedirPuntos("Stef"));
        assertEquals(0,panel.pedirPuntos("Ivan"));
    }
    @Test
    public void test52CreoUnaPreguntaGCAmbosActivanExclusividadYContestanMalNoSeMultiplicanLosPuntos() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");
        respuestaCorrecta.add("e");
        respuestaCorrecta.add("grupo1");


        Set<String> respuestaJugador1 = new HashSet<>();
        respuestaJugador1.add("a");
        respuestaJugador1.add("c");
        respuestaJugador1.add("d");
        respuestaJugador1.add("e");
        respuestaJugador1.add("grupo2");

        Set<String> respuestaJugador2 = new HashSet<>();
        respuestaJugador2.add("a");
        respuestaJugador2.add("d");
        respuestaJugador2.add("grupo1");


        Panel panel = new Panel();

        panel.crearPregunta("preguntaOC", "pregunta", respuestaCorrecta);

        panel.crearJugador("Stef");
        panel.crearJugador("Ivan");

        panel.activarExclusividad("Stef");
        panel.hacerPregunta("Stef",respuestaJugador1);

        panel.activarExclusividad("Ivan");
        panel.hacerPregunta("Ivan",respuestaJugador2);

        panel.calcularExclusividad();

        assertEquals(0,panel.pedirPuntos("Stef"));
        assertEquals(0,panel.pedirPuntos("Ivan"));
    }

    @Test
    public void test53CreoUnaPreguntaGCOtraVoFClasicaYUnaMCclasicaElJugadorUbnoUsaExclusividadEnTodaSaltaExcepcion() {
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

        panel.crearPregunta("preguntaOC", "pregunta", respuestaCorrectaGC);

        panel.crearJugador("Stef");
        panel.crearJugador("Ivan");

        panel.activarExclusividad("Stef");
        panel.hacerPregunta("Stef",respuestaJugador1GC);

        panel.hacerPregunta("Ivan",respuestaJugador2GC);

        panel.calcularExclusividad();

        assertEquals(2,panel.pedirPuntos("Stef"));
        assertEquals(0,panel.pedirPuntos("Ivan"));

        panel.crearPregunta("preguntaVoFClasica", "pregunta", respuestaCorrectaVF);
        panel.activarExclusividad("Stef");

        panel.hacerPregunta("Stef",respuestaJugador1VF);

        panel.hacerPregunta("Ivan",respuestaJugador2VF);

        panel.calcularExclusividad();

        assertEquals(4,panel.pedirPuntos("Stef"));
        assertEquals(0,panel.pedirPuntos("Ivan"));

        assertThrows(ExcepcionYaUsasteLasExclusividadesSalame.class, ()->panel.activarExclusividad("Stef"));
    }
}

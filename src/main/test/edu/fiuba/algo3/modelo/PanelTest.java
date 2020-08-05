package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PanelTest {

    @Test
    public void test01CreoUnaPreguntaFoVClasicaYElJugadorLaContestaBienYSeLeAsignaUnPunto(){
        Set<String> respuestaCorrecta = new HashSet();
        respuestaCorrecta.add("a");

        Set<String> respuestaJugador= new HashSet();
        respuestaJugador.add("a");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFClasica","pregunta",respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef",respuestaJugador);

        assertEquals(1,panel.pedirPuntos("Stef"));
    }

    @Test
    public void test02CreoUnaPreguntaFoVClasicaYElJugadorLaContestaMalYSeLeAsignaCeroPuntos(){
        Set<String> respuestaCorrecta = new HashSet();
        respuestaCorrecta.add("a");

        Set<String> respuestaJugador= new HashSet();
        respuestaJugador.add("b");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCClasica","pregunta",respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef",respuestaJugador);

        assertEquals(0,panel.pedirPuntos("Stef"));
    }

    @Test
    public void test03CreoUnaPreguntaMCClasicaYElJugadorLaContestaCorrectamenteYSeLeAsignaUnPunto(){
        Set<String> respuestaCorrecta = new HashSet();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");

        Set<String> respuestaJugador= new HashSet();
        respuestaJugador.add("d");
        respuestaJugador.add("a");
        respuestaJugador.add("b");
        respuestaJugador.add("c");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFClasica","pregunta",respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef",respuestaJugador);

        assertEquals(1,panel.pedirPuntos("Stef"));
    }

    @Test
    public void test04CreoUnaPreguntaMCClasicaYElJugadorLaContestaMalYSeLeAsignaCeroPunto(){
        Set<String> respuestaCorrecta = new HashSet();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("e");

        Set<String> respuestaJugador= new HashSet();
        respuestaJugador.add("d");
        respuestaJugador.add("a");
        respuestaJugador.add("b");
        respuestaJugador.add("c");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCClasica","pregunta",respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef",respuestaJugador);

        assertEquals(0,panel.pedirPuntos("Stef"));
    }

    @Test
    public void test05CreoUnaPreguntaGCYElJugadorLaContestaMalYSeLeAsignaCeroPunto(){
        Set<String> respuestaCorrecta = new HashSet();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");

        Set<String> respuestaJugador= new HashSet();
        respuestaJugador.add("d");
        respuestaJugador.add("a");
        respuestaJugador.add("b");
        respuestaJugador.add("c");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaGC","pregunta",respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef",respuestaJugador);

        assertEquals(0,panel.pedirPuntos("Stef"));
    }

    @Test
    public void test06CreoUnaPreguntGCYElJugadorLaContestaCorrectamenteYSeLeAsignaUnPunto(){
        Set<String> respuestaCorrecta = new HashSet();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");

        Set<String> respuestaJugador= new HashSet();
        respuestaJugador.add("d");
        respuestaJugador.add("a");
        respuestaJugador.add("b");
        respuestaJugador.add("c");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaGC","pregunta",respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef",respuestaJugador);

        assertEquals(1,panel.pedirPuntos("Stef"));
    }

    @Test
    public void test07CreoUnaPreguntOCYElJugadorLaContestaCorrectamenteYSeLeAsignaUnPunto(){
        List<String> respuestaCorrecta = new LinkedList();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");

        List<String> respuestaJugador= new LinkedList();
        respuestaJugador.add("a");
        respuestaJugador.add("b");
        respuestaJugador.add("c");
        respuestaJugador.add("d");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaOC","pregunta",respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef",respuestaJugador);

        assertEquals(1,panel.pedirPuntos("Stef"));
    }

    @Test
    public void test08CreoUnaPreguntOCYElJugadorLaContestaDesordenadoYSeLeAsignaCeroPuntos(){
        List<String> respuestaCorrecta = new LinkedList();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");
        respuestaCorrecta.add("d");

        List<String> respuestaJugador= new LinkedList();
        respuestaJugador.add("a");
        respuestaJugador.add("c");
        respuestaJugador.add("b");
        respuestaJugador.add("d");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaOC","pregunta",respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef",respuestaJugador);

        assertEquals(0,panel.pedirPuntos("Stef"));
    }

    @Test
    public void test09CreoUnaPreguntMCConPuntajeParcialYElJugadorLaContestaCorrectamenteDosBienDeTresYSeLeAsignaDosPuntos(){
        Set<String> respuestaCorrecta = new HashSet();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");

        Set<String> respuestaJugador= new HashSet();
        respuestaJugador.add("a");
        respuestaJugador.add("c");


        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPuntajeParcial","pregunta",respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef",respuestaJugador);

        assertEquals(2,panel.pedirPuntos("Stef"));
    }

    @Test
    public void test10CreoUnaPreguntMCConPuntajeParcialYElJugadorLaContestaCorrectamenteTresBienDeTresYSeLeAsignaDosPuntos(){
        Set<String> respuestaCorrecta = new HashSet();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");

        Set<String> respuestaJugador= new HashSet();
        respuestaJugador.add("b");
        respuestaJugador.add("c");
        respuestaJugador.add("a");


        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPuntajeParcial","pregunta",respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef",respuestaJugador);

        assertEquals(3,panel.pedirPuntos("Stef"));
    }

    @Test
    public void test11CreoUnaPreguntMCConPuntajeParcialYElJugadorLaContestaCorrectamenteDosYUnaMalYSeLeAsignaCeroPuntos(){
        Set<String> respuestaCorrecta = new HashSet();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");

        Set<String> respuestaJugador= new HashSet();
        respuestaJugador.add("b");
        respuestaJugador.add("c");
        respuestaJugador.add("a");


        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPuntajeParcial","pregunta",respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef",respuestaJugador);

        assertEquals(3,panel.pedirPuntos("Stef"));
    }

    @Test
    public void test12CreoUnaPreguntMCConPenalidadYElJugadorLaContestaCorrectamenteDosYUnaMalYSeLeAsignaUnoPuntos(){
        Set<String> respuestaCorrecta = new HashSet();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");

        Set<String> respuestaJugador= new HashSet();
        respuestaJugador.add("b");
        respuestaJugador.add("c");
        respuestaJugador.add("d");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPenalidad","pregunta",respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef",respuestaJugador);

        assertEquals(1,panel.pedirPuntos("Stef"));
    }

    @Test
    public void test13CreoUnaPreguntMCConPenalidadYElJugadorLaContestaCorrectamenteTresDeTresYSeLeAsignantresPuntos(){
        Set<String> respuestaCorrecta = new HashSet();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");

        Set<String> respuestaJugador= new HashSet();
        respuestaJugador.add("b");
        respuestaJugador.add("c");
        respuestaJugador.add("a");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPenalidad","pregunta",respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef",respuestaJugador);

        assertEquals(3,panel.pedirPuntos("Stef"));
    }

    @Test
    public void test14CreoUnaPreguntMCConPenalidadYElJugadorLaContestaCorrectamenteUnaDeTresYSeLeAsignaMenosUnPunto(){
        Set<String> respuestaCorrecta = new HashSet();
        respuestaCorrecta.add("a");
        respuestaCorrecta.add("b");
        respuestaCorrecta.add("c");

        Set<String> respuestaJugador= new HashSet();
        respuestaJugador.add("b");
        respuestaJugador.add("d");
        respuestaJugador.add("e");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaMCConPenalidad","pregunta",respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef",respuestaJugador);

        assertEquals(-1,panel.pedirPuntos("Stef"));
    }

    @Test
    public void test14CreoUnaPreguntVoFConPenalidadYElJugadorLaContestaCorrectamenteYSeLeAsignaUnPunto(){
        Set<String> respuestaCorrecta = new HashSet();
        respuestaCorrecta.add("a");

        Set<String> respuestaJugador= new HashSet();
        respuestaJugador.add("a");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFConPenalidad","pregunta",respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef",respuestaJugador);

        assertEquals(1,panel.pedirPuntos("Stef"));
    }

    @Test
    public void test15CreoUnaPreguntVoFConPenalidadYElJugadorLaContestaIncorrectamenteYSeLeAsignaMenosunPunto(){
        Set<String> respuestaCorrecta = new HashSet();
        respuestaCorrecta.add("a");

        Set<String> respuestaJugador= new HashSet();
        respuestaJugador.add("b");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFConPenalidad","pregunta",respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef",respuestaJugador);

        assertEquals(-1,panel.pedirPuntos("Stef"));
    }

    @Test
    public void test16CreoUnaPreguntVoFConPenalidadYElJugadorLaContestaIncorrectamenteYSeLeAsignaMenosunPunto(){
        Set<String> respuestaCorrecta = new HashSet();
        respuestaCorrecta.add("a");

        Set<String> respuestaJugador= new HashSet();
        respuestaJugador.add("b");

        Panel panel = new Panel();

        panel.crearPregunta("preguntaVoFConPenalidad","pregunta",respuestaCorrecta);
        panel.crearJugador("Stef");

        panel.hacerPregunta("Stef",respuestaJugador);

        assertEquals(-1,panel.pedirPuntos("Stef"));
    }
}

package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpcionesOCTest {
    @Test
    public void Test01OpcionesOrderedChoiceYComparoCorrectamenteYDevuelveUnPunto() {
        List<String> respuestaElegidasDelJugador = new LinkedList<>();
        respuestaElegidasDelJugador.add("1");
        respuestaElegidasDelJugador.add("2");
        respuestaElegidasDelJugador.add("3");

        List<String> respuestasCorrectas = new LinkedList<>();
        respuestasCorrectas.add("1");
        respuestasCorrectas.add("2");
        respuestasCorrectas.add("3");

        OpcionesCorrectasClasicas opcionesCorrectas = new OpcionesCorrectasClasicas(respuestasCorrectas);

        int puntos = opcionesCorrectas.comparar(respuestaElegidasDelJugador);

        assertEquals(1, puntos);
    }

    @Test
    public void Test02OpcionesOrderedChoiceYComparoDesordenadoYDevuelveCeroPuntos() {
        List<String> respuestaElegidasDelJugador = new LinkedList<>();
        respuestaElegidasDelJugador.add("1");
        respuestaElegidasDelJugador.add("3");
        respuestaElegidasDelJugador.add("2");

        List<String> respuestasCorrectas = new LinkedList<>();
        respuestasCorrectas.add("1");
        respuestasCorrectas.add("2");
        respuestasCorrectas.add("3");

        OpcionesCorrectasClasicas opcionesCorrectas = new OpcionesCorrectasClasicas(respuestasCorrectas);

        int puntos = opcionesCorrectas.comparar(respuestaElegidasDelJugador);

        assertEquals(0, puntos);
    }

    @Test
    public void Test03OpcionesOrderedChoiceYComparoVacioYDevuelveCeroPuntos() {
        List<String> respuestaElegidasDelJugador = new LinkedList<>();

        List<String> respuestasCorrectas = new LinkedList<>();
        respuestasCorrectas.add("1");
        respuestasCorrectas.add("2");
        respuestasCorrectas.add("3");

        OpcionesCorrectasClasicas opcionesCorrectas = new OpcionesCorrectasClasicas(respuestasCorrectas);

        int puntos = opcionesCorrectas.comparar(respuestaElegidasDelJugador);

        assertEquals(0, puntos);
    }
}

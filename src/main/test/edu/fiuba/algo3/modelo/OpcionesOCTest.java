package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpcionesOCTest {
    @Test
    public void Test01OpcionesClasicasYComparoConUnaOpcionCorrectaYDevuelveUnPunto() {
        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("a");

        Set<String> respuestasCorrectas = new HashSet<>();
        respuestasCorrectas.add("a");

        OpcionesCorrectasClasicas opcionesCorrectas = new OpcionesCorrectasClasicas(respuestasCorrectas);

        int puntos = opcionesCorrectas.comparar(respuestaElegidasDelJugador);

        assertEquals(1, puntos);
    }
}

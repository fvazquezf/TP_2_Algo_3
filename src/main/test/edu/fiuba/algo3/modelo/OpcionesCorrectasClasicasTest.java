package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpcionesCorrectasClasicasTest {
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

    @Test
    public void Test02OpcionesClasicasYComparoConUnaOpcionCorrectaYDevuelveCeroPuntos() {
        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("b");

        Set<String> respuestasCorrectas = new HashSet<>();
        respuestasCorrectas.add("a");

        OpcionesCorrectasClasicas opcionesCorrectas = new OpcionesCorrectasClasicas(respuestasCorrectas);

        int puntos = opcionesCorrectas.comparar(respuestaElegidasDelJugador);

        assertEquals(0, puntos);
    }

    @Test
    public void Test03OpcionesClasicasYComparoConTresOpcionesCorrectasYDevuelveUnPunto() {
        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("c");
        respuestaElegidasDelJugador.add("a");
        respuestaElegidasDelJugador.add("d");

        Set<String> respuestasCorrectas = new HashSet<>();
        respuestasCorrectas.add("a");
        respuestasCorrectas.add("c");
        respuestasCorrectas.add("d");

        OpcionesCorrectasClasicas opcionesCorrectas = new OpcionesCorrectasClasicas(respuestasCorrectas);

        int puntos = opcionesCorrectas.comparar(respuestaElegidasDelJugador);

        assertEquals(1, puntos);
    }

    @Test
    public void Test04OpcionesClasicasYComparoConTresOpcionesCorrectasYDevuelveCeroPuntos() {
        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("c");
        respuestaElegidasDelJugador.add("a");

        Set<String> respuestasCorrectas = new HashSet<>();
        respuestasCorrectas.add("a");
        respuestasCorrectas.add("c");
        respuestasCorrectas.add("d");

        OpcionesCorrectasClasicas opcionesCorrectas = new OpcionesCorrectasClasicas(respuestasCorrectas);

        int puntos = opcionesCorrectas.comparar(respuestaElegidasDelJugador);

        assertEquals(0, puntos);
    }
}

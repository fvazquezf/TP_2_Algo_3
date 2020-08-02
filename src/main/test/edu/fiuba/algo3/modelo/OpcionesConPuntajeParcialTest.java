package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpcionesConPuntajeParcialTest {
    @Test
    public void Test01OpcionesConPuntajeParcialYComparoConUnaOpcionCorrectaYDevuelveUnPunto() {
        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("a");

        Set<String> respuestasCorrectas = new HashSet<>();
        respuestasCorrectas.add("a");

        OpcionesCorrectasConPuntajeParcial opcionesCorrectas = new OpcionesCorrectasConPuntajeParcial(respuestasCorrectas);

        int puntos = opcionesCorrectas.comparar(respuestaElegidasDelJugador);

        assertEquals(1, puntos);
    }

    @Test
    public void Test02OpcionesConPuntajeParcialYComparoConDosOpcionesCorrectasYElijeUnaOpcionCorrectaYDevuelveUnPunto() {
        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("a");

        Set<String> respuestasCorrectas = new HashSet<>();
        respuestasCorrectas.add("a");
        respuestasCorrectas.add("b");

        OpcionesCorrectasConPuntajeParcial opcionesCorrectas = new OpcionesCorrectasConPuntajeParcial(respuestasCorrectas);

        int puntos = opcionesCorrectas.comparar(respuestaElegidasDelJugador);

        assertEquals(1, puntos);
    }
    @Test
    public void Test03OpcionesConPuntajeParcialYComparoConDosOpcionesCorrectasYElijeUnaOpcionCorrectaYUnaIncorrectaYDevuelveCeroPuntos() {
        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("c");
        respuestaElegidasDelJugador.add("a");

        Set<String> respuestasCorrectas = new HashSet<>();
        respuestasCorrectas.add("a");
        respuestasCorrectas.add("b");

        OpcionesCorrectasConPuntajeParcial opcionesCorrectas = new OpcionesCorrectasConPuntajeParcial(respuestasCorrectas);

        int puntos = opcionesCorrectas.comparar(respuestaElegidasDelJugador);

        assertEquals(0, puntos);
    }
    @Test
    public void Test04OpcionesConPuntajeParcialYComparoConCuatroOpcionesCorrectasYElijeTresOpcionCorrectasYDevuelveTresPuntos() {
        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("c");
        respuestaElegidasDelJugador.add("a");
        respuestaElegidasDelJugador.add("b");

        Set<String> respuestasCorrectas = new HashSet<>();
        respuestasCorrectas.add("a");
        respuestasCorrectas.add("c");
        respuestasCorrectas.add("d");
        respuestasCorrectas.add("b");

        OpcionesCorrectasConPuntajeParcial opcionesCorrectas = new OpcionesCorrectasConPuntajeParcial(respuestasCorrectas);

        int puntos = opcionesCorrectas.comparar(respuestaElegidasDelJugador);

        assertEquals(3, puntos);
    }
}

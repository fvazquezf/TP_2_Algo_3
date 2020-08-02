package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpcionesConPenalidadTest {

    @Test
    public void Test01OpcionesConPenalidadYComparoConUnaOpcionCorrectaYDevuelveUnPunto() {
        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("a");

        Set<String> respuestasCorrectas = new HashSet<>();
        respuestasCorrectas.add("a");

        OpcionesCorrectasConPenalidad opcionesCorrectas = new OpcionesCorrectasConPenalidad(respuestasCorrectas);

        int puntos = opcionesCorrectas.comparar(respuestaElegidasDelJugador);

        assertEquals(1, puntos);
    }

    @Test
    public void Test02OpcionesConPenalidadYComparoConUnaOpcionCorrectaYDosIncorrectasDevuelveMenosUnPunto() {
        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("a");
        respuestaElegidasDelJugador.add("b");
        respuestaElegidasDelJugador.add("d");

        Set<String> respuestasCorrectas = new HashSet<>();
        respuestasCorrectas.add("a");

        OpcionesCorrectasConPenalidad opcionesCorrectas = new OpcionesCorrectasConPenalidad(respuestasCorrectas);

        int puntos = opcionesCorrectas.comparar(respuestaElegidasDelJugador);

        assertEquals(-1, puntos);
    }

    @Test
    public void Test03OpcionesConPenalidadYComparoConDosOpcionesCorrectasYElijoSolaUnaYDevuelveUnPunto() {
        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("a");

        Set<String> respuestasCorrectas = new HashSet<>();
        respuestasCorrectas.add("a");
        respuestasCorrectas.add("c");

        OpcionesCorrectasConPenalidad opcionesCorrectas = new OpcionesCorrectasConPenalidad(respuestasCorrectas);

        int puntos = opcionesCorrectas.comparar(respuestaElegidasDelJugador);

        assertEquals(1, puntos);
    }

}

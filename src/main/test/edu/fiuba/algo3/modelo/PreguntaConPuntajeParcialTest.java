package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador;
import edu.fiuba.algo3.modelo.preguntas.PreguntaConPuntajeParcial;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PreguntaConPuntajeParcialTest {
    @Test
    public void Test01PreguntaConPuntajeParcialConUnaOpcionCorrectaSeComparaCorrectamenteYDevuelveUnPunto() {
        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("a");

        Set<String> respuestasCorrectas = new HashSet<>();
        respuestasCorrectas.add("a");

        PreguntaConPuntajeParcial preguntaConPuntajeParcial = new PreguntaConPuntajeParcial("Pregunta", respuestasCorrectas);

        int puntos = preguntaConPuntajeParcial.compararRespuestas(respuestaElegidasDelJugador);

        assertEquals(1, puntos);
    }

    @Test
    public void Test02PreguntaConPuntajeParcialConDosOpcionCorrectasSeComparaParcialmenteYDevuelveUnPunto() {
        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("a");

        Set<String> respuestasCorrectas = new HashSet<>();
        respuestasCorrectas.add("a");
        respuestasCorrectas.add("b");

        PreguntaConPuntajeParcial preguntaConPuntajeParcial = new PreguntaConPuntajeParcial("Pregunta", respuestasCorrectas);

        int puntos = preguntaConPuntajeParcial.compararRespuestas(respuestaElegidasDelJugador);

        assertEquals(1, puntos);
    }

    @Test
    public void Test03PreguntaConPuntajeParcialConDosOpcionCorrectasSeComparaIncorrectamenteYDevuelveCeroPuntos() {
        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("c");
        respuestaElegidasDelJugador.add("a");

        Set<String> respuestasCorrectas = new HashSet<>();
        respuestasCorrectas.add("a");
        respuestasCorrectas.add("b");

        PreguntaConPuntajeParcial preguntaConPuntajeParcial = new PreguntaConPuntajeParcial("Pregunta", respuestasCorrectas);

        int puntos = preguntaConPuntajeParcial.compararRespuestas(respuestaElegidasDelJugador);

        assertEquals(0, puntos);
    }

    @Test
    public void Test04PreguntaConPuntajeParcialConCuatroOpcionesCorrectasYEligeTresOpcionCorrectasYDevuelveTresPuntos() {
        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("c");
        respuestaElegidasDelJugador.add("a");
        respuestaElegidasDelJugador.add("b");

        Set<String> respuestasCorrectas = new HashSet<>();
        respuestasCorrectas.add("a");
        respuestasCorrectas.add("c");
        respuestasCorrectas.add("d");
        respuestasCorrectas.add("b");

        PreguntaConPuntajeParcial preguntaConPuntajeParcial = new PreguntaConPuntajeParcial("Pregunta", respuestasCorrectas);

        int puntos = preguntaConPuntajeParcial.compararRespuestas(respuestaElegidasDelJugador);

        assertEquals(3, puntos);
    }

    @Test
    public void Test05PreguntaConPuntajeParcialNoPuedeUsarMultiplicadorLanzaExcepcion() {
        Set<String> respuesta = new HashSet<>();
        respuesta.add("V");
        respuesta.add("F");

        PreguntaConPuntajeParcial pregunta = new PreguntaConPuntajeParcial("pregunta", respuesta);
        assertThrows(ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador.class, pregunta::activarMultiplicador);
    }
}

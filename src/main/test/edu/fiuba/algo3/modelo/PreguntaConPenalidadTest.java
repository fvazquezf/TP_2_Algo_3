package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionPreguntaMCInvalida;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionPreguntaVOFInvalida;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionSoloPreguntasClasicasYPuntajeParcialPuedeUsarExclusividad;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.PreguntaMCConPenalidad;
import edu.fiuba.algo3.modelo.preguntas.PreguntaVoFConPenalidad;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PreguntaConPenalidadTest {
    @Test
    public void Test01PreguntaVOFConPenalidadContestaCorrectamenteDevuelveUnPunto() {
        Set<String> opcionCorrecta = new HashSet<>();
        opcionCorrecta.add("V");

        Set<String> opcionJugador = new HashSet<>();
        opcionJugador.add("V");

        Pregunta preguntaConPenalidad = new PreguntaVoFConPenalidad("Es blanco el caballo blanco de San Martin?", opcionCorrecta);

        int puntos = preguntaConPenalidad.compararRespuestas(opcionJugador);

        assertEquals(1, puntos);
    }

    @Test
    public void Test02PreguntaVOFConPenalidadContestaIncorrectamenteDevuelveMenosUnPuntos() {
        Set<String> opcionCorrecta = new HashSet<>();
        opcionCorrecta.add("V");

        Set<String> opcionJugador = new HashSet<>();
        opcionJugador.add("F");

        Pregunta preguntaConPenalidad = new PreguntaVoFConPenalidad("Es blanco el caballo blanco de San Martin?", opcionCorrecta);

        int puntos = preguntaConPenalidad.compararRespuestas(opcionJugador);

        assertEquals(-1, puntos);
    }

    @Test
    public void Test03PreguntaMCConPenalidadContestaCorrectamenteDevuelveTresPuntos() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("Argentina");
        todasLasOpciones.add("Colombia");
        todasLasOpciones.add("Venezuela");
        todasLasOpciones.add("Bariloche");

        Set<String> opcionesCorrectas = new HashSet<>();
        opcionesCorrectas.add("Argentina");
        opcionesCorrectas.add("Venezuela");
        opcionesCorrectas.add("Colombia");

        Set<String> opcionesJugador = new HashSet<>();
        opcionesJugador.add("Argentina");
        opcionesJugador.add("Venezuela");
        opcionesJugador.add("Colombia");

        Pregunta preguntaConPenalidad = new PreguntaMCConPenalidad("seleccionar los paises", opcionesCorrectas, todasLasOpciones);

        int puntos = preguntaConPenalidad.compararRespuestas(opcionesJugador);

        assertEquals(3, puntos);
    }

    @Test
    public void Test04PreguntaMCConPenalidadContestaTresBienUnaMalDevuelveDosPuntos() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("Argentina");
        todasLasOpciones.add("Colombia");
        todasLasOpciones.add("Venezuela");
        todasLasOpciones.add("Bariloche");

        Set<String> opcionesCorrectas = new HashSet<>();
        opcionesCorrectas.add("Argentina");
        opcionesCorrectas.add("Venezuela");
        opcionesCorrectas.add("Colombia");

        Set<String> opcionesJugador = new HashSet<>();
        opcionesJugador.add("Argentina");
        opcionesJugador.add("Venezuela");
        opcionesJugador.add("Colombia");
        opcionesJugador.add("Bariloche");

        Pregunta preguntaConPenalidad = new PreguntaMCConPenalidad("seleccionar los paises", opcionesCorrectas, todasLasOpciones);

        int puntos = preguntaConPenalidad.compararRespuestas(opcionesJugador);

        assertEquals(2, puntos);
    }

    @Test
    public void Test05PreguntaMCConPenalidadContestaDosMalUnaBienDevuelveMenosUnPuntos() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("Argentina");
        todasLasOpciones.add("Colombia");
        todasLasOpciones.add("Jujuy");
        todasLasOpciones.add("Bariloche");

        Set<String> opcionesCorrectas = new HashSet<>();
        opcionesCorrectas.add("Argentina");
        opcionesCorrectas.add("Colombia");

        Set<String> opcionesJugador = new HashSet<>();
        opcionesJugador.add("Argentina");
        opcionesJugador.add("Jujuy");
        opcionesJugador.add("Bariloche");

        Pregunta preguntaConPenalidad = new PreguntaMCConPenalidad("seleccionar los paises", opcionesCorrectas, todasLasOpciones);

        int puntos = preguntaConPenalidad.compararRespuestas(opcionesJugador);

        assertEquals(-1, puntos);
    }

    @Test
    public void Test06PreguntaVOFConPenalidadNoPuedeUsarExclusividadLanzaExcepcion() {
        Set<String> opcionCorrecta = new HashSet<>();
        opcionCorrecta.add("V");

        Pregunta pregunta = new PreguntaVoFConPenalidad("Es blanco el caballo blanco de San Martin?", opcionCorrecta);
        assertThrows(ExcepcionSoloPreguntasClasicasYPuntajeParcialPuedeUsarExclusividad.class, pregunta::activarExclusividad);
    }

    @Test
    public void Test07PreguntaMCConPenalidadNoPuedeUsarExclusividadLanzaExcepcion() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("Argentina");
        todasLasOpciones.add("Colombia");
        todasLasOpciones.add("Venezuela");
        todasLasOpciones.add("Bariloche");

        Set<String> opcionesCorrectas = new HashSet<>();
        opcionesCorrectas.add("Argentina");
        opcionesCorrectas.add("Venezuela");
        opcionesCorrectas.add("Colombia");

        Pregunta pregunta = new PreguntaMCConPenalidad("Es blanco el caballo blanco de San Martin?", opcionesCorrectas, todasLasOpciones);
        assertThrows(ExcepcionSoloPreguntasClasicasYPuntajeParcialPuedeUsarExclusividad.class, pregunta::activarExclusividad);
    }

    @Test
    public void Test08PreguntaMCConPenalidadDebeTenerCincoOMenosOpciones() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("1");
        todasLasOpciones.add("3");
        todasLasOpciones.add("8");
        todasLasOpciones.add("9");
        todasLasOpciones.add("7");
        todasLasOpciones.add("4");

        Set<String> opcionesCorrectas = new HashSet<>();

        assertThrows(ExcepcionPreguntaMCInvalida.class, () -> new PreguntaMCConPenalidad("Ordenar ascendentemente", opcionesCorrectas, todasLasOpciones));
    }

    @Test
    public void Test09PreguntaMCConPenalidadDebeTenerDosOMasOpciones() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("1");
        todasLasOpciones.add("3");
        todasLasOpciones.add("8");
        todasLasOpciones.add("9");
        todasLasOpciones.add("7");
        todasLasOpciones.add("4");

        Set<String> opcionesCorrectas = new HashSet<>();

        assertThrows(ExcepcionPreguntaMCInvalida.class, () -> new PreguntaMCConPenalidad("Ordenar ascendentemente", opcionesCorrectas, todasLasOpciones));
    }

    @Test
    public void Test10PreguntaVOFConPenalidadNoPuedeTenerMasDeUnaOpcionCorrecta() {
        Set<String> opcionesCorrectas = new HashSet<>();
        opcionesCorrectas.add("V");
        opcionesCorrectas.add("F");

        assertThrows(ExcepcionPreguntaVOFInvalida.class, () -> new PreguntaVoFConPenalidad("El caballo blanco de San Martin es blanco?", opcionesCorrectas));
    }
}

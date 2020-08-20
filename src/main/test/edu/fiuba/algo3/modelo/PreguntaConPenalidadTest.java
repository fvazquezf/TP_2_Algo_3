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
        String[] opcionCorrecta = new String[1];
        opcionCorrecta[0] = "V";

        Set<String> opcionJugador = new HashSet<>();
        opcionJugador.add("V");

        Pregunta preguntaConPenalidad = new PreguntaVoFConPenalidad("preguntaVoFConPenalidad", "Es blanco el caballo blanco de San Martin?", opcionCorrecta);

        int puntos = preguntaConPenalidad.compararRespuestas(opcionJugador);

        assertEquals(1, puntos);
    }

    @Test
    public void Test03PreguntaMCConPenalidadContestaCorrectamenteDevuelveTresPuntos() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("Argentina");
        todasLasOpciones.add("Colombia");
        todasLasOpciones.add("Venezuela");
        todasLasOpciones.add("Bariloche");

        String[] opcionesCorrectas = new String[3];
        opcionesCorrectas[0] = "Argentina";
        opcionesCorrectas[1] = "Venezuela";
        opcionesCorrectas[2] = "Colombia";

        Set<String> opcionesJugador = new HashSet<>();
        opcionesJugador.add("Argentina");
        opcionesJugador.add("Venezuela");
        opcionesJugador.add("Colombia");

        Pregunta preguntaConPenalidad = new PreguntaMCConPenalidad("preguntaMCConPenalidad", "seleccionar los paises", opcionesCorrectas, todasLasOpciones);

        int puntos = preguntaConPenalidad.compararRespuestas(opcionesJugador);

        assertEquals(3, puntos);
    }

    @Test
    public void Test02PreguntaVOFConPenalidadContestaIncorrectamenteDevuelveMenosUnPuntos() {
        String[] opcionCorrecta = new String[1];
        opcionCorrecta[0] = "V";

        Set<String> opcionJugador = new HashSet<>();
        opcionJugador.add("F");

        Pregunta preguntaConPenalidad = new PreguntaVoFConPenalidad("preguntaVoFConPenalidad", "Es blanco el caballo blanco de San Martin?", opcionCorrecta);

        int puntos = preguntaConPenalidad.compararRespuestas(opcionJugador);

        assertEquals(-1, puntos);
    }

    @Test
    public void Test04PreguntaMCConPenalidadContestaTresBienUnaMalDevuelveDosPuntos() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("Argentina");
        todasLasOpciones.add("Colombia");
        todasLasOpciones.add("Venezuela");
        todasLasOpciones.add("Bariloche");

        String[] opcionesCorrectas = new String[3];
        opcionesCorrectas[0] = "Argentina";
        opcionesCorrectas[1] = "Venezuela";
        opcionesCorrectas[2] = "Colombia";

        Set<String> opcionesJugador = new HashSet<>();
        opcionesJugador.add("Argentina");
        opcionesJugador.add("Venezuela");
        opcionesJugador.add("Colombia");
        opcionesJugador.add("Bariloche");

        Pregunta preguntaConPenalidad = new PreguntaMCConPenalidad("preguntaMCConPenalidad", "seleccionar los paises", opcionesCorrectas, todasLasOpciones);

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

        String[] opcionesCorrectas = new String[2];
        opcionesCorrectas[0] = "Argentina";
        opcionesCorrectas[1] = "Colombia";

        Set<String> opcionesJugador = new HashSet<>();
        opcionesJugador.add("Argentina");
        opcionesJugador.add("Jujuy");
        opcionesJugador.add("Bariloche");

        Pregunta preguntaConPenalidad = new PreguntaMCConPenalidad("preguntaMCConPenalidad", "seleccionar los paises", opcionesCorrectas, todasLasOpciones);

        int puntos = preguntaConPenalidad.compararRespuestas(opcionesJugador);

        assertEquals(-1, puntos);
    }

    @Test
    public void Test06PreguntaVOFConPenalidadNoPuedeUsarExclusividadLanzaExcepcion() {
        String[] opcionCorrecta = new String[1];
        opcionCorrecta[0] = "V";

        Pregunta pregunta = new PreguntaVoFConPenalidad("preguntaVoFConPenalidad", "Es blanco el caballo blanco de San Martin?", opcionCorrecta);
        assertThrows(ExcepcionSoloPreguntasClasicasYPuntajeParcialPuedeUsarExclusividad.class, pregunta::activarExclusividad);
    }

    @Test
    public void Test07PreguntaMCConPenalidadNoPuedeUsarExclusividadLanzaExcepcion() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("Argentina");
        todasLasOpciones.add("Colombia");
        todasLasOpciones.add("Venezuela");
        todasLasOpciones.add("Bariloche");

        String[] opcionesCorrectas = new String[3];
        opcionesCorrectas[0] = "Argentina";
        opcionesCorrectas[1] = "Venezuela";
        opcionesCorrectas[2] = "Colombia";

        Pregunta pregunta = new PreguntaMCConPenalidad("preguntaMCConPenalidad", "Es blanco el caballo blanco de San Martin?", opcionesCorrectas, todasLasOpciones);
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

        String[] opcionesCorrectas = new String[0];

        assertThrows(ExcepcionPreguntaMCInvalida.class, () -> new PreguntaMCConPenalidad("preguntaMCConPenalidad", "Ordenar ascendentemente", opcionesCorrectas, todasLasOpciones));
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

        String[] opcionesCorrectas = new String[0];

        assertThrows(ExcepcionPreguntaMCInvalida.class, () -> new PreguntaMCConPenalidad("preguntaMCConPenalidad", "Ordenar ascendentemente", opcionesCorrectas, todasLasOpciones));
    }

    @Test
    public void Test10PreguntaVOFConPenalidadNoPuedeTenerMasDeUnaOpcionCorrecta() {
        String[] opcionesCorrectas = new String[2];
        opcionesCorrectas[0] = "V";
        opcionesCorrectas[1] = "F";

        assertThrows(ExcepcionPreguntaVOFInvalida.class, () -> new PreguntaVoFConPenalidad("preguntaVoFConPenalidad", "El caballo blanco de San Martin es blanco?", opcionesCorrectas));
    }
}

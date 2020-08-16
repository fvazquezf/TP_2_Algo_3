package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionPreguntaMCInvalida;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.PreguntaMCConPuntajeParcial;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PreguntaConPuntajeParcialTest {
    @Test
    public void Test01PreguntaConPuntajeParcialConUnaOpcionCorrectaSeComparaCorrectamenteYDevuelveUnPunto() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("Argentina");
        todasLasOpciones.add("Mendoza");
        todasLasOpciones.add("Jujuy");
        todasLasOpciones.add("Bariloche");

        Set<String> opcionesCorrectas = new HashSet<>();
        opcionesCorrectas.add("Argentina");

        Set<String> opcionesJugador = new HashSet<>();
        opcionesJugador.add("Argentina");

        Pregunta preguntaConPuntajeParcial = new PreguntaMCConPuntajeParcial("seleccione los paises", opcionesCorrectas, todasLasOpciones);

        int puntos = preguntaConPuntajeParcial.compararRespuestas(opcionesJugador);

        assertEquals(1, puntos);
    }

    @Test
    public void Test02PreguntaConPuntajeParcialConDosOpcionCorrectasSeComparaParcialmenteYDevuelveUnPunto() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("Argentina");
        todasLasOpciones.add("Venezuela");
        todasLasOpciones.add("Jujuy");
        todasLasOpciones.add("Bariloche");

        Set<String> opcionesCorrectas = new HashSet<>();
        opcionesCorrectas.add("Argentina");
        opcionesCorrectas.add("Venezuela");

        Set<String> opcionesJugador = new HashSet<>();
        opcionesJugador.add("Argentina");

        Pregunta preguntaConPuntajeParcial = new PreguntaMCConPuntajeParcial("seleccione los paises", opcionesCorrectas, todasLasOpciones);

        int puntos = preguntaConPuntajeParcial.compararRespuestas(opcionesJugador);

        assertEquals(1, puntos);
    }

    @Test
    public void Test03PreguntaConPuntajeParcialConDosOpcionCorrectasSeComparaIncorrectamenteYDevuelveCeroPuntos() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("Argentina");
        todasLasOpciones.add("Venezuela");
        todasLasOpciones.add("Jujuy");
        todasLasOpciones.add("Bariloche");

        Set<String> opcionesCorrectas = new HashSet<>();
        opcionesCorrectas.add("Argentina");
        opcionesCorrectas.add("Venezuela");

        Set<String> opcionesJugador = new HashSet<>();
        opcionesJugador.add("Jujuy");

        Pregunta preguntaConPuntajeParcial = new PreguntaMCConPuntajeParcial("seleccione los paises", opcionesCorrectas, todasLasOpciones);

        int puntos = preguntaConPuntajeParcial.compararRespuestas(opcionesJugador);

        assertEquals(0, puntos);
    }

    @Test
    public void Test04PreguntaConPuntajeParcialConCuatroOpcionesCorrectasYEligeTresOpcionCorrectasYDevuelveTresPuntos() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("Argentina");
        todasLasOpciones.add("Venezuela");
        todasLasOpciones.add("Colombia");
        todasLasOpciones.add("Brasil");
        todasLasOpciones.add("Bariloche");

        Set<String> opcionesCorrectas = new HashSet<>();
        opcionesCorrectas.add("Argentina");
        opcionesCorrectas.add("Venezuela");
        opcionesCorrectas.add("Brasil");
        opcionesCorrectas.add("Colombia");

        Set<String> opcionesJugador = new HashSet<>();
        opcionesJugador.add("Argentina");
        opcionesJugador.add("Venezuela");
        opcionesJugador.add("Brasil");

        Pregunta preguntaConPuntajeParcial = new PreguntaMCConPuntajeParcial("seleccione los paises", opcionesCorrectas, todasLasOpciones);

        int puntos = preguntaConPuntajeParcial.compararRespuestas(opcionesJugador);

        assertEquals(3, puntos);
    }

    @Test
    public void Test05PreguntaConPuntajeParcialNoPuedeUsarMultiplicadorLanzaExcepcion() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("Argentina");
        todasLasOpciones.add("Venezuela");
        todasLasOpciones.add("Colombia");
        todasLasOpciones.add("Brasil");
        todasLasOpciones.add("Bariloche");

        Set<String> opcionesCorrectas = new HashSet<>();
        opcionesCorrectas.add("Argentina");
        opcionesCorrectas.add("Venezuela");
        opcionesCorrectas.add("Brasil");
        opcionesCorrectas.add("Colombia");

        Pregunta pregunta = new PreguntaMCConPuntajeParcial("seleccione los paises", opcionesCorrectas, todasLasOpciones);
        assertThrows(ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador.class, pregunta::activarMultiplicador);
    }

    @Test
    public void Test06PreguntaConPuntajeParcialNoPuedeTenerMasDeCincoOpciones() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("Argentina");
        todasLasOpciones.add("Venezuela");
        todasLasOpciones.add("Colombia");
        todasLasOpciones.add("Brasil");
        todasLasOpciones.add("Bariloche");
        todasLasOpciones.add("Jujuy");

        Set<String> opcionesCorrectas = new HashSet<>();
        opcionesCorrectas.add("Argentina");
        opcionesCorrectas.add("Venezuela");
        opcionesCorrectas.add("Brasil");
        opcionesCorrectas.add("Colombia");

        assertThrows(ExcepcionPreguntaMCInvalida.class, () -> new PreguntaMCConPuntajeParcial("seleccionar los paises", opcionesCorrectas, todasLasOpciones));
    }

    @Test
    public void Test07PreguntaConPuntajeParcialNoPuedeTenerMenosDeDosOpciones() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("Argentina");

        Set<String> opcionesCorrectas = new HashSet<>();
        opcionesCorrectas.add("Argentina");

        assertThrows(ExcepcionPreguntaMCInvalida.class, () -> new PreguntaMCConPuntajeParcial("seleccionar los paises", opcionesCorrectas, todasLasOpciones));
    }
}

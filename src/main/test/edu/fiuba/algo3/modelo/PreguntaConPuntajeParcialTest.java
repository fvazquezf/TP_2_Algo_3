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

        String[] opcionesCorrectas = new String[1];
        opcionesCorrectas[0] = "Argentina";

        Set<String> opcionesJugador = new HashSet<>();
        opcionesJugador.add("Argentina");

        Pregunta preguntaConPuntajeParcial = new PreguntaMCConPuntajeParcial("preguntaMCConPuntajeParcial", "seleccione los paises", opcionesCorrectas, todasLasOpciones);

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

        String[] opcionesCorrectas = new String[2];
        opcionesCorrectas[0] = "Argentina";
        opcionesCorrectas[1] = "Venezuela";

        Set<String> opcionesJugador = new HashSet<>();
        opcionesJugador.add("Argentina");

        Pregunta preguntaConPuntajeParcial = new PreguntaMCConPuntajeParcial("preguntaMCConPuntajeParcial", "seleccione los paises", opcionesCorrectas, todasLasOpciones);

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

        String[] opcionesCorrectas = new String[2];
        opcionesCorrectas[0] = "Argentina";
        opcionesCorrectas[1] = "Venezuela";

        Set<String> opcionesJugador = new HashSet<>();
        opcionesJugador.add("Jujuy");

        Pregunta preguntaConPuntajeParcial = new PreguntaMCConPuntajeParcial("preguntaMCConPuntajeParcial", "seleccione los paises", opcionesCorrectas, todasLasOpciones);

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

        String[] opcionesCorrectas = new String[4];
        opcionesCorrectas[0] = "Argentina";
        opcionesCorrectas[1] = "Venezuela";
        opcionesCorrectas[2] = "Brasil";
        opcionesCorrectas[3] = "Colombia";

        Set<String> opcionesJugador = new HashSet<>();
        opcionesJugador.add("Argentina");
        opcionesJugador.add("Venezuela");
        opcionesJugador.add("Brasil");

        Pregunta preguntaConPuntajeParcial = new PreguntaMCConPuntajeParcial("preguntaMCConPuntajeParcial", "seleccione los paises", opcionesCorrectas, todasLasOpciones);

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

        String[] opcionesCorrectas = new String[4];
        opcionesCorrectas[0] = "Argentina";
        opcionesCorrectas[1] = "Venezuela";
        opcionesCorrectas[2] = "Brasil";
        opcionesCorrectas[3] = "Colombia";

        Pregunta pregunta = new PreguntaMCConPuntajeParcial("preguntaMCConPuntajeParcial", "seleccione los paises", opcionesCorrectas, todasLasOpciones);
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

        String[] opcionesCorrectas = new String[4];
        opcionesCorrectas[0] = "Argentina";
        opcionesCorrectas[1] = "Venezuela";
        opcionesCorrectas[2] = "Brasil";
        opcionesCorrectas[3] = "Colombia";

        assertThrows(ExcepcionPreguntaMCInvalida.class, () -> new PreguntaMCConPuntajeParcial("preguntaMCConPuntajeParcial", "seleccionar los paises", opcionesCorrectas, todasLasOpciones));
    }

    @Test
    public void Test07PreguntaConPuntajeParcialNoPuedeTenerMenosDeDosOpciones() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("Argentina");

        String[] opcionesCorrectas = new String[1];
        opcionesCorrectas[0] = "Argentina";


        assertThrows(ExcepcionPreguntaMCInvalida.class, () -> new PreguntaMCConPuntajeParcial("preguntaMCConPuntajeParcial", "seleccionar los paises", opcionesCorrectas, todasLasOpciones));
    }
}

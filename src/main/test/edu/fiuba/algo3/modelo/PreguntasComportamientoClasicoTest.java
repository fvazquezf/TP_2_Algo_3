package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.excepciones.ExcepcionPreguntaGCInvalida;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionPreguntaMCInvalida;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionPreguntaVOFInvalida;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador;
import edu.fiuba.algo3.modelo.preguntas.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PreguntasComportamientoClasicoTest {
    @Test
    public void Test01PreguntaVOFClasicaRespondeCorrectamenteDevuelveUnPunto() {
        Set<String> opcionCorrecta = new HashSet<>();
        opcionCorrecta.add("V");

        Set<String> opcionJugador = new HashSet<>();
        opcionJugador.add("V");

        Pregunta pregunta = new PreguntaVOFClasica("Para ser grande hay que ser campeón mundial", opcionCorrecta);

        int puntos = pregunta.compararRespuestas(opcionJugador);

        assertEquals(1, puntos);
    }

    @Test
    public void Test02PreguntaVOFClasicaRespondeIncorrectamenteDevuelveCeroPuntos() {
        Set<String> opcionCorrecta = new HashSet<>();
        opcionCorrecta.add("V");

        Set<String> opcionJugador = new HashSet<>();
        opcionJugador.add("F");

        Pregunta pregunta = new PreguntaVOFClasica("Independiente nunca perdió su clásico con dos jugadores más", opcionCorrecta);

        int puntos = pregunta.compararRespuestas(opcionJugador);

        assertEquals(0, puntos);
    }

    @Test
    public void Test03PreguntaVOFClasicaSoloPuedeRecibirUnaOpcionCorrecta() {
        Set<String> opcionesCorrectas = new HashSet<>();
        opcionesCorrectas.add("V");
        opcionesCorrectas.add("F");

        assertThrows(ExcepcionPreguntaVOFInvalida.class, () -> new PreguntaVOFClasica("Independiente nunca perdió su clásico con dos jugadores más", opcionesCorrectas));
    }

    @Test
    public void Test04PreguntaMCClasicaRespondeCorrectamenteDevuelveUnPunto() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("1");
        todasLasOpciones.add("2");
        todasLasOpciones.add("3");
        todasLasOpciones.add("4");

        Set<String> opcionesCorrectas = new HashSet<>();
        opcionesCorrectas.add("2");
        opcionesCorrectas.add("4");

        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("2");
        respuestaElegidasDelJugador.add("4");

        Pregunta pregunta = new PreguntaMCClasica("Cual de estos numeros son pares", opcionesCorrectas, todasLasOpciones);

        int puntos = pregunta.compararRespuestas(respuestaElegidasDelJugador);

        assertEquals(1, puntos);
    }

    @Test
    public void Test05PreguntaMCClasicaRespondeIncorrectamenteDevuelveCeroPuntos() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("1");
        todasLasOpciones.add("2");
        todasLasOpciones.add("3");
        todasLasOpciones.add("4");

        Set<String> opcionesCorrectas = new HashSet<>();
        opcionesCorrectas.add("2");
        opcionesCorrectas.add("4");

        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("1");
        respuestaElegidasDelJugador.add("4");

        Pregunta pregunta = new PreguntaMCClasica("Cual de estos numeros son pares", opcionesCorrectas, todasLasOpciones);

        int puntos = pregunta.compararRespuestas(respuestaElegidasDelJugador);

        assertEquals(0, puntos);
    }

    @Test
    public void Test06PreguntaMCDebeTenerDosOMasOpciones() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("1");

        Set<String> opcionesCorrectas = new HashSet<>();

        assertThrows(ExcepcionPreguntaMCInvalida.class, () -> new PreguntaMCClasica("Cual de estos numeros son pares", opcionesCorrectas, todasLasOpciones));
    }

    @Test
    public void Test07PreguntaMCDebeTenerCincoOMenosOpciones() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("1");
        todasLasOpciones.add("2");
        todasLasOpciones.add("3");
        todasLasOpciones.add("4");
        todasLasOpciones.add("5");
        todasLasOpciones.add("6");

        Set<String> opcionesCorrectas = new HashSet<>();

        assertThrows(ExcepcionPreguntaMCInvalida.class, () -> new PreguntaMCClasica("Cual de estos numeros son pares", opcionesCorrectas, todasLasOpciones));
    }

    @Test
    public void Test08PreguntaGCComparaCorrectamenteYDevuelveUnPunto() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("1");
        todasLasOpciones.add("2");
        todasLasOpciones.add("3");
        todasLasOpciones.add("4");

        Set<String> opcionesCorrectas = new HashSet<>();
        opcionesCorrectas.add("1");
        opcionesCorrectas.add("3");

        Set<String> opcionesJugador = new HashSet<>();
        opcionesJugador.add("1");
        opcionesJugador.add("Impares");
        opcionesJugador.add("3");

        String[] grupos = new String[2];
        grupos[0] = "Impares";
        grupos[1] = "Pares";

        Pregunta pregunta = new PreguntaGC("Separe los numeros en pares e impares", opcionesCorrectas, todasLasOpciones, grupos);
        int puntos = pregunta.compararRespuestas(opcionesJugador);

        assertEquals(1, puntos);
    }

    @Test
    public void Test09PreguntaClasicaGCComparaIncorrectamenteYDevuelveCeroPuntos() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("1");
        todasLasOpciones.add("2");
        todasLasOpciones.add("3");
        todasLasOpciones.add("4");

        Set<String> opcionesCorrectas = new HashSet<>();
        opcionesCorrectas.add("1");
        opcionesCorrectas.add("3");

        Set<String> opcionesJugador = new HashSet<>();
        opcionesJugador.add("1");
        opcionesJugador.add("Impares");
        opcionesJugador.add("2");

        String[] grupos = new String[2];
        grupos[0] = "Impares";
        grupos[1] = "Pares";

        Pregunta pregunta = new PreguntaGC("Separe los numeros en pares e impares", opcionesCorrectas, todasLasOpciones, grupos);
        int puntos = pregunta.compararRespuestas(opcionesJugador);

        assertEquals(0, puntos);
    }

    @Test
    public void test10PreguntaGCDebeTenerDosOMasOpciones() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("1");

        Set<String> opcionesCorrectas = new HashSet<>();

        String[] grupos = new String[0];

        assertThrows(ExcepcionPreguntaGCInvalida.class, () -> new PreguntaGC("Separe los numeros en pares e impares", opcionesCorrectas, todasLasOpciones, grupos));
    }

    @Test
    public void test11PreguntaGCDebeTenerSeisOMenosOpciones() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("1");
        todasLasOpciones.add("2");
        todasLasOpciones.add("3");
        todasLasOpciones.add("4");
        todasLasOpciones.add("5");
        todasLasOpciones.add("6");
        todasLasOpciones.add("7");

        Set<String> opcionesCorrectas = new HashSet<>();

        String[] grupos = new String[0];

        assertThrows(ExcepcionPreguntaGCInvalida.class, () -> new PreguntaGC("Separe los numeros en pares e impares", opcionesCorrectas, todasLasOpciones, grupos));
    }

    @Test
    public void test12PreguntaGCNoDebeTenerElNombreDeUnGrupoEntreSusOpciones() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("1");
        todasLasOpciones.add("2");
        todasLasOpciones.add("Impares");

        Set<String> opcionesCorrectas = new HashSet<>();

        String[] grupos = new String[2];
        grupos[0] = "Impares";
        grupos[1] = "Pares";

        assertThrows(ExcepcionPreguntaGCInvalida.class, () -> new PreguntaGC("Separe los numeros en pares e impares", opcionesCorrectas, todasLasOpciones, grupos));
    }

    @Test
    public void Test13PreguntaClasicaOCRespondeOrdenadamenteDevuelveUnPunto() {
        List<String> todasLasOpciones = new LinkedList<>();
        todasLasOpciones.add("2");
        todasLasOpciones.add("1");
        todasLasOpciones.add("5");
        todasLasOpciones.add("7");

        List<String> opcionesOrdenadas = new LinkedList<>();
        opcionesOrdenadas.add("1");
        opcionesOrdenadas.add("2");
        opcionesOrdenadas.add("5");
        opcionesOrdenadas.add("7");

        List<String> opcionesJugador = new LinkedList<>();
        opcionesJugador.add("1");
        opcionesJugador.add("2");
        opcionesJugador.add("5");
        opcionesJugador.add("7");

        Pregunta preguntaClasica = new PreguntaOC("Ordenar ascendentemente", opcionesOrdenadas, todasLasOpciones);

        int puntos = preguntaClasica.compararRespuestas(opcionesJugador);

        assertEquals(1, puntos);
    }

    @Test
    public void Test14PreguntaClasicaOCRespondeDesordenadamenteDevuelveUnPunto() {
        List<String> todasLasOpciones = new LinkedList<>();
        todasLasOpciones.add("2");
        todasLasOpciones.add("1");
        todasLasOpciones.add("5");
        todasLasOpciones.add("7");

        List<String> opcionesOrdenadas = new LinkedList<>();
        opcionesOrdenadas.add("1");
        opcionesOrdenadas.add("2");
        opcionesOrdenadas.add("5");
        opcionesOrdenadas.add("7");

        List<String> opcionesJugador = new LinkedList<>();
        opcionesJugador.add("2");
        opcionesJugador.add("1");
        opcionesJugador.add("7");
        opcionesJugador.add("5");

        Pregunta preguntaClasica = new PreguntaOC("Ordenar ascendentemente", opcionesOrdenadas, todasLasOpciones);

        int puntos = preguntaClasica.compararRespuestas(opcionesJugador);

        assertEquals(0, puntos);
    }

    @Test
    public void Test15PreguntaOCDebeTenerDosOMasOpciones() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("1");

        Set<String> opcionesCorrectas = new HashSet<>();

        assertThrows(ExcepcionPreguntaMCInvalida.class, () -> new PreguntaMCClasica("Ordenar ascendentemente", opcionesCorrectas, todasLasOpciones));
    }

    @Test
    public void Test16PreguntaOCDebeTenerCincoOMenosOpciones() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("1");
        todasLasOpciones.add("3");
        todasLasOpciones.add("8");
        todasLasOpciones.add("9");
        todasLasOpciones.add("7");
        todasLasOpciones.add("4");

        Set<String> opcionesCorrectas = new HashSet<>();

        assertThrows(ExcepcionPreguntaMCInvalida.class, () -> new PreguntaMCClasica("Ordenar ascendentemente", opcionesCorrectas, todasLasOpciones));
    }

    @Test
    public void Test17PreguntaVOFClasicaNoPuedeUsarMultiplicadorLanzaExcepcion() {
        Set<String> opcionCorrecta = new HashSet<>();
        opcionCorrecta.add("V");

        Pregunta pregunta = new PreguntaVOFClasica("Para ser grande hay que ser campeón mundial", opcionCorrecta);
        assertThrows(ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador.class, pregunta::activarMultiplicador);
    }

    @Test
    public void Test18PreguntaMCNoPuedeUsarMultiplicadorLanzaExcepcion() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("1");
        todasLasOpciones.add("2");
        todasLasOpciones.add("3");

        Set<String> opcionCorrecta = new HashSet<>();
        todasLasOpciones.add("2");

        Pregunta pregunta = new PreguntaMCClasica("Cuales de los siguientes numeros son pares", opcionCorrecta, todasLasOpciones);
        assertThrows(ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador.class, pregunta::activarMultiplicador);
    }

    @Test
    public void Test19PreguntaGCNoPuedeUsarMultiplicadorLanzaExcepcion() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("1");
        todasLasOpciones.add("2");
        todasLasOpciones.add("3");
        todasLasOpciones.add("4");

        Set<String> opcionesCorrectas = new HashSet<>();
        opcionesCorrectas.add("1");
        opcionesCorrectas.add("3");

        String[] grupos = new String[2];
        grupos[0] = "Impares";
        grupos[1] = "Pares";

        Pregunta pregunta = new PreguntaGC("Agrupar en pares e impares", opcionesCorrectas, todasLasOpciones, grupos);
        assertThrows(ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador.class, pregunta::activarMultiplicador);
    }

    @Test
    public void Test20PreguntaOCNoPuedeUsarMultiplicadorLanzaExcepcion() {
        List<String> todasLasOpciones = new LinkedList<>();
        todasLasOpciones.add("1");
        todasLasOpciones.add("2");
        todasLasOpciones.add("3");

        List<String> opcionesOrdenadas = new LinkedList<>();
        opcionesOrdenadas.add("1");
        opcionesOrdenadas.add("2");
        opcionesOrdenadas.add("3");

        Pregunta pregunta = new PreguntaOC("Cuales de los siguientes numeros son pares", opcionesOrdenadas, todasLasOpciones);
        assertThrows(ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador.class, pregunta::activarMultiplicador);
    }
}

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
        String[] opcionCorrecta = new String[1];
        opcionCorrecta[0] = "V";

        Set<String> opcionJugador = new HashSet<>();
        opcionJugador.add("V");

        Pregunta pregunta = new PreguntaVOFClasica("PreguntaVoFClasica", "Para ser grande hay que ser campeón mundial", opcionCorrecta);

        int puntos = pregunta.compararRespuestas(opcionJugador);

        assertEquals(1, puntos);
    }

    @Test
    public void Test02PreguntaVOFClasicaRespondeIncorrectamenteDevuelveCeroPuntos() {
        String[] opcionCorrecta = new String[1];
        opcionCorrecta[0] = "V";

        Set<String> opcionJugador = new HashSet<>();
        opcionJugador.add("F");

        Pregunta pregunta = new PreguntaVOFClasica("PreguntaVoFClasica", "Independiente nunca perdió su clásico con dos jugadores más", opcionCorrecta);

        int puntos = pregunta.compararRespuestas(opcionJugador);

        assertEquals(0, puntos);
    }

    @Test
    public void Test03PreguntaVOFClasicaSoloPuedeRecibirUnaOpcionCorrecta() {
        String[] opcionesCorrectas = new String[2];
        opcionesCorrectas[0] = "V";
        opcionesCorrectas[1] = "F";

        assertThrows(ExcepcionPreguntaVOFInvalida.class, () -> new PreguntaVOFClasica("PreguntaVoFClasica", "Independiente nunca perdió su clásico con dos jugadores más", opcionesCorrectas));
    }

    @Test
    public void Test04PreguntaMCClasicaRespondeCorrectamenteDevuelveUnPunto() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("1");
        todasLasOpciones.add("2");
        todasLasOpciones.add("3");
        todasLasOpciones.add("4");

        String[] opcionesCorrectas = new String[2];
        opcionesCorrectas[0] = "2";
        opcionesCorrectas[1] = "4";

        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("2");
        respuestaElegidasDelJugador.add("4");

        Pregunta pregunta = new PreguntaMCClasica("PreguntaMCClasico","Cual de estos numeros son pares", opcionesCorrectas, todasLasOpciones);

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

        String[] opcionesCorrectas = new String[2];
        opcionesCorrectas[0] = "2";
        opcionesCorrectas[1] = "4";

        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("1");
        respuestaElegidasDelJugador.add("4");

        Pregunta pregunta = new PreguntaMCClasica("PreguntaMCClasica","Cual de estos numeros son pares", opcionesCorrectas, todasLasOpciones);

        int puntos = pregunta.compararRespuestas(respuestaElegidasDelJugador);

        assertEquals(0, puntos);
    }

    @Test
    public void Test06PreguntaMCDebeTenerDosOMasOpciones() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("1");

        String[] opcionesCorrectas = new String[0];

        assertThrows(ExcepcionPreguntaMCInvalida.class, () -> new PreguntaMCClasica("PreguntaMCClasica","Cual de estos numeros son pares", opcionesCorrectas, todasLasOpciones));
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

        String[] opcionesCorrectas = new String[0];

        assertThrows(ExcepcionPreguntaMCInvalida.class, () -> new PreguntaMCClasica("PreguntaMCClasica", "Cual de estos numeros son pares", opcionesCorrectas, todasLasOpciones));
    }

    @Test
    public void Test08PreguntaGCComparaCorrectamenteYDevuelveUnPunto() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("1");
        todasLasOpciones.add("2");
        todasLasOpciones.add("3");
        todasLasOpciones.add("4");

        String[] opcionesCorrectas = new String[2];
        opcionesCorrectas[0] = "1";
        opcionesCorrectas[1] = "3";

        Set<String> opcionesJugador = new HashSet<>();
        opcionesJugador.add("1");
        opcionesJugador.add("Impares");
        opcionesJugador.add("3");

        Map<String, String> grupos= new HashMap<>();
        grupos.put("grupoAComparar","Impares");
        grupos.put("otroGrupo","Pares");

        Pregunta pregunta = new PreguntaGC("PreguntaGC","Separe los numeros en pares e impares", opcionesCorrectas, todasLasOpciones, grupos);
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

        String[] opcionesCorrectas = new String[2];
        opcionesCorrectas[0] = "1";
        opcionesCorrectas[1] = "3";

        Set<String> opcionesJugador = new HashSet<>();
        opcionesJugador.add("1");
        opcionesJugador.add("Impares");
        opcionesJugador.add("2");

        Map<String, String> grupos= new HashMap<>();
        grupos.put("grupoAComparar","Impares");
        grupos.put("otroGrupo","Pares");

        Pregunta pregunta = new PreguntaGC("PreguntaGC","Separe los numeros en pares e impares", opcionesCorrectas, todasLasOpciones, grupos);
        int puntos = pregunta.compararRespuestas(opcionesJugador);

        assertEquals(0, puntos);
    }

    @Test
    public void test10PreguntaGCDebeTenerDosOMasOpciones() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("1");

        String[] opcionesCorrectas = new String[0];

        Map<String, String> grupos= new HashMap<>();
        grupos.put("grupoAComparar","Impares");
        grupos.put("otroGrupo","Pares");
        assertThrows(ExcepcionPreguntaGCInvalida.class, () -> new PreguntaGC("PreguntaGC","Separe los numeros en pares e impares", opcionesCorrectas, todasLasOpciones, grupos));
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

        String[] opcionesCorrectas = new String[0];


        Map<String, String> grupos= new HashMap<>();
        grupos.put("grupoAComparar","Impares");
        grupos.put("otroGrupo","Pares");

        assertThrows(ExcepcionPreguntaGCInvalida.class, () -> new PreguntaGC("PreguntaGC","Separe los numeros en pares e impares", opcionesCorrectas, todasLasOpciones, grupos));
    }

    @Test
    public void test12PreguntaGCNoDebeTenerElNombreDeUnGrupoEntreSusOpciones() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("1");
        todasLasOpciones.add("2");
        todasLasOpciones.add("Impares");

        String[] opcionesCorrectas = new String[0];

        Map<String, String> grupos= new HashMap<>();
        grupos.put("grupoAComparar","Impares");
        grupos.put("otroGrupo","Pares");

        assertThrows(ExcepcionPreguntaGCInvalida.class, () -> new PreguntaGC("PreguntaGC","Separe los numeros en pares e impares", opcionesCorrectas, todasLasOpciones, grupos));
    }

    @Test
    public void Test13PreguntaClasicaOCRespondeOrdenadamenteDevuelveUnPunto() {
        List<String> todasLasOpciones = new LinkedList<>();
        todasLasOpciones.add("2");
        todasLasOpciones.add("1");
        todasLasOpciones.add("5");
        todasLasOpciones.add("7");

        String[] opcionesOrdenadas = new String[4];
        opcionesOrdenadas[0] = "1";
        opcionesOrdenadas[1] = "2";
        opcionesOrdenadas[2] = "5";
        opcionesOrdenadas[3] = "7";

        List<String> opcionesJugador = new LinkedList<>();
        opcionesJugador.add("1");
        opcionesJugador.add("2");
        opcionesJugador.add("5");
        opcionesJugador.add("7");

        Pregunta preguntaClasica = new PreguntaOC("PreguntaGC","Ordenar ascendentemente", opcionesOrdenadas, todasLasOpciones);

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

        String[] opcionesOrdenadas = new String[4];
        opcionesOrdenadas[0] = "1";
        opcionesOrdenadas[1] = "2";
        opcionesOrdenadas[2] = "5";
        opcionesOrdenadas[3] = "7";

        List<String> opcionesJugador = new LinkedList<>();
        opcionesJugador.add("2");
        opcionesJugador.add("1");
        opcionesJugador.add("7");
        opcionesJugador.add("5");

        Pregunta preguntaClasica = new PreguntaOC("PreguntaGC","Ordenar ascendentemente", opcionesOrdenadas, todasLasOpciones);

        int puntos = preguntaClasica.compararRespuestas(opcionesJugador);

        assertEquals(0, puntos);
    }

    @Test
    public void Test15PreguntaOCDebeTenerDosOMasOpciones() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("1");

        String[] opcionesCorrectas = new String[0];

        assertThrows(ExcepcionPreguntaMCInvalida.class, () -> new PreguntaMCClasica("PreguntaGC","Ordenar ascendentemente", opcionesCorrectas, todasLasOpciones));
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

        String[] opcionesCorrectas = new String[0];

        assertThrows(ExcepcionPreguntaMCInvalida.class, () -> new PreguntaMCClasica("PreguntaGC","Ordenar ascendentemente", opcionesCorrectas, todasLasOpciones));
    }

    @Test
    public void Test17PreguntaVOFClasicaNoPuedeUsarMultiplicadorLanzaExcepcion() {
        String[] opcionCorrecta = new String[1];
        opcionCorrecta[0] = "V";

        Pregunta pregunta = new PreguntaVOFClasica("PreguntaGC","Para ser grande hay que ser campeón mundial", opcionCorrecta);
        assertThrows(ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador.class, pregunta::activarMultiplicador);
    }

    @Test
    public void Test18PreguntaMCNoPuedeUsarMultiplicadorLanzaExcepcion() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("1");
        todasLasOpciones.add("2");
        todasLasOpciones.add("3");

        String[] opcionCorrecta = new String[1];
        opcionCorrecta[0] = "2";

        Pregunta pregunta = new PreguntaMCClasica("PreguntaGC","Cuales de los siguientes numeros son pares", opcionCorrecta, todasLasOpciones);
        assertThrows(ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador.class, pregunta::activarMultiplicador);
    }

    @Test
    public void Test19PreguntaGCNoPuedeUsarMultiplicadorLanzaExcepcion() {
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("1");
        todasLasOpciones.add("2");
        todasLasOpciones.add("3");
        todasLasOpciones.add("4");

        String[] opcionesCorrectas = new String[2];
        opcionesCorrectas[0] = "1";
        opcionesCorrectas[1] = "3";

        Map<String, String> grupos= new HashMap<>();
        grupos.put("grupoAComparar","Impares");
        grupos.put("otroGrupo","Pares");

        Pregunta pregunta = new PreguntaGC("PreguntaGC","Agrupar en pares e impares", opcionesCorrectas, todasLasOpciones, grupos);
        assertThrows(ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador.class, pregunta::activarMultiplicador);
    }

    @Test
    public void Test20PreguntaOCNoPuedeUsarMultiplicadorLanzaExcepcion() {
        List<String> todasLasOpciones = new LinkedList<>();
        todasLasOpciones.add("1");
        todasLasOpciones.add("2");
        todasLasOpciones.add("3");

        String[] opcionesOrdenadas = new String[3];
        opcionesOrdenadas[0] = "1";
        opcionesOrdenadas[1] = "2";
        opcionesOrdenadas[2] = "3";

        Pregunta pregunta = new PreguntaOC("PreguntaGC","Cuales de los siguientes numeros son pares", opcionesOrdenadas, todasLasOpciones);
        assertThrows(ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador.class, pregunta::activarMultiplicador);
    }
}

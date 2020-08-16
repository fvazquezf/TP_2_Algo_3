package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.excepciones.ExcepcionPreguntaGCInvalida;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionPreguntaMCInvalida;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionPreguntaVOFInvalida;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.PreguntaGC;
import edu.fiuba.algo3.modelo.preguntas.PreguntaMCClasica;
import edu.fiuba.algo3.modelo.preguntas.PreguntaVOFClasica;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PreguntasComportamientoClasicoTest {
    @Test
    public void Test01PreguntaVOFClasicaRespondeCorrectamenteDevuelveUnPunto() {
        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("V");

        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("V");

        Pregunta pregunta = new PreguntaVOFClasica("Para ser grande hay que ser campeón mundial", respuestaCorrecta);

        int puntos = pregunta.compararRespuestas(respuestaElegidasDelJugador);

        assertEquals(1, puntos);
    }

    @Test
    public void Test02PreguntaVOFClasicaRespondeIncorrectamenteDevuelveCeroPuntos() {
        Set<String> respuestaElegidasDelJugador = new HashSet<>();
        respuestaElegidasDelJugador.add("F");

        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("V");

        Pregunta pregunta = new PreguntaVOFClasica("Independiente nunca perdió su clásico con dos jugadores más", respuestaCorrecta);

        int puntos = pregunta.compararRespuestas(respuestaElegidasDelJugador);

        assertEquals(0, puntos);
    }

    @Test
    public void Test03PreguntaVOFClasicaSoloPuedeRecibirUnaOpcionCorrecta() {
        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("V");
        respuestaCorrecta.add("F");

        assertThrows(ExcepcionPreguntaVOFInvalida.class, ()-> {
            new PreguntaVOFClasica("Independiente nunca perdió su clásico con dos jugadores más", respuestaCorrecta);
        });
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

        assertThrows(ExcepcionPreguntaMCInvalida.class, ()-> {
            new PreguntaMCClasica("Cual de estos numeros son pares", opcionesCorrectas, todasLasOpciones);
        });
    }

    @Test
    public void Test07PreguntaGCComparaCorrectamenteYDevuelveUnPunto() {
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
    public void Test08PreguntaClasicaGCComparaIncorrectamenteYDevuelveCeroPuntos() {
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
        opcionesJugador.add("Pares");
        opcionesJugador.add("2");

        String[] grupos = new String[2];
        grupos[0] = "Impares";
        grupos[1] = "Pares";

        Pregunta pregunta = new PreguntaGC("Separe los numeros en pares e impares", opcionesCorrectas, todasLasOpciones, grupos);
        int puntos = pregunta.compararRespuestas(opcionesJugador);

        assertEquals(0, puntos);
    }

    @Test
    public void test09PreguntaGCDebeTenerDosOMasOpciones(){
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("1");

        Set<String> opcionesCorrectas = new HashSet<>();

        String[] grupos = new String[0];

        assertThrows(ExcepcionPreguntaGCInvalida.class, ()-> {
            new PreguntaGC("Separe los numeros en pares e impares", opcionesCorrectas, todasLasOpciones, grupos);
        });
    }

    @Test
    public void test10PreguntaGCNoDebeTenerElNombreDeUnGrupoEntreSusOpciones(){
        Set<String> todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("1");
        todasLasOpciones.add("2");
        todasLasOpciones.add("Impares");

        Set<String> opcionesCorrectas = new HashSet<>();

        String[] grupos = new String[2];
        grupos[0] = "Impares";
        grupos[1] = "Pares";

        assertThrows(ExcepcionPreguntaGCInvalida.class, ()-> {
            new PreguntaGC("Separe los numeros en pares e impares", opcionesCorrectas, todasLasOpciones, grupos);
        });
    }

//    @Test
//    public void Test09PreguntaClasicaNoPuedeUsarMultiplicadorLanzaExcepcion() {
//        Set<String> respuesta = new HashSet<>();
//        respuesta.add("V");
//        respuesta.add("F");
//
//        ComportamientoClasico pregunta = new ComportamientoClasico("pregunta", respuesta, respuesta);
//        assertThrows(ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador.class, pregunta::activarMultiplicador);
//    }
//
//
//    @Test
//    public void Test10PreguntaClasicaGroupChoiceDevuelveCeroPuntosPorNoAsignarPorCompletoLosGrupos() {
//        Set<String> respuestasCorrectas = new HashSet<>();
//        respuestasCorrectas.add("a");
//        respuestasCorrectas.add("b");
//        respuestasCorrectas.add("c");
//        respuestasCorrectas.add("grupo1");
//
//        Set<String> respuestasJugador = new HashSet<>();
//        respuestasJugador.add("a");
//        respuestasJugador.add("b");
//        respuestasJugador.add("grupo1");
//
//        ComportamientoClasico pregunta = new ComportamientoClasico("pregunta", respuestasCorrectas, respuestasCorrectas);
//        int puntos = pregunta.compararRespuestas(respuestasJugador);
//        assertEquals(0, puntos);
//    }
//
//    @Test
//    public void Test11PreguntaClasicaGroupChoiceDevuelveCeroPuntosPorAsignarIncorrectamenteLosGrupos() {
//        Set<String> respuestasCorrectas = new HashSet<>();
//        respuestasCorrectas.add("a");
//        respuestasCorrectas.add("b");
//        respuestasCorrectas.add("c");
//        respuestasCorrectas.add("grupo1");
//
//        Set<String> respuestasJugador = new HashSet<>();
//        respuestasJugador.add("z");
//        respuestasJugador.add("y");
//        respuestasJugador.add("x");
//        respuestasJugador.add("grupo1");
//
//        ComportamientoClasico pregunta = new ComportamientoClasico("pregunta", respuestasCorrectas, respuestasCorrectas);
//        int puntos = pregunta.compararRespuestas(respuestasJugador);
//        assertEquals(0, puntos);
//    }
//
//    @Test
//    public void Test11PreguntaClasicaOC() {
//        List<String> respuestaElegidasDelJugador = new LinkedList<>();
//
//        List<String> respuestasCorrectas = new LinkedList<>();
//        respuestasCorrectas.add("1");
//        respuestasCorrectas.add("2");
//        respuestasCorrectas.add("3");
//
//        ComportamientoClasico preguntaClasica = new ComportamientoClasico("Pregunta", respuestasCorrectas, respuestasCorrectas);
//
//        int puntos = preguntaClasica.compararRespuestas(respuestaElegidasDelJugador);
//
//        assertEquals(0, puntos);
//    }

}

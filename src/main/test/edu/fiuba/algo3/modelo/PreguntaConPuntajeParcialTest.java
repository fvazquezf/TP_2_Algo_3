//package edu.fiuba.algo3.modelo;
//
//import edu.fiuba.algo3.modelo.excepciones.ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador;
//import edu.fiuba.algo3.modelo.preguntas.ComportamientoConPuntajeParcial;
//import org.junit.jupiter.api.Test;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//public class PreguntaConPuntajeParcialTest {
//    @Test
//    public void Test01PreguntaConPuntajeParcialConUnaOpcionCorrectaSeComparaCorrectamenteYDevuelveUnPunto() {
//        Set<String> respuestaElegidasDelJugador = new HashSet<>();
//        respuestaElegidasDelJugador.add("a");
//
//        Set<String> respuestasCorrectas = new HashSet<>();
//        respuestasCorrectas.add("a");
//
//        ComportamientoConPuntajeParcial preguntaConPuntajeParcial = new ComportamientoConPuntajeParcial("Pregunta", respuestasCorrectas, respuestasCorrectas);
//
//        int puntos = preguntaConPuntajeParcial.compararRespuestas(respuestaElegidasDelJugador);
//
//        assertEquals(1, puntos);
//    }
//
//    @Test
//    public void Test02PreguntaConPuntajeParcialConDosOpcionCorrectasSeComparaParcialmenteYDevuelveUnPunto() {
//        Set<String> respuestaElegidasDelJugador = new HashSet<>();
//        respuestaElegidasDelJugador.add("a");
//
//        Set<String> respuestasCorrectas = new HashSet<>();
//        respuestasCorrectas.add("a");
//        respuestasCorrectas.add("b");
//
//        ComportamientoConPuntajeParcial preguntaConPuntajeParcial = new ComportamientoConPuntajeParcial("Pregunta", respuestasCorrectas, respuestasCorrectas);
//
//        int puntos = preguntaConPuntajeParcial.compararRespuestas(respuestaElegidasDelJugador);
//
//        assertEquals(1, puntos);
//    }
//
//    @Test
//    public void Test03PreguntaConPuntajeParcialConDosOpcionCorrectasSeComparaIncorrectamenteYDevuelveCeroPuntos() {
//        Set<String> respuestaElegidasDelJugador = new HashSet<>();
//        respuestaElegidasDelJugador.add("c");
//        respuestaElegidasDelJugador.add("a");
//
//        Set<String> respuestasCorrectas = new HashSet<>();
//        respuestasCorrectas.add("a");
//        respuestasCorrectas.add("b");
//
//        ComportamientoConPuntajeParcial preguntaConPuntajeParcial = new ComportamientoConPuntajeParcial("Pregunta", respuestasCorrectas, respuestasCorrectas);
//
//        int puntos = preguntaConPuntajeParcial.compararRespuestas(respuestaElegidasDelJugador);
//
//        assertEquals(0, puntos);
//    }
//
//    @Test
//    public void Test04PreguntaConPuntajeParcialConCuatroOpcionesCorrectasYEligeTresOpcionCorrectasYDevuelveTresPuntos() {
//        Set<String> respuestaElegidasDelJugador = new HashSet<>();
//        respuestaElegidasDelJugador.add("c");
//        respuestaElegidasDelJugador.add("a");
//        respuestaElegidasDelJugador.add("b");
//
//        Set<String> respuestasCorrectas = new HashSet<>();
//        respuestasCorrectas.add("a");
//        respuestasCorrectas.add("c");
//        respuestasCorrectas.add("d");
//        respuestasCorrectas.add("b");
//
//        ComportamientoConPuntajeParcial preguntaConPuntajeParcial = new ComportamientoConPuntajeParcial("Pregunta", respuestasCorrectas, respuestasCorrectas);
//
//        int puntos = preguntaConPuntajeParcial.compararRespuestas(respuestaElegidasDelJugador);
//
//        assertEquals(3, puntos);
//    }
//
//    @Test
//    public void Test05PreguntaConPuntajeParcialNoPuedeUsarMultiplicadorLanzaExcepcion() {
//        Set<String> respuesta = new HashSet<>();
//        respuesta.add("V");
//        respuesta.add("F");
//
//        ComportamientoConPuntajeParcial pregunta = new ComportamientoConPuntajeParcial("pregunta", respuesta,respuesta );
//        assertThrows(ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador.class, pregunta::activarMultiplicador);
//    }
//}

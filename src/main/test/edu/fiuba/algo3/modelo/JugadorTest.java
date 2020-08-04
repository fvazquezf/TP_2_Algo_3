package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {
    @Test
    public void Test01AsignoTresPuntosAJugadorNoUsaMultiplicadorDevuelveTresPuntos() {
        Jugador jugador1 = new Jugador("Rulo");
        jugador1.asignarPuntos(3);
        assertEquals(3, jugador1.pedirPuntos());
    }

    @Test
    public void Test02AsignoTresPuntosAJugadorUsaDuplicadorDevuelveSeisPuntos() {
        Jugador jugador1 = new Jugador("Rulo");
        jugador1.estadoDuplicador();
        jugador1.asignarPuntos(3);
        assertEquals(6, jugador1.pedirPuntos());
    }

    @Test
    public void Test03AsignoUnPuntoAJugadorUsaDuplicadorDevuelveDosPuntosYNoPuedeVolverAUsarDuplicador() {
        Jugador jugador1 = new Jugador("Rulo");
        jugador1.estadoDuplicador();
        jugador1.asignarPuntos(3);
        assertEquals(6, jugador1.pedirPuntos());
        try {
            jugador1.estadoDuplicador();
        } catch (ExcepcionYaUsasteTuDuplicadorSalame excepcion) {
        }
    }

    @Test
    public void Test04AsignoDosPuntosAJugadorUsaTriplicadorDevuelveSeisPuntos() {
        Jugador jugador1 = new Jugador("Rulo");
        jugador1.estadoTriplicador();
        jugador1.asignarPuntos(2);
        assertEquals(6, jugador1.pedirPuntos());
    }

    @Test
    public void Test05AsignoUnPuntoAJugadorUsaTriplicadorDevuelveTresPuntosYNoPuedeVolverAUsarTriplicador() {
        Jugador jugador1 = new Jugador("Rulo");
        jugador1.estadoTriplicador();
        jugador1.asignarPuntos(1);
        assertEquals(3, jugador1.pedirPuntos());
        try {
            jugador1.estadoTriplicador();
        } catch (ExcepcionYaUsasteTuTriplicadorSalame excepcion) {
        }
    }
}

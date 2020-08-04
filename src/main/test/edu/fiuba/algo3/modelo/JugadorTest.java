package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertThrows(ExcepcionYaUsasteTuDuplicadorSalame.class, () -> {
            jugador1.estadoDuplicador();
        });
    }

    @Test
    public void Test04AsignoUnPuntoAJugadorUsaDuplicadorNoPuedeVolverAUsarDuplicadorYVuelveAUniplicador() {
        Jugador jugador1 = new Jugador("Rulo");
        jugador1.estadoDuplicador();
        jugador1.asignarPuntos(1);
        assertEquals(2, jugador1.pedirPuntos());
        assertThrows(ExcepcionYaUsasteTuDuplicadorSalame.class, () -> {
            jugador1.estadoDuplicador();
        });
        jugador1.asignarPuntos(5);
        assertEquals(7, jugador1.pedirPuntos());
    }

    @Test
    public void Test05AsignoDosPuntosAJugadorUsaTriplicadorDevuelveSeisPuntos() {
        Jugador jugador1 = new Jugador("Rulo");
        jugador1.estadoTriplicador();
        jugador1.asignarPuntos(2);
        assertEquals(6, jugador1.pedirPuntos());
    }

    @Test
    public void Test06AsignoUnPuntoAJugadorUsaTriplicadorDevuelveTresPuntosYNoPuedeVolverAUsarTriplicador() {
        Jugador jugador1 = new Jugador("Rulo");
        jugador1.estadoTriplicador();
        jugador1.asignarPuntos(1);
        assertEquals(3, jugador1.pedirPuntos());
        assertThrows(ExcepcionYaUsasteTuTriplicadorSalame.class, () -> {
            jugador1.estadoTriplicador();
        });
    }

    @Test
    public void Test07AsignoUnPuntoAJugadorUsaTriplicadorNoPuedeVolverAUsarTriplicadorYVuelveAUniplicador() {
        Jugador jugador1 = new Jugador("Rulo");
        jugador1.estadoTriplicador();
        jugador1.asignarPuntos(1);
        assertEquals(3, jugador1.pedirPuntos());
        assertThrows(ExcepcionYaUsasteTuTriplicadorSalame.class, () -> {
            jugador1.estadoTriplicador();
        });
        jugador1.asignarPuntos(2);
        assertEquals(5, jugador1.pedirPuntos());
    }
}

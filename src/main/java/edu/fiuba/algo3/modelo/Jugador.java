package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.multiplicadores.Duplicador;
import edu.fiuba.algo3.modelo.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.multiplicadores.Triplicador;
import edu.fiuba.algo3.modelo.multiplicadores.Uniplicador;

public class Jugador {

    private final String nombre;
    private int puntos;
    private Multiplicador multiplicador;
    private int duplicadoresDisponibles;
    private int triplicadoresDisponibles;

    public Jugador(String nombre) {
        this.nombre = nombre;
        puntos = 0;
        multiplicador = new Uniplicador();
        duplicadoresDisponibles = 1;
        triplicadoresDisponibles = 1;
    }

    public int pedirPuntos() {
        return puntos;
    }

    public void estadoDuplicador() {
        multiplicador = new Duplicador(duplicadoresDisponibles);
        duplicadoresDisponibles--;
    }

    public void estadoTriplicador() {
        multiplicador = new Triplicador(triplicadoresDisponibles);
        triplicadoresDisponibles--;
    }

    public void asignarPuntos(int puntos) {
        this.puntos += multiplicador.multiplicar(puntos);
        multiplicador = new Uniplicador();
    }
}



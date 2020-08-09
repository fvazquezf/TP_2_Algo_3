package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.multiplicadores.*;

public class Jugador {

    private final String nombre;
    private int puntos;
    private EstadoMultiplicador estadoMultiplicador;


    public Jugador(String nombre) {
        this.nombre = nombre;
        puntos = 0;
        estadoMultiplicador = new EstadoMultiplicador();
    }

    public int pedirPuntos() {
        return puntos;
    }

    public void estadoDuplicador() {
        estadoMultiplicador.estadoDuplicador();
    }

    public void estadoTriplicador() {
        estadoMultiplicador.estadoTriplicador();
    }

    public void asignarPuntos(int puntos) {
        this.puntos += estadoMultiplicador.multiplicar(puntos);
    }

    public void estadoExclusividad() {
        estadoMultiplicador.estadoExclusividad();
    }
}



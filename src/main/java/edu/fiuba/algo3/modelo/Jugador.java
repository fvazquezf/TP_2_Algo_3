package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.multiplicadores.*;

public class Jugador {

    private final String nombre;
    private int puntos = 0;
    private EstadoMultiplicador estadoMultiplicador = new EstadoMultiplicador();
    private int exclusividadDisponible = 2;


    public Jugador(String nombre) {
        this.nombre = nombre;
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

    public void activarExclusividad() {
        if(exclusividadDisponible == 0){
            throw new ExcepcionYaUsasteLasExclusividadesSalame();
        }
        exclusividadDisponible--;
    }
}



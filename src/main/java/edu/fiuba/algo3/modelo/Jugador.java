package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaUsasteLasExclusividadesSalame;
import edu.fiuba.algo3.modelo.multiplicadores.*;

import java.util.ArrayList;
import java.util.List;

public class Jugador implements Observable {

    private final String nombre;
    private int puntos = 0;
    private final EstadoMultiplicador estadoMultiplicador = new EstadoMultiplicador();
    private int exclusividadDisponible = 2;
    private final List<Observador> observadores = new ArrayList<>();


    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public int pedirPuntos() {
        return puntos;
    }

    public String pedirNombre() {
        return nombre;
    }

    public void asignarPuntos(int puntos) {
        this.puntos += estadoMultiplicador.multiplicar(puntos);
        this.notificarObservador();
    }

    public void activarExclusividad() {
        if (exclusividadDisponible == 0) {
            throw new ExcepcionYaUsasteLasExclusividadesSalame();
        }
        exclusividadDisponible--;
    }

    public void activarDuplicador() {
        estadoMultiplicador.activarDuplicador();
    }

    public void activarTriplicador() {
        estadoMultiplicador.activarTriplicador();
    }

    @Override
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void notificarObservador() {
        observadores.forEach(Observador::actualizar);
    }
}



package edu.fiuba.algo3.modelo.multiplicadores;

public class Uniplicador implements Multiplicador {
    public Integer multiplicar(int puntos) {
        return puntos;
    }

    public Multiplicador proximo(){
        return new Triplicador();
    }
}

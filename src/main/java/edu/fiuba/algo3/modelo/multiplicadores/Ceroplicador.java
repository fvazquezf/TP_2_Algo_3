package edu.fiuba.algo3.modelo.multiplicadores;

public class Ceroplicador implements Multiplicador {
    @Override
    public Integer multiplicar(int puntos) {
        return 0;
    }

    public Multiplicador proximo(){
        return new Uniplicador();
    }
}

package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.multiplicadores.Uniplicador;

public class Ceroplicador implements Multiplicador {
    @Override
    public Integer multiplicar(int puntos) {
        return 0;
    }

    public Multiplicador proximo(){
        return new Uniplicador();
    }
}

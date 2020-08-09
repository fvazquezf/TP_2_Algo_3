package edu.fiuba.algo3.modelo.multiplicadores;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaUsasteTuDuplicadorSalame;

public class Duplicador implements Multiplicador {
    //private final int duplicadoresDisponibles;

    public Duplicador(Integer duplicadoresDisponibles) {
        //this.duplicadoresDisponibles = duplicadoresDisponibles;
        if (duplicadoresDisponibles <= 0)
            throw new ExcepcionYaUsasteTuDuplicadorSalame();
    }

    public Integer multiplicar(int puntos) {
        return puntos * 2;
    }
}

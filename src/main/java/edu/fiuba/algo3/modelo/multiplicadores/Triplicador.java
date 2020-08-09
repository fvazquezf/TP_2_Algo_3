package edu.fiuba.algo3.modelo.multiplicadores;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaUsasteTuTriplicadorSalame;

public class Triplicador implements Multiplicador {
    //private final int triplicadoresDisponibles;

    public Triplicador(Integer triplicadoresDisponibles) {
        //this.triplicadoresDisponibles = triplicadoresDisponibles;
        if (triplicadoresDisponibles <= 0)
            throw new ExcepcionYaUsasteTuTriplicadorSalame();
    }

    public Integer multiplicar(int puntos) {
        return puntos * 3;
    }
}

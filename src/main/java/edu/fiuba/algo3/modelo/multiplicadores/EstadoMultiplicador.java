package edu.fiuba.algo3.modelo.multiplicadores;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaUsasteTuDuplicadorSalame;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaUsasteTuTriplicadorSalame;

public class EstadoMultiplicador {

    private Uniplicador uniplicador;
    private Duplicador duplicador;
    private Triplicador triplicador;
    private Multiplicador multiplicadorActual;
    Integer cantidadDuplicador;
    Integer cantidadTriplicador;

    public EstadoMultiplicador() {
        uniplicador = new Uniplicador();
        duplicador = new Duplicador();
        triplicador = new Triplicador();
        multiplicadorActual = uniplicador;
        cantidadDuplicador = 1;
        cantidadTriplicador = 1;
    }

    public Integer multiplicar(int puntos) {
        return multiplicadorActual.multiplicar(puntos);
    }

    public void setearUnificador() {
        multiplicadorActual = uniplicador;
    }

    public void setearDuplicador() {
        if (cantidadDuplicador < 1)
            throw new ExcepcionYaUsasteTuDuplicadorSalame();
        multiplicadorActual = duplicador;
        cantidadDuplicador--;
    }

    public void setearTriplicador() {
        if (cantidadTriplicador < 1)
            throw new ExcepcionYaUsasteTuTriplicadorSalame();
        multiplicadorActual = triplicador;
        cantidadTriplicador--;
    }
}

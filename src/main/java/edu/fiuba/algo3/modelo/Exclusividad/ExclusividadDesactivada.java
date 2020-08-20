package edu.fiuba.algo3.modelo.Exclusividad;


public class ExclusividadDesactivada implements Exclusividad {

    public Integer multiplicar(int puntos) {
        return 0;
    }

    public Exclusividad proximo() {
        return new ExclusividadSimple();
    }
}

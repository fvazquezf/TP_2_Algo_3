package edu.fiuba.algo3.modelo;

public interface Observable {
    void agregarObservador(Observador observador);

    void notificarObservador();
}

package edu.fiuba.algo3.modelo;

public class Pregunta {
    private final boolean respuesta;
    private final String textoPregunta;

    public Pregunta(String unaPregunta, boolean unaRespuesta) {
        textoPregunta = unaPregunta;
        respuesta = unaRespuesta;
    }

    public boolean pasarRespuesta() {
        return respuesta;
    }

    public boolean chequearRespuesta(boolean b) {
        return (respuesta == b);
    }
}

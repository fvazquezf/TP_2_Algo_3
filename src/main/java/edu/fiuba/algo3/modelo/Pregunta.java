package edu.fiuba.algo3.modelo;

public class Pregunta {
    private final boolean respuesta;
    private final String textoPregunta;

    public Pregunta(String s, boolean b) {
        textoPregunta = s;
        respuesta = b;
    }

    public boolean pasarRespuesta() {
        return respuesta;
    }

    public boolean chequearRespuesta(boolean b) {
        return (respuesta == b);
    }
}

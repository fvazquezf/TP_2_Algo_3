package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMCClasicaTest {

    @Test
    public void Test01CrearMCCon3PosiblesRespuestas() {

        ArrayList<Boolean> respuestas = new ArrayList();
        respuestas.add(true);
        respuestas.add(false);
        respuestas.add(false);

        Panel panel = new Panel();
        panel.crearPregunta("preguntaMCClasica","De que color era el caballo blanco de San Martin?", respuestas);

        assertEquals("De que color era el caballo blanco de San Martin?", panel.pasarPregunta());
    }

}

import edu.fiuba.algo3.modelo.RespuestaClasica;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RespuestasClasicasTest {
    @Test
    public void Test01CrearRespuestaClasica() {
        List<String> respuestaElegidasDelJugador = new ArrayList<>();
        respuestaElegidasDelJugador.add("Verdadero");
        RespuestaClasica respuestaDelJugador = new RespuestaClasica(respuestaElegidasDelJugador);

        List<String> respuestasCorrectas = new ArrayList<>();
        respuestasCorrectas.add("Verdadero");
        RespuestaClasica respuestaCorrecta = new RespuestaClasica(respuestasCorrectas);

        

    }
}

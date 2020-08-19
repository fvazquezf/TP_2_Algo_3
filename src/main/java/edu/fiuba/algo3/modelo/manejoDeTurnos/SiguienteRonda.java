package edu.fiuba.algo3.modelo.manejoDeTurnos;

import edu.fiuba.algo3.modelo.Panel;

public class SiguienteRonda implements FlowDelJuego{
    @Override
    public void siguienteTurno(Panel panel) {
        panel.calcularExclusividad();
        panel.siguienteJugador();
        panel.siguientePregunta();
    }

    @Override
    public FlowDelJuego siguiente() {
        return new SiguienteTurno();
    }

}

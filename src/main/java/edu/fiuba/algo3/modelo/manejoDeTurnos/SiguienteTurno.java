package edu.fiuba.algo3.modelo.manejoDeTurnos;

import edu.fiuba.algo3.modelo.Panel;

public class SiguienteTurno implements FlowDelJuego {
    @Override
    public void siguienteTurno(Panel panel) {
        panel.siguienteJugador();
    }

    @Override
    public FlowDelJuego siguiente() {
        return new SiguienteRonda();
    }

}

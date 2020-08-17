package edu.fiuba.algo3.modelo.manejoDeTurnos;

import edu.fiuba.algo3.modelo.Panel;

public class SiguienteRonda implements FlowDelJuego{
    @Override
    public void siguienteTurno(Panel panel) {
        panel.calcularExclusividad();
        panel.siguientePregunta();
        panel.siguienteJugador();
    }

    @Override
    public FlowDelJuego siguiente() {
        return new SiguienteTurno();
    }
}

package edu.fiuba.algo3.modelo.manejoDeTurnos;

import edu.fiuba.algo3.modelo.Panel;

public interface FlowDelJuego {
    void siguienteTurno(Panel panel);
    FlowDelJuego siguiente();
    void siguientePregunta(Panel panel);
}

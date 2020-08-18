package edu.fiuba.algo3.modelo.manejoDeTurnos;

import edu.fiuba.algo3.modelo.Panel;

public class EstadoFlowDelJuego {
    private FlowDelJuego flow = new SiguienteTurno();

    public void proximoEstado(Panel panel){
        flow.siguienteTurno(panel);
        flow = flow.siguiente();
        panel.obtenerPreguntaActual().notificarObservador();
    }
}

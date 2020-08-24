package edu.fiuba.algo3;

import java.util.HashMap;
import java.util.Map;

public class Grupo {
    public final String grupoAComparar;
    public final String otroGrupo;

    public Grupo(String grupoAComprar, String otroGrupo) {
        this.grupoAComparar = grupoAComprar;
        this.otroGrupo = otroGrupo;
    }

    public Map<String, String> obtenerGrupos() {
        Map<String, String> grupos = new HashMap<>();
        grupos.put("grupoAComparar", grupoAComparar);
        grupos.put("otroGrupo", otroGrupo);
        return grupos;
    }
}

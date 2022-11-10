package Observador.Principal;

import Observador.Concreto.Castillo;
import Observador.Concreto.Observador;

import java.util.HashMap;

public class Gestor_Observador {
    private Castillo castillos;
    private Observador observador;

    public Gestor_Observador() {
        castillos=new Castillo();
        observador=new Observador();
        castillos.enlazarObservador(observador);
    }

    public void NuevasVidas(int vidas1, int vidas2) {
        castillos.cambiarVidas(vidas1,vidas2);
    }

}

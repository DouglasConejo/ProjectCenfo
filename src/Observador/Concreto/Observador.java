package Observador.Concreto;

import Observador.Interfaces.IObservador;
import SwingTablero.JuegoTablero;


    public class Observador implements IObservador {

        public void update(int vidas1, int vidas2) {
            String gano= "";
            if(vidas1==0) {
                gano = "jugador 2";
                JuegoTablero.gameOver(gano);

            }else if(vidas2==0){
                gano="jugador 1";
                JuegoTablero.gameOver(gano);
            }else{
                gano="todavia ninguno";
            }

        }
}

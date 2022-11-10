package Decorador.Decorador_Concreto.Ataque_Especial.Artillero_Concreto;

import Decorador.Componente.Personaje;
import Decorador.Decorador.ObjDecorado;

public class Ataca2CasillasDistancia extends ObjDecorado {

    public Ataca2CasillasDistancia(Personaje pPersona) {
        this.pArmada = pPersona;
    }

    @Override
    public String getNombre() {
        return this.pArmada.getNombre() + " ";

    }
    /*Aqui es donde se hará el ataque a las 2 casillas, pero se necesita del tablero para hacer este ataque especial*/
    @Override
    public double getAtaque() {
        return this.pArmada.getAtaque();
    }

    @Override
    public void setAtaque(double ataque) {

    }

    @Override
    public double getDefensa() {
        return this.pArmada.getDefensa();
    }

    @Override
    public void setDefensa(double defensa) {

    }

    @Override
    public int getVida() {
        return this.pArmada.getVida();
    }

    @Override
    public void setVida(int vida) {

    }

    @Override
    public int getMovimiento() {
        return this.pArmada.getMovimiento();
    }

    @Override
    public void setMovimiento(int movimiento) {

    }

    @Override
    public int getPuntos() {
        return this.pArmada.getPuntos();
    }

    @Override
    public void setPunto(int puntos) {

    }

    @Override
    public double getProteccion() {
        return this.pArmada.getProteccion();
    }

    @Override
    public void setProteccion(double proteccion) {

    }

    @Override
    public int getRango() {
        return this.pArmada.getRango()+2;
    }

    @Override
    public int setRanqo(int rango) {
        return 0;
    }


    @Override
    public String getAtaqueEspecial() {
        return this.pArmada.getAtaqueEspecial();
    }

    @Override
    public int getID() {
        return this.pArmada.getID();
    }

    @Override
    public void setID(int ID) {

    }
}

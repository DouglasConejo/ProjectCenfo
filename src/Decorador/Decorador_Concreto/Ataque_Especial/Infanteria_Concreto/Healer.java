package Decorador.Decorador_Concreto.Ataque_Especial.Infanteria_Concreto;

import Decorador.Componente.Personaje;
import Decorador.Decorador.ObjDecorado;

public class Healer extends ObjDecorado {


    public Healer(Personaje pPersona) {
        this.pArmada = pPersona;
    }

    @Override
    public String getNombre() {
        return this.pArmada.getNombre() + " ";
    }

    @Override
    public double getAtaque() {
        return this.pArmada.getAtaque() + 3;
    }

    @Override
    public void setAtaque(double ataque) {

    }

    @Override
    public double getDefensa() {
        return this.pArmada.getDefensa() + 3;
    }

    @Override
    public void setDefensa(double defensa) {

    }

    @Override
    public int getVida() {
        return this.pArmada.getVida()+1;
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
        return this.pArmada.getProteccion() ;
    }

    @Override
    public void setProteccion(double proteccion) {

    }

    @Override
    public int getRango() {
        return this.pArmada.getRango();
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
